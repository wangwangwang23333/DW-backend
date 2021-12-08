package cn.edu.tongji.dwbackend.Mysql.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * TODO:此处写ViewCategoryNameEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/12/8 9:04
 */
@Entity
@Table(name = "view_category_name", schema = "DataWarehouse", catalog = "")
public class ViewCategoryNameEntity {
    private String categoryName;

    @Id
    @Basic
    @Column(name = "category_name")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewCategoryNameEntity that = (ViewCategoryNameEntity) o;
        return Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName);
    }
}
