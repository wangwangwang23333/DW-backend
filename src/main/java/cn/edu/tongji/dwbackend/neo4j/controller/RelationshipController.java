package cn.edu.tongji.dwbackend.neo4j.controller;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * RelationshipController类
 *
 * @author 汪明杰
 * @date 2021/11/30 13:26
 */
@RestController
@RequestMapping("/neo4j/relation")
public class RelationshipController {
    private final Driver driver;

    public RelationshipController(Driver driver){
        this.driver = driver;
    }

    @GetMapping(path = "/actorAndDirector",produces =  MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, Object> findMostCooperateActorAndDirector(){
        try (Session session = driver.session()) {
            // 记录开始时间
            long startTime = System.currentTimeMillis();
            Result res=
                    session.run("Match (p:Person)-[r:MainAct|Act]->(m:Movie)<-[a:Direct]-(q:Person) " +
                            "where id(p)<> id(q) return p.name,q.name,count(m) order by count(m) desc limit 1");

            // 记录结束时间
            long endTime = System.currentTimeMillis();

            List<Record> relation = res.list();
            HashMap<String,Object> response = new HashMap<>();
            response.put("actor",relation.get(0).get(0).asString());
            response.put("director",relation.get(0).get(1).asString());
            response.put("number",relation.get(0).get(2).toString());
            response.put("time",endTime-startTime);

            return response;
        }
    }

    @GetMapping(path = "/actors", produces = MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, Object> findMostCooperateActors(){
        try (Session session = driver.session()) {
            // 记录开始时间
            long startTime = System.currentTimeMillis();
            Result res=
                    session.run("Match (p:Person)-[r:MainAct|Act]->(m:Movie)<-[a:MainAct|Act]-(q:Person) " +
                            "where id(p)<> id(q) return p.name,q.name,count(m) order by count(m) desc limit 1");

            // 记录结束时间
            long endTime = System.currentTimeMillis();

            List<Record> relation = res.list();
            HashMap<String,Object> response = new HashMap<>();

            List<String> actors= new ArrayList<>();
            actors.add(relation.get(0).get(0).asString());
            actors.add(relation.get(0).get(1).asString());
            response.put("actor",actors);
            response.put("number",relation.get(0).get(2).toString());
            response.put("time",endTime-startTime);

            return response;
        }
    }
}
