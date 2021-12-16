package cn.edu.tongji.dwbackend.neo4j.controller;

import cn.edu.tongji.dwbackend.dto.MovieInfoDto;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.internal.value.NullValue;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
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

    @RequestMapping(method = RequestMethod.POST)
    public HashMap<String,Object> getMovieByCondition(@RequestBody  MovieInfoDto movieInfo) {

        // match (m:Movie), (m)-[:Belong]->(c:Category{name:'DTS'}) where m.title = 'Book and Sword' return count(m)
        // where m.year*10000+m.month*100+m.day >=20101102
        // 导演：match (m:Movie), (m)<-[:MainAct]-(:Person{name:'Santana'}),(m)<-[:MainAct]-(:Person{name:'Treglia'})
        // 评分用 where
        try (Session session = driver.session()) {
            String query = "match (m:Movie) ";
            if (movieInfo.getCategory() != null){
                query +=" , (m)-[:Belong]->(:Category{name:\""+movieInfo.getCategory()+"\"}) ";
            }

            // 导演名称
            if(movieInfo.getDirectorNames() != null){
                for(String directorName: movieInfo.getDirectorNames()){
                    query += " ,(m)<-[:Direct]-(:Person{name:\""+directorName+"\"})";
                }
            }

            // 主演名称
            if(movieInfo.getMainActors() != null){
                for(String mainActor: movieInfo.getMainActors()){
                    query += " ,(m)<-[:MainAct]-(:Person{name:\""+mainActor+"\"})";
                }
            }

            // 演员名称
            if(movieInfo.getActors() != null){
                for(String actor: movieInfo.getActors()){
                    query += " ,(m)<-[:Act]-(:Person{name:\""+actor+"\"})";
                }
            }

            Boolean whereAppear = false;
            // 电影名称
            if(movieInfo.getMovieName() != null){
                query += " where m.title=\""+movieInfo.getMovieName()+"\" ";
                whereAppear = true;
            }

            // 最低评分
            if (movieInfo.getMinScore() != null){
                if (whereAppear){
                    query+= " and ";
                }
                else {
                    query += " where ";
                    whereAppear = true;
                }
                query += " m.score >="+ movieInfo.getMinScore()+" ";
            }

            // 最高评分
            if (movieInfo.getMaxScore() != null){
                if (whereAppear){
                    query+= " and ";
                }
                else {
                    query += " where ";
                    whereAppear = true;
                }
                query+=" m.score <= "+movieInfo.getMaxScore()+" ";
            }


            // 上映时间
            if(movieInfo.getMinYear()!=null){
                if (whereAppear){
                    query+= " and ";
                }
                else {
                    query += " where ";
                    whereAppear = true;
                }
                query+=" m.year*10000+m.month*100+m.day >= "+
                        (10000*movieInfo.getMinYear()+100*movieInfo.getMinMonth()+movieInfo.getMinDay())+" ";
            }
            if(movieInfo.getMaxYear()!=null){
                if (whereAppear){
                    query+= " and ";
                }
                else {
                    query += " where ";
                    whereAppear = true;
                }
                query+=" m.year*10000+m.month*100+m.day <= "+
                        (10000*movieInfo.getMaxYear()+100*movieInfo.getMaxMonth()+movieInfo.getMaxDay())+" ";
            }

            if(movieInfo.getPositive()!=null){
                if (whereAppear){
                    query+= " and ";
                }
                else {
                    query += " where ";
                    whereAppear = true;
                }
                query+=" m.positive>= "+
                        String.valueOf(movieInfo.getPositive() * 1.0 / 100)+" ";
            }

            query+=" return m ";
            System.out.println("查询语句为: "+query);

            // 记录开始时间
            long startTime = System.currentTimeMillis();
            Result res=
                    session.run(query);




            HashMap<String,Object> response = new HashMap<>();

            List<Record> result = res.list();

            List<HashMap<String, Object>> movieResult = new ArrayList<>();
            // 记录结束时间
            long endTime = System.currentTimeMillis();
            // 返回50条
            for(int i=0;i<result.size() && i <50;++i){
                HashMap<String, Object> movieNode = new HashMap<>();
                if (result.get(i).get(0).get("asin") != NullValue.NULL){
                    movieNode.put("asin",result.get(i).get(0).get("asin").asString());
                }
                if (result.get(i).get(0).get("title") != NullValue.NULL){
                    movieNode.put("title",result.get(i).get(0).get("title").asString());
                }
                if (result.get(i).get(0).get("format") != NullValue.NULL){
                    movieNode.put("format",result.get(i).get(0).get("format").asString());
                }
                if (result.get(i).get(0).get("edition") != NullValue.NULL){
                    movieNode.put("edition",result.get(i).get(0).get("edition").asString());
                }
                if (result.get(i).get(0).get("score") != NullValue.NULL){
                    movieNode.put("score",String.valueOf(result.get(i).get(0).get("score")));
                }
                if (result.get(i).get(0).get("commentNum") != NullValue.NULL){
                    movieNode.put("commentNum",String.valueOf(result.get(i).get(0).get("commentNum")));
                }
                if (result.get(i).get(0).get("year") != NullValue.NULL){
                    movieNode.put("year",String.valueOf(result.get(i).get(0).get("year")));
                }
                if (result.get(i).get(0).get("month") != NullValue.NULL){
                    movieNode.put("month",String.valueOf(result.get(i).get(0).get("month")));
                }
                if (result.get(i).get(0).get("day") != NullValue.NULL){
                    movieNode.put("day",String.valueOf(result.get(i).get(0).get("day")));
                }
                if (result.get(i).get(0).get("positive") != NullValue.NULL){
                    movieNode.put("positive",String.valueOf(result.get(i).get(0).get("positive")));
                }
                if (result.get(i).get(0).get("negative") != NullValue.NULL){
                    movieNode.put("negative",String.valueOf(result.get(i).get(0).get("negative")));
                }

                movieResult.add(movieNode);
            }


            response.put("movies",movieResult);
            response.put("movieNum",result.size());
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
                    session.run("Match (d:Person{name:\""+name+"\"})-[r:Direct]->(m:Movie) return m.name");

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
                    session.run("Match (d:Person{name:\""+name+"\"})-[r:MainAct]->(m:Movie) return m.name");

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
                    session.run("Match (d:Person{name:\""+name+"\"})-[r:Act]->(m:Movie) return m.name");

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
