package cn.edu.tongji.dwbackend.Mysql.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * TODO:此处写ViewActorDirectorEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/12/10 11:09
 */
@Entity
@Table(name = "view_actor_director", schema = "DataWarehouse", catalog = "")
@IdClass(ViewActorDirectorEntityPK.class)
public class ViewActorDirectorEntity {
    private int movieId;
    private String actorName;
    private String directorName;

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
    @Column(name = "actor_name")
    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

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
        ViewActorDirectorEntity that = (ViewActorDirectorEntity) o;
        return movieId == that.movieId && Objects.equals(actorName, that.actorName) && Objects.equals(directorName, that.directorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, actorName, directorName);
    }
}
