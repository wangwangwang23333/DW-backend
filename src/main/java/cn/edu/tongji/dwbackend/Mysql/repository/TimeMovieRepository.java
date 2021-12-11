package
        cn.edu.tongji.dwbackend.Mysql.repository;/**
 * @author 梁乔 2021/12/11
 **/

import cn.edu.tongji.dwbackend.Mysql.entity.TimeMovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;
import java.util.List;

/**
 * 此处写TimeMovieRepository类的描述
 * @author 梁乔
 * @since 2021/12/11 15:11 
 */
public interface TimeMovieRepository extends JpaRepository<TimeMovieEntity, Integer> {
    List<TimeMovieEntity> findAllByTimeStrAfterAndTimeStrBefore(Timestamp minDate, Timestamp maxDate);

    TimeMovieEntity findByMovieId(Integer movieId);
}