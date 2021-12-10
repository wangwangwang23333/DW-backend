package cn.edu.tongji.dwbackend.Mysql.repository;

import cn.edu.tongji.dwbackend.Mysql.entity.ActorMovieEntity;
import cn.edu.tongji.dwbackend.Mysql.entity.ActorMovieEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ActorMovieRepository
extends JpaRepository<ActorMovieEntity, ActorMovieEntityPK> ,
        JpaSpecificationExecutor<ActorMovieEntity> {

}
