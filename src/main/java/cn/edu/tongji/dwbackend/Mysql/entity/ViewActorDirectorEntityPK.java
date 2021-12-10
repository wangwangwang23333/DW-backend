package cn.edu.tongji.dwbackend.Mysql.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * TODO:此处写ViewActorDirectorEntityPK类的描述
 *
 * @author 汪明杰
 * @date 2021/12/10 11:13
 */
public class ViewActorDirectorEntityPK implements Serializable {
    private int movieId;
    private String actorName;
    private String directorName;

    @Id
    @Column(name = "movie_id")
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Id
    @Column(name = "actor_name")
    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @Id
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
        ViewActorDirectorEntityPK that = (ViewActorDirectorEntityPK) o;
        return movieId == that.movieId && Objects.equals(actorName, that.actorName) && Objects.equals(directorName, that.directorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, actorName, directorName);
    }

}
