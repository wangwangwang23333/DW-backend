package cn.edu.tongji.dwbackend.Mysql.repository;

import cn.edu.tongji.dwbackend.Mysql.entity.MovieScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 梁乔 2021/12/11
 **/
public interface MovieScoreRepository extends JpaRepository<MovieScoreEntity, Integer> {
    List<MovieScoreEntity> findAllByMovieScoreGreaterThanEqualAndMovieScoreLessThanEqual(double minScore, double maxScore);

    List<MovieScoreEntity> findAllByMovieScoreGreaterThanEqual(double minScore);

    List<MovieScoreEntity> findAllByMovieScoreLessThanEqual(double maxScore);
}
