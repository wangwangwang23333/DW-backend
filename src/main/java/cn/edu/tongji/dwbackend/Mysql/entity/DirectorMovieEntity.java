package cn.edu.tongji.dwbackend.Mysql.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * TODO:此处写DirectorMovieEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/12/7 21:21
 */
@Entity
@Table(name = "director_movie", schema = "DataWarehouse", catalog = "")
@IdClass(DirectorMovieEntityPK.class)
public class DirectorMovieEntity {
    private String directorName;
    private int movieId;
    private String movieName;

    @Id
    @Column(name = "director_name")
    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
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
        DirectorMovieEntity that = (DirectorMovieEntity) o;
        return movieId == that.movieId && Objects.equals(directorName, that.directorName) && Objects.equals(movieName, that.movieName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directorName, movieId, movieName);
    }
}
