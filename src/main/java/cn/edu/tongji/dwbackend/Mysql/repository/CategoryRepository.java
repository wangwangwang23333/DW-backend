package cn.edu.tongji.dwbackend.Mysql.repository;

import cn.edu.tongji.dwbackend.Mysql.entity.CategoryEntity;
import cn.edu.tongji.dwbackend.Mysql.entity.CategoryEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 梁乔 2021/12/10
 **/
public interface CategoryRepository extends JpaRepository<CategoryEntity, CategoryEntityPK> {
    List<CategoryEntity> findAllByCategoryName(String categoryName);
}
