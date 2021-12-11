package
        cn.edu.tongji.dwbackend.Mysql.entity;/**
 * @author 梁乔 2021/12/11
 **/

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 此处写TimeMovieEntity类的描述
 * @author 梁乔
 * @since 2021/12/11 15:10 
 */
@Entity
@Table(name = "time_movie", schema = "DataWarehouse", catalog = "")
public class TimeMovieEntity {
    private int movieId;
    private Timestamp timeStr;

    @Id
    @Column(name = "movie_id")
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "time_str")
    public Timestamp getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(Timestamp timeStr) {
        this.timeStr = timeStr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeMovieEntity that = (TimeMovieEntity) o;

        if (movieId != that.movieId) return false;
        if (timeStr != null ? !timeStr.equals(that.timeStr) : that.timeStr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = movieId;
        result = 31 * result + (timeStr != null ? timeStr.hashCode() : 0);
        return result;
    }
}