package cn.edu.tongji.dwbackend.Mysql.repository;

import cn.edu.tongji.dwbackend.Mysql.entity.ViewActorDirectorEntity;
import cn.edu.tongji.dwbackend.Mysql.entity.ViewActorDirectorEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ViewActorDirectorRepository
extends JpaRepository<ViewActorDirectorEntity, ViewActorDirectorEntityPK>,
        JpaSpecificationExecutor<ViewActorDirectorEntity> {
    List<ViewActorDirectorEntity> findAllByActorNameAndDirectorName(String actorName, String directorName);
}
