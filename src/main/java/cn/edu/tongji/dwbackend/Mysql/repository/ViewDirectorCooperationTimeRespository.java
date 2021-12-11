package cn.edu.tongji.dwbackend.Mysql.repository;

import cn.edu.tongji.dwbackend.Mysql.entity.ViewActorCooperationTimeEntity;
import cn.edu.tongji.dwbackend.Mysql.entity.ViewDirectorCooperationTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 梁乔 2021/12/11
 **/
public interface ViewDirectorCooperationTimeRespository extends JpaRepository<ViewDirectorCooperationTimeEntity,String> {
    ViewDirectorCooperationTimeEntity findTopBy();
}
