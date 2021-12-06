package
        cn.edu.tongji.dwbackend.service;/**
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
}