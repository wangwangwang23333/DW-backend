package cn.edu.tongji.dwbackend.Mysql.repository;

import cn.edu.tongji.dwbackend.Mysql.entity.ViewActorActorEntity;
import cn.edu.tongji.dwbackend.Mysql.entity.ViewActorActorEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ViewActorActorRepository
extends JpaRepository<ViewActorActorEntity, ViewActorActorEntityPK>,
        JpaSpecificationExecutor<ViewActorActorEntity> {
    List<ViewActorActorEntity> findAllByActor1AndActor2(String actor1, String actor2);
}
