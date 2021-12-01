package cn.edu.tongji.dwbackend.neo4j.controller;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO:此处写MovieController类的描述
 *
 * @author 汪明杰
 * @date 2021/11/28 15:52
 */

@RestController
public class MovieController {
    private final Driver driver;

    public MovieController(Driver driver){
        this.driver = driver;
    }

    @GetMapping(path = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String,Object> getMovieByCondition(@RequestParam(required = false) Integer year,
                                                 @RequestParam(required = false) Integer month,
                                                 @RequestParam(required = false) Integer day,
                                                 @RequestParam(required = false) Integer quarter,
                                                 @RequestParam(required = false) String movieName) {

        try (Session session = driver.session()) {
            String searchCondition = "MATCH (n:Movie) ";

            boolean firstCondition=true;
            if(year!=null){
                searchCondition+=" where ";
                searchCondition+=" n.year="+year;
                firstCondition=false;
            }
            if(month!=null){
                if(!firstCondition){
                    searchCondition+=" and ";
                }
                else{
                    searchCondition+=" where ";
                }
                searchCondition+= " n.month="+month;
                firstCondition=false;
            }
            if(day!=null){
                if(!firstCondition){
                    searchCondition+=" and ";
                }
                else{
                    searchCondition+=" where ";
                }
                searchCondition+= " n.day="+day;
                firstCondition=false;
            }
            if(quarter!=null){
                if(!firstCondition){
                    searchCondition+=" and ";
                }
                else{
                    searchCondition+=" where ";
                }
                int minMonth = quarter*3-2;
                int maxMonth = quarter*3;
                searchCondition+= " n.month>="+minMonth+" and n.month<="+maxMonth;
                firstCondition=false;
            }
            if(movieName!=null){
                if(!firstCondition){
                    searchCondition+=" and ";
                }
                else{
                    searchCondition+=" where ";
                }
                searchCondition+= " n.name contains "+movieName;
                firstCondition=false;
            }
            searchCondition+=" return count(n)";


            // 记录开始时间
            long startTime = System.currentTimeMillis();

            Result res=
                session.run(searchCondition);

            // 记录结束时间
            long endTime = System.currentTimeMillis();


            HashMap<String,Object> response = new HashMap<>();
            response.put("number",res
                    .list().get(0).get(0).toString());
            response.put("time",endTime-startTime);

            return response;
        }
    }

    @GetMapping(path = "movies/name", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping(path = "movies/director",produces =  MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, Object> findMovieByDirectorName(@RequestParam String name){
        //
        try (Session session = driver.session()) {
            // 记录开始时间
            long startTime = System.currentTimeMillis();
            Result res=
                    session.run("Match (d:Person{name:'"+name+"'})-[r:Director]->(m:Movie) return m.name");

            // 记录结束时间
            long endTime = System.currentTimeMillis();


            HashMap<String,Object> response = new HashMap<>();
            response.put("movies",res
                    .list(r -> r.get(0).asString()));
            response.put("time",endTime-startTime);

            return response;
        }
    }

    @GetMapping(path = "movies/mainactor",produces =  MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping(path = "movies/actor",produces =  MediaType.APPLICATION_JSON_VALUE)
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
