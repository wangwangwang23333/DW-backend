package
        cn.edu.tongji.dwbackend.Mysql.entity;/**
 * @author 梁乔 2021/12/9
 **/

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * 此处写ViewMovieFactEntityPK类的描述
 * @author 梁乔
 * @since 2021/12/9 21:56 
 */
public class ViewMovieFactEntityPK implements Serializable {
    private String actorName;
    private String movieAsin;
    private String directorName;

    @Column(name = "director_name")
    @Id
    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    @Column(name = "actor_name")
    @Id
    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @Column(name = "movie_asin")
    @Id
    public String getMovieAsin() {
        return movieAsin;
    }

    public void setMovieAsin(String movieAsin) {
        this.movieAsin = movieAsin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewMovieFactEntityPK that = (ViewMovieFactEntityPK ) o;
        return Objects.equals(movieAsin, that.movieAsin) && Objects.equals(directorName, that.directorName) && Objects.equals(actorName, that.actorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorName);
    }


}