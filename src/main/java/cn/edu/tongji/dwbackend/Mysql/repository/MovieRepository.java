package cn.edu.tongji.dwbackend.Mysql.repository;

import cn.edu.tongji.dwbackend.Mysql.entity.MovieEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import java.sql.Timestamp;
import java.util.List;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> , JpaSpecificationExecutor<MovieEntity> {


    List<MovieEntity> findAllByMovieNameStartingWith(String movieName, Pageable pageable);

    MovieEntity findFirstByMovieAsin(String movieAsin);

    MovieEntity findFirstByMovieId(int movieId);

    List<MovieEntity> findAllByMovieName(String movieName);

    List<MovieEntity> findAllByMovieScoreGreaterThanEqualAndMovieScoreLessThanEqual(Double minScore,Double maxScore);

    List<MovieEntity> findAllByMovieScoreGreaterThanEqual(Double minScore);

    List<MovieEntity> findAllByMovieScoreLessThanEqual(Double maxScore);

    List<MovieEntity> findAllByTimeId(Integer timeId);

    List<MovieEntity> findAllByTimeStrAfterAndTimeStrBefore(Timestamp minDate,Timestamp maxDate);

    MovieEntity findByMovieId(Integer movieId);
}
