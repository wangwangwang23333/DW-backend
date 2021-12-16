package
        cn.edu.tongji.dwbackend.Mysql.entity;/**
 * @author 梁乔 2021/12/16
 **/

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 此处写MovieEntity类的描述
 * @author 梁乔
 * @since 2021/12/16 13:49 
 */
@Entity
@Table(name = "movie", schema = "DataWarehouse", catalog = "")
public class MovieEntity {
    private int movieId;
    private String movieName;
    private byte movieEditionNum;
    private Double movieScore;
    private Integer timeId;
    private Integer formatId;
    private String movieAsin;
    private String movieEdition;
    private Integer commentNum;
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
    @Column(name = "movie_name")
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Basic
    @Column(name = "movie_edition_num")
    public byte getMovieEditionNum() {
        return movieEditionNum;
    }

    public void setMovieEditionNum(byte movieEditionNum) {
        this.movieEditionNum = movieEditionNum;
    }

    @Basic
    @Column(name = "movie_score")
    public Double getMovieScore() {
        return movieScore;
    }

    public void setMovieScore(Double movieScore) {
        this.movieScore = movieScore;
    }

    @Basic
    @Column(name = "time_id")
    public Integer getTimeId() {
        return timeId;
    }

    public void setTimeId(Integer timeId) {
        this.timeId = timeId;
    }

    @Basic
    @Column(name = "format_id")
    public Integer getFormatId() {
        return formatId;
    }

    public void setFormatId(Integer formatId) {
        this.formatId = formatId;
    }

    @Basic
    @Column(name = "movie_asin")
    public String getMovieAsin() {
        return movieAsin;
    }

    public void setMovieAsin(String movieAsin) {
        this.movieAsin = movieAsin;
    }

    @Basic
    @Column(name = "movie_edition")
    public String getMovieEdition() {
        return movieEdition;
    }

    public void setMovieEdition(String movieEdition) {
        this.movieEdition = movieEdition;
    }

    @Basic
    @Column(name = "comment_num")
    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
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

        MovieEntity that = (MovieEntity) o;

        if (movieId != that.movieId) return false;
        if (movieEditionNum != that.movieEditionNum) return false;
        if (movieName != null ? !movieName.equals(that.movieName) : that.movieName != null) return false;
        if (movieScore != null ? !movieScore.equals(that.movieScore) : that.movieScore != null) return false;
        if (timeId != null ? !timeId.equals(that.timeId) : that.timeId != null) return false;
        if (formatId != null ? !formatId.equals(that.formatId) : that.formatId != null) return false;
        if (movieAsin != null ? !movieAsin.equals(that.movieAsin) : that.movieAsin != null) return false;
        if (movieEdition != null ? !movieEdition.equals(that.movieEdition) : that.movieEdition != null) return false;
        if (commentNum != null ? !commentNum.equals(that.commentNum) : that.commentNum != null) return false;
        if (timeStr != null ? !timeStr.equals(that.timeStr) : that.timeStr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = movieId;
        result = 31 * result + (movieName != null ? movieName.hashCode() : 0);
        result = 31 * result + (int) movieEditionNum;
        result = 31 * result + (movieScore != null ? movieScore.hashCode() : 0);
        result = 31 * result + (timeId != null ? timeId.hashCode() : 0);
        result = 31 * result + (formatId != null ? formatId.hashCode() : 0);
        result = 31 * result + (movieAsin != null ? movieAsin.hashCode() : 0);
        result = 31 * result + (movieEdition != null ? movieEdition.hashCode() : 0);
        result = 31 * result + (commentNum != null ? commentNum.hashCode() : 0);
        result = 31 * result + (timeStr != null ? timeStr.hashCode() : 0);
        return result;
    }
}