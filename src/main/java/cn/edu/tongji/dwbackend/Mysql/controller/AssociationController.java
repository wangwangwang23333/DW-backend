package
        cn.edu.tongji.dwbackend.Mysql.controller;/**
 * @author 梁乔 2021/12/6
 **/

import cn.edu.tongji.dwbackend.Mysql.service.AssociationService;
import cn.edu.tongji.dwbackend.dto.MovieInfoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 有关词条联想的api
 * @author 梁乔
 * @since 2021/12/6 21:51 
 */
@RestController
@RequestMapping("/mysql/association")
public class AssociationController {

    @Resource
    AssociationService associationService;

    @RequestMapping(value = "/movie",method = RequestMethod.GET)
    public ResponseEntity<List<String>> getMovieNameListByString(
            @RequestParam(value = "movieName")String movieName
    ){
        return new ResponseEntity<>(associationService.getMovieNameByStr(movieName), HttpStatus.OK);
    }

    @RequestMapping(value = "/director",method = RequestMethod.GET)
    public ResponseEntity<List<String>> getDirectorNameListByString(
            @RequestParam(value = "directorName")String directorName
    ){
        return new ResponseEntity<>(associationService.getDirectorNameByStr(directorName), HttpStatus.OK);
    }

    @RequestMapping(value = "/actor",method = RequestMethod.GET)
    public ResponseEntity<List<String>> getActorNameListByString(
            @RequestParam(value = "actorName")String actorName
    ){
        return new ResponseEntity<>(associationService.getActorNameByStr(actorName), HttpStatus.OK);
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getCategoryListByString(
            @RequestParam(value = "category") String category
    ){
        return new ResponseEntity<>(associationService.getCategoryNameByStr(category), HttpStatus.OK);
    }

    @RequestMapping(value = "/actor/cooperation", method = RequestMethod.GET)
    public ResponseEntity<HashMap<String,Object>> getActorsCooperationTime(){
        // 记录开始时间
        long startTime = System.currentTimeMillis();
        HashMap<String,Object> result = associationService.getMaxCooperationTimeOfActors();
        long endTime = System.currentTimeMillis();
        result.put("time",endTime-startTime);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @RequestMapping(value = "/movie/result", method = RequestMethod.POST)
    public ResponseEntity<HashMap<String,Object>> getMovieResult(
            @RequestBody MovieInfoDto movieInfoDto
            ){
        HashMap<String,Object> result = associationService.getMovieResultsByMutipleRules(movieInfoDto);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}