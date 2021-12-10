package cn.edu.tongji.dwbackend.Mysql.repository;

import cn.edu.tongji.dwbackend.Mysql.entity.ViewMovieFactEntity;
import cn.edu.tongji.dwbackend.Mysql.entity.ViewMovieFactEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 梁乔 2021/12/9
 **/
public interface ViewModelFactRepository extends JpaRepository<ViewMovieFactEntity, ViewMovieFactEntityPK> , JpaSpecificationExecutor<ViewMovieFactEntity> {

}
