package
        cn.edu.tongji.dwbackend.Mysql.entity;/**
 * @author 梁乔 2021/12/9
 **/

import javax.persistence.*;

/**
 * 此处写ViewMovieFactEntity类的描述
 * @author 梁乔
 * @since 2021/12/9 22:25 
 */
@Entity
@Table(name = "View_movie_fact", schema = "DataWarehouse", catalog = "")
@IdClass(ViewMovieFactEntityPK.class)
public class ViewMovieFactEntity {
    private String movieAsin;
    private String movieName;
    private String formatName;
    private String movieEdition;
    private Double movieScore;
    private Integer commentNum;
    private short year;
    private byte month;
    private byte day;
    private String actorName;
    private byte isMainActor;
    private String directorName;
    private String categoryName;

    @Id
    @Basic
    @Column(name = "movie_asin")
    public String getMovieAsin() {
        return movieAsin;
    }

    public void setMovieAsin(String movieAsin) {
        this.movieAsin = movieAsin;
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
    @Column(name = "format_name")
    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
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
    @Column(name = "movie_score")
    public Double getMovieScore() {
        return movieScore;
    }

    public void setMovieScore(Double movieScore) {
        this.movieScore = movieScore;
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
    @Column(name = "year")
    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    @Basic
    @Column(name = "month")
    public byte getMonth() {
        return month;
    }

    public void setMonth(byte month) {
        this.month = month;
    }

    @Basic
    @Column(name = "day")
    public byte getDay() {
        return day;
    }

    public void setDay(byte day) {
        this.day = day;
    }

    @Id
    @Basic
    @Column(name = "actor_name")
    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @Basic
    @Column(name = "is_main_actor")
    public byte getIsMainActor() {
        return isMainActor;
    }

    public void setIsMainActor(byte isMainActor) {
        this.isMainActor = isMainActor;
    }

    @Id
    @Basic
    @Column(name = "director_name")
    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    @Basic
    @Column(name = "category_name")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewMovieFactEntity that = (ViewMovieFactEntity) o;

        if (year != that.year) return false;
        if (month != that.month) return false;
        if (day != that.day) return false;
        if (isMainActor != that.isMainActor) return false;
        if (movieAsin != null ? !movieAsin.equals(that.movieAsin) : that.movieAsin != null) return false;
        if (movieName != null ? !movieName.equals(that.movieName) : that.movieName != null) return false;
        if (formatName != null ? !formatName.equals(that.formatName) : that.formatName != null) return false;
        if (movieEdition != null ? !movieEdition.equals(that.movieEdition) : that.movieEdition != null) return false;
        if (movieScore != null ? !movieScore.equals(that.movieScore) : that.movieScore != null) return false;
        if (commentNum != null ? !commentNum.equals(that.commentNum) : that.commentNum != null) return false;
        if (actorName != null ? !actorName.equals(that.actorName) : that.actorName != null) return false;
        if (directorName != null ? !directorName.equals(that.directorName) : that.directorName != null) return false;
        if (categoryName != null ? !categoryName.equals(that.categoryName) : that.categoryName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = movieAsin != null ? movieAsin.hashCode() : 0;
        result = 31 * result + (movieName != null ? movieName.hashCode() : 0);
        result = 31 * result + (formatName != null ? formatName.hashCode() : 0);
        result = 31 * result + (movieEdition != null ? movieEdition.hashCode() : 0);
        result = 31 * result + (movieScore != null ? movieScore.hashCode() : 0);
        result = 31 * result + (commentNum != null ? commentNum.hashCode() : 0);
        result = 31 * result + (int) year;
        result = 31 * result + (int) month;
        result = 31 * result + (int) day;
        result = 31 * result + (actorName != null ? actorName.hashCode() : 0);
        result = 31 * result + (int) isMainActor;
        result = 31 * result + (directorName != null ? directorName.hashCode() : 0);
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        return result;
    }
}