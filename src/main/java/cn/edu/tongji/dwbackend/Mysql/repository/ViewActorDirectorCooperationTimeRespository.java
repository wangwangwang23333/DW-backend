package cn.edu.tongji.dwbackend.Mysql.repository;

import cn.edu.tongji.dwbackend.Mysql.entity.ViewActorDirectorCooperationTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 梁乔 2021/12/11
 **/
public interface ViewActorDirectorCooperationTimeRespository extends JpaRepository<ViewActorDirectorCooperationTimeEntity, Integer> {
    ViewActorDirectorCooperationTimeEntity findTopBy();
}
