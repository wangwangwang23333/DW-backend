package cn.edu.tongji.dwbackend.Mysql.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author 汪明杰
 * @date 2021/12/7 21:21
 */
public class ActorMovieEntityPK implements Serializable {
    private String actorName;
    private int movieId;

    @Column(name = "actor_name")
    @Id
    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @Column(name = "movie_id")
    @Id
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorMovieEntityPK that = (ActorMovieEntityPK) o;
        return movieId == that.movieId && Objects.equals(actorName, that.actorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorName, movieId);
    }
}
