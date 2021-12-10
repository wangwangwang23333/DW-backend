package
        cn.edu.tongji.dwbackend.Mysql.service;/**
 * @author 梁乔 2021/12/6
 **/

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 此处写AssociationService类的描述
 * @author 梁乔
 * @since 2021/12/6 21:58 
 */
@Service
public interface AssociationService {
    List<String> getMovieNameByStr(String movieString);

    List<String> getDirectorNameByStr(String directorName);

    List<String> getActorNameByStr(String actorName);

    List<String> getCategoryNameByStr(String category);

    List<String> getAllDirectorsByMovieAsin(String movieAsin);
}