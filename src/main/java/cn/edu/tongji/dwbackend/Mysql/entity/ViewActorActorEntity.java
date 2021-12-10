package cn.edu.tongji.dwbackend.Mysql.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * TODO:此处写ViewActorActorEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/12/10 11:09
 */
@Entity
@Table(name = "view_actor_actor", schema = "DataWarehouse", catalog = "")
@IdClass(ViewActorActorEntityPK.class)
public class ViewActorActorEntity {
    private int movieId;
    private String actor1;
    private String actor2;

    @Id
    @Basic
    @Column(name = "movie_id")
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Id
    @Basic
    @Column(name = "actor1")
    public String getActor1() {
        return actor1;
    }

    public void setActor1(String actor1) {
        this.actor1 = actor1;
    }

    @Id
    @Basic
    @Column(name = "actor2")
    public String getActor2() {
        return actor2;
    }

    public void setActor2(String actor2) {
        this.actor2 = actor2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewActorActorEntity that = (ViewActorActorEntity) o;
        return movieId == that.movieId && Objects.equals(actor1, that.actor1) && Objects.equals(actor2, that.actor2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, actor1, actor2);
    }
}
