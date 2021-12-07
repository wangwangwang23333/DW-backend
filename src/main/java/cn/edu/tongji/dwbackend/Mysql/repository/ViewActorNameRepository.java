package cn.edu.tongji.dwbackend.Mysql.repository;

import cn.edu.tongji.dwbackend.Mysql.entity.ViewActorNameEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ViewActorNameRepository
extends JpaRepository<ViewActorNameEntity,String> ,
        JpaSpecificationExecutor<ViewActorNameEntity> {
    List<ViewActorNameEntity> findAllByActorNameStartingWith(String actorName, Pageable pageable);
}
