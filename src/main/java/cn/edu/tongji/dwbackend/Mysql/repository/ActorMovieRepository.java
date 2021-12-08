package cn.edu.tongji.dwbackend.Mysql.repository;

import cn.edu.tongji.dwbackend.Mysql.entity.ActorMovieEntity;
import cn.edu.tongji.dwbackend.Mysql.entity.ActorMovieEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 梁乔 2021/12/8
 **/
public interface ActorMovieRepository extends JpaRepository<ActorMovieEntity, ActorMovieEntityPK> {


}
