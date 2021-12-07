package cn.edu.tongji.dwbackend.Mysql.repository;

import cn.edu.tongji.dwbackend.Mysql.entity.ViewDirectorNameEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ViewDirectorNameRepository
extends JpaRepository<ViewDirectorNameEntity,String> {
   List<ViewDirectorNameEntity> findAllByDirectorNameStartingWith(String directorName, Pageable pageable);
}
