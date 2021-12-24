package cn.edu.tongji.dwbackend.Mysql.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 *
 * @author 汪明杰
 * @date 2021/12/24 15:06
 */
@Entity
@Table(name = "view_actor_director_cooperation_time", schema = "DataWarehouse", catalog = "")
public class ViewActorDirectorCooperationTimeEntity {
    private String actorName;
    private String directorName;
    private long movieCount;

    @Id
    @Basic
    @Column(name = "actor_name")
    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @Basic
    @Column(name = "director_name")
    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    @Basic
    @Column(name = "movie_count")
    public long getMovieCount() {
        return movieCount;
    }

    public void setMovieCount(long movieCount) {
        this.movieCount = movieCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewActorDirectorCooperationTimeEntity that = (ViewActorDirectorCooperationTimeEntity) o;
        return movieCount == that.movieCount && Objects.equals(actorName, that.actorName) && Objects.equals(directorName, that.directorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorName, directorName, movieCount);
    }
}
