package cn.edu.tongji.dwbackend.Mysql.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * TODO:此处写ViewDirectorNameEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/12/7 21:32
 */
@Entity
@Table(name = "view_director_name", schema = "DataWarehouse", catalog = "")
public class ViewDirectorNameEntity {
    private String directorName;

    @Id
    @Basic
    @Column(name = "director_name")
    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewDirectorNameEntity that = (ViewDirectorNameEntity) o;
        return Objects.equals(directorName, that.directorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directorName);
    }
}
