package cn.edu.tongji.dwbackend.Mysql.repository;

import cn.edu.tongji.dwbackend.Mysql.entity.MovieEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {


    List<MovieEntity> findAllByMovieNameStartingWith(String movieName, Pageable pageable);
}
