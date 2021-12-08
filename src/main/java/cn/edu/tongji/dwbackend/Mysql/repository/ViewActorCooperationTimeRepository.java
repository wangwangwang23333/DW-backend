package cn.edu.tongji.dwbackend.Mysql.repository;

import cn.edu.tongji.dwbackend.Mysql.entity.ViewActorCooperationTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 梁乔 2021/12/8
 **/
public interface ViewActorCooperationTimeRepository extends JpaRepository<ViewActorCooperationTimeEntity,String> {
    ViewActorCooperationTimeEntity findTopBy();
}
