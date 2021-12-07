package cn.edu.tongji.dwbackend.Mysql.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * TODO:此处写MovieEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/12/7 20:43
 */
@Entity
@Table(name = "movie", schema = "DataWarehouse", catalog = "")
public class MovieEntity {
    private int movieId;
    private String movieName;
    private byte movieEditionNum;
    private Double movieScore;
    private String movieAsin;
    private Double dbRatingScore;
    private String movieEdition;
    private Integer commentNum;

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
    @Column(name = "movie_asin")
    public String getMovieAsin() {
        return movieAsin;
    }

    public void setMovieAsin(String movieAsin) {
        this.movieAsin = movieAsin;
    }

    @Basic
    @Column(name = "db_rating_score")
    public Double getDbRatingScore() {
        return dbRatingScore;
    }

    public void setDbRatingScore(Double dbRatingScore) {
        this.dbRatingScore = dbRatingScore;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieEntity that = (MovieEntity) o;
        return movieId == that.movieId && movieEditionNum == that.movieEditionNum && Objects.equals(movieName, that.movieName) && Objects.equals(movieScore, that.movieScore) && Objects.equals(movieAsin, that.movieAsin) && Objects.equals(dbRatingScore, that.dbRatingScore) && Objects.equals(movieEdition, that.movieEdition) && Objects.equals(commentNum, that.commentNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, movieName, movieEditionNum, movieScore, movieAsin, dbRatingScore, movieEdition, commentNum);
    }
}
