package
        cn.edu.tongji.dwbackend.Mysql.entity;

import javax.persistence.*;

/**
 * 此处写ActorMovieEntity类的描述
 * @author 梁乔
 * @since 2021/12/11 16:09 
 */
@Entity
@Table(name = "actor_movie", schema = "DataWarehouse", catalog = "")
@IdClass(ActorMovieEntityPK.class)
public class ActorMovieEntity {
    private String actorName;
    private int movieId;
    private byte isMainActor;

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

    @Id
    @Basic
    @Column(name = "is_main_actor")
    public byte getIsMainActor() {
        return isMainActor;
    }

    public void setIsMainActor(byte isMainActor) {
        this.isMainActor = isMainActor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActorMovieEntity that = (ActorMovieEntity) o;

        if (movieId != that.movieId) return false;
        if (isMainActor != that.isMainActor) return false;
        if (actorName != null ? !actorName.equals(that.actorName) : that.actorName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = actorName != null ? actorName.hashCode() : 0;
        result = 31 * result + movieId;
        result = 31 * result + (int) isMainActor;
        return result;
    }
}