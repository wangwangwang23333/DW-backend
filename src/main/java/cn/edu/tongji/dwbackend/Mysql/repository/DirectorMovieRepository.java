package cn.edu.tongji.dwbackend.Mysql.repository;

import cn.edu.tongji.dwbackend.Mysql.entity.DirectorMovieEntity;
import cn.edu.tongji.dwbackend.Mysql.entity.DirectorMovieEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DirectorMovieRepository
extends JpaRepository<DirectorMovieEntity, DirectorMovieEntityPK>,
        JpaSpecificationExecutor<DirectorMovieEntity> {
    List<DirectorMovieEntity> findAllByMovieId(int movieId);
    List<DirectorMovieEntity> findAllByDirectorName(String directorName);
}
