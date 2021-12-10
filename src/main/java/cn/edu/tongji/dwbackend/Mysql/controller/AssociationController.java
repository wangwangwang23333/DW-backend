package
        cn.edu.tongji.dwbackend.Mysql.controller;/**
 * @author 梁乔 2021/12/6
 **/

import cn.edu.tongji.dwbackend.Mysql.service.AssociationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/movie/director", method = RequestMethod.GET)
    public ResponseEntity<HashMap<String, Object>> getMovieDirectorByMovieAsin(
            @RequestParam(value = "movieAsin") String movieAsin,
            @RequestParam(value = "index") Integer index
    ){
        HashMap<String, Object> res = new HashMap<>();
        res.put("index", index);
        res.put("director", associationService.getAllDirectorsByMovieAsin(movieAsin));
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}