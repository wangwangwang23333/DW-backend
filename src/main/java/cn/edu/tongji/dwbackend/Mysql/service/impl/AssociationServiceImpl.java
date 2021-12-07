package
        cn.edu.tongji.dwbackend.Mysql.service.impl;/**
 * @author 梁乔 2021/12/6
 **/

import cn.edu.tongji.dwbackend.Mysql.entity.MovieEntity;
import cn.edu.tongji.dwbackend.Mysql.repository.MovieRepository;
import cn.edu.tongji.dwbackend.Mysql.service.AssociationService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 此处写RelationShipServiceImpl类的描述
 * @author 梁乔
 * @since 2021/12/6 22:00 
 */

@Service
public class AssociationServiceImpl implements AssociationService {
    @Resource
    MovieRepository movieRepository;

    @Override
    public List<String> getMovieNameByStr(String movieString) {
        Pageable pageable = PageRequest.of(0, 25);
        List<MovieEntity> movieList = movieRepository.findAllByMovieNameStartingWith(movieString, pageable);

        List<String> result = new ArrayList<>();
        for (MovieEntity movie: movieList){
            result.add(movie.getMovieName());
        }

        return result;
    }
}