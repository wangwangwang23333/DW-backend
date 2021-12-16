package
        cn.edu.tongji.dwbackend.Mysql.entity;/**
 * @author 梁乔 2021/12/16
 **/

import javax.persistence.*;

/**
 * 此处写MovieScoreEntity类的描述
 * @author 梁乔
 * @since 2021/12/16 14:43 
 */
@Entity
@Table(name = "movie_score", schema = "DataWarehouse", catalog = "")
public class MovieScoreEntity {
    private int movieId;
    private Double movieScore;
    private Double positiveCommentRating;
    private Double negativeCommentRating;

    @Id
    @Column(name = "movie_id")
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
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
    @Column(name = "positive_comment_rating")
    public Double getPositiveCommentRating() {
        return positiveCommentRating;
    }

    public void setPositiveCommentRating(Double positiveCommentRating) {
        this.positiveCommentRating = positiveCommentRating;
    }

    @Basic
    @Column(name = "negative_comment_rating")
    public Double getNegativeCommentRating() {
        return negativeCommentRating;
    }

    public void setNegativeCommentRating(Double negativeCommentRating) {
        this.negativeCommentRating = negativeCommentRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieScoreEntity that = (MovieScoreEntity) o;

        if (movieId != that.movieId) return false;
        if (movieScore != null ? !movieScore.equals(that.movieScore) : that.movieScore != null) return false;
        if (positiveCommentRating != null ? !positiveCommentRating.equals(that.positiveCommentRating) : that.positiveCommentRating != null)
            return false;
        if (negativeCommentRating != null ? !negativeCommentRating.equals(that.negativeCommentRating) : that.negativeCommentRating != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = movieId;
        result = 31 * result + (movieScore != null ? movieScore.hashCode() : 0);
        result = 31 * result + (positiveCommentRating != null ? positiveCommentRating.hashCode() : 0);
        result = 31 * result + (negativeCommentRating != null ? negativeCommentRating.hashCode() : 0);
        return result;
    }
}