package
        cn.edu.tongji.dwbackend.Mysql.entity;/**
 * @author 梁乔 2021/12/10
 **/

import javax.persistence.*;

/**
 * 此处写CategoryEntity类的描述
 * @author 梁乔
 * @since 2021/12/10 10:55 
 */
@Entity
@Table(name = "category", schema = "DataWarehouse", catalog = "")
@IdClass(CategoryEntityPK.class)
public class CategoryEntity {
    private String categoryName;
    private int movieId;

    @Id
    @Column(name = "category_name")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

        CategoryEntity that = (CategoryEntity) o;

        if (movieId != that.movieId) return false;
        if (categoryName != null ? !categoryName.equals(that.categoryName) : that.categoryName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryName != null ? categoryName.hashCode() : 0;
        result = 31 * result + movieId;
        return result;
    }
}