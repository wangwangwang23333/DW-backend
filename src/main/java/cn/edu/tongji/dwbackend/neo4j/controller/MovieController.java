package cn.edu.tongji.dwbackend.neo4j.controller;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MovieController类
 *
 * @author 汪明杰
 * @date 2021/11/28 15:52
 */

@RestController
@RequestMapping("/neo4j/movie")
public class MovieController {
    private final Driver driver;

    public MovieController(Driver driver){
        this.driver = driver;
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String,Object> getMovieByCondition(@RequestParam(required = false) String movieName,
                                                      @RequestParam(required = false) String category,
                                                      @RequestParam(required = false) List<String> directorNames,
                                                      @RequestParam(required = false) List<String> mainActors,
                                                      @RequestParam(required = false) List<String> actors,
                                                      @RequestParam(required = false) String minScore,
                                                      @RequestParam(required = false) String maxScore,
                                                      @RequestParam(required = false) Integer minYear,
                                                      @RequestParam(required = false) Integer minMonth,
                                                      @RequestParam(required = false) Integer minDay,
                                                      @RequestParam(required = false) Integer maxYear,
                                                      @RequestParam(required = false) Integer maxMonth,
                                                      @RequestParam(required = false) Integer maxDay) {

        // match (m:Movie), (m)-[:Belong]->(c:Category{name:'DTS'}) where m.title = 'Book and Sword' return count(m)
        // where m.year*10000+m.month*100+m.day >=20101102
        // 导演：match (m:Movie), (m)<-[:MainAct]-(:Person{name:'Santana'}),(m)<-[:MainAct]-(:Person{name:'Treglia'})
        // 评分用 where

        try (Session session = driver.session()) {
            String query = "match (m:Movie) ";
            if (category != null){
                query +=" , (m)-[:Belong]->(:Category{name:'"+category+"'}) ";
            }

            // 导演名称
            if(directorNames != null){
                for(String directorName: directorNames){
                    query += " ,(m)<-[:Direct]-(:Person{name;'"+directorName+"'})";
                }
            }

            // 主演名称
            if(mainActors != null){
                for(String mainActor: mainActors){
                    query += " ,(m)<-[:MainAct]-(:Person{name;'"+mainActor+"'})";
                }
            }

            // 演员名称
            if(actors != null){
                for(String actor: actors){
                    query += " ,(m)<-[:Act]-(:Person{name;'"+actor+"'})";
                }
            }

            Boolean whereAppear = false;
            // 电影名称
            if(movieName != null){
                query += " where m.title='"+movieName+"' ";
                whereAppear = true;
            }

            // 最低评分
            if (minScore != null){
                if (whereAppear){
                    query+= " and ";
                }
                else {
                    query += " where ";
                    whereAppear = true;
                }
                query += " m.score >="+ minScore+" ";
            }

            // 最高评分
            if (maxScore != null){
                if (whereAppear){
                    query+= " and ";
                }
                else {
                    query += " where ";
                    whereAppear = true;
                }
                query+=" m.score <= "+maxScore+" ";
            }


            // 上映时间
            if(minYear!=null){
                if (whereAppear){
                    query+= " and ";
                }
                else {
                    query += " where ";
                    whereAppear = true;
                }
                query+=" m.year*10000+m.month*100+m.day >= "+(10000*minYear+100*minMonth+minDay)+" ";
            }
            if(maxYear!=null){
                if (whereAppear){
                    query+= " and ";
                }
                else {
                    query += " where ";
                    whereAppear = true;
                }
                query+=" m.year*10000+m.month*100+m.day <= "+(10000*maxYear+100*maxMonth+maxDay)+" ";
            }

            query+=" return m.title ";
            System.out.println("查询语句为: "+query);

            // 记录开始时间
            long startTime = System.currentTimeMillis();
            Result res=
                    session.run(query);

            // 记录结束时间
            long endTime = System.currentTimeMillis();


            HashMap<String,Object> response = new HashMap<>();

            List<Record> result = res.list();

            response.put("movies",res
                    .list(r -> r.get(0).asString()));
            response.put("time",endTime-startTime);

            return response;
        }
    }

    @GetMapping(path = "/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, Object> findMovieByName(@RequestParam String name){
        try (Session session = driver.session()) {
            // 记录开始时间
            long startTime = System.currentTimeMillis();
            Result res=
                    session.run("match (n:Movie) where n.name contains('"+name+"') return n");

            // 记录结束时间
            long endTime = System.currentTimeMillis();


            HashMap<String,Object> response = new HashMap<>();
            response.put("movies",res
                    .list(r -> r.get("m").asNode().get("address").asString()));
            response.put("time",endTime-startTime);

            return response;
        }
    }

    @GetMapping(path = "/director",produces =  MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, Object> findMovieByDirectorName(@RequestParam String name){
        //
        try (Session session = driver.session()) {
            // 记录开始时间
            long startTime = System.currentTimeMillis();
            Result res=
                    session.run("Match (d:Person{name:'"+name+"'})-[r:Direct]->(m:Movie) return m.name");

            // 记录结束时间
            long endTime = System.currentTimeMillis();


            HashMap<String,Object> response = new HashMap<>();
            response.put("movies",res
                    .list(r -> r.get(0).asString()));
            response.put("time",endTime-startTime);

            return response;
        }
    }

    @GetMapping(path = "/mainactor",produces =  MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, Object> findMovieByMainActorName(@RequestParam String name){
        //
        try (Session session = driver.session()) {
            // 记录开始时间
            long startTime = System.currentTimeMillis();
            Result res=
                    session.run("Match (d:Person{name:'"+name+"'})-[r:MainAct]->(m:Movie) return m.name");

            // 记录结束时间
            long endTime = System.currentTimeMillis();


            HashMap<String,Object> response = new HashMap<>();
            response.put("movies",res
                    .list(r -> r.get(0).asString()));
            response.put("time",endTime-startTime);

            return response;
        }
    }

    @GetMapping(path = "/actor",produces =  MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, Object> findMovieByActorName(@RequestParam String name){
        //
        try (Session session = driver.session()) {
            // 记录开始时间
            long startTime = System.currentTimeMillis();
            Result res=
                    session.run("Match (d:Person{name:'"+name+"'})-[r:Act]->(m:Movie) return m.name");

            // 记录结束时间
            long endTime = System.currentTimeMillis();


            HashMap<String,Object> response = new HashMap<>();
            response.put("movies",res
                    .list(r -> r.get(0).asString()));
            response.put("time",endTime-startTime);

            return response;
        }
    }




}
