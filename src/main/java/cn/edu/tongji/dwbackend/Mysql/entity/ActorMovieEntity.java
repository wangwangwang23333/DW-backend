package cn.edu.tongji.dwbackend.Mysql.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * TODO:此处写ActorMovieEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/12/7 21:21
 */
@Entity
@Table(name = "actor_movie", schema = "DataWarehouse", catalog = "")
@IdClass(ActorMovieEntityPK.class)
public class ActorMovieEntity {
    private String actorName;
    private int movieId;
    private byte isMainActor;
    private String movieName;

    @Id
    @Column(name = "actor_name")
    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @Id
    @Column(name = "movie_id")
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "is_main_actor")
    public byte getIsMainActor() {
        return isMainActor;
    }

    public void setIsMainActor(byte isMainActor) {
        this.isMainActor = isMainActor;
    }

    @Basic
    @Column(name = "movie_name")
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorMovieEntity that = (ActorMovieEntity) o;
        return movieId == that.movieId && isMainActor == that.isMainActor && Objects.equals(actorName, that.actorName) && Objects.equals(movieName, that.movieName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorName, movieId, isMainActor, movieName);
    }
}
