package cn.edu.tongji.dwbackend.Mysql.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * TODO:此处写ViewActorNameEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/12/7 21:38
 */
@Entity
@Table(name = "view_actor_name", schema = "DataWarehouse", catalog = "")
public class ViewActorNameEntity {
    private String actorName;

    @Id
    @Basic
    @Column(name = "actor_name")
    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewActorNameEntity that = (ViewActorNameEntity) o;
        return Objects.equals(actorName, that.actorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorName);
    }
}
