package
        cn.edu.tongji.dwbackend.Mysql.entity;/**
 * @author 梁乔 2021/12/17
 **/

import javax.persistence.*;

/**
 * 此处写DirectorMovieEntity类的描述
 * @author 梁乔
 * @since 2021/12/17 22:47 
 */
@Entity
@Table(name = "director_movie", schema = "DataWarehouse", catalog = "")
@IdClass(DirectorMovieEntityPK.class)
public class DirectorMovieEntity {
    private String directorName;
    private int movieId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectorMovieEntity that = (DirectorMovieEntity) o;

        if (movieId != that.movieId) return false;
        if (directorName != null ? !directorName.equals(that.directorName) : that.directorName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = directorName != null ? directorName.hashCode() : 0;
        result = 31 * result + movieId;
        return result;
    }
}