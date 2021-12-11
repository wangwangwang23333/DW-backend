package
        cn.edu.tongji.dwbackend.Mysql.entity;/**
 * @author 梁乔 2021/12/11
 **/

import javax.persistence.*;

/**
 * 此处写ViewDirectorCooperationTimeEntity类的描述
 * @author 梁乔
 * @since 2021/12/11 20:16 
 */
@Entity
@Table(name = "view_director_cooperation_time", schema = "DataWarehouse", catalog = "")
public class ViewDirectorCooperationTimeEntity {
    private String directorName1;
    private String directorName2;
    private long cooperTime;


    @Basic
    @Column(name = "director_name1")
    public String getDirectorName1() {
        return directorName1;
    }

    public void setDirectorName1(String directorName1) {
        this.directorName1 = directorName1;
    }


    @Basic
    @Column(name = "director_name2")
    public String getDirectorName2() {
        return directorName2;
    }

    public void setDirectorName2(String directorName2) {
        this.directorName2 = directorName2;
    }
    @Id
    @Basic
    @Column(name = "cooper_time")
    public long getCooperTime() {
        return cooperTime;
    }

    public void setCooperTime(long cooperTime) {
        this.cooperTime = cooperTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewDirectorCooperationTimeEntity that = (ViewDirectorCooperationTimeEntity) o;

        if (cooperTime != that.cooperTime) return false;
        if (directorName1 != null ? !directorName1.equals(that.directorName1) : that.directorName1 != null)
            return false;
        if (directorName2 != null ? !directorName2.equals(that.directorName2) : that.directorName2 != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = directorName1 != null ? directorName1.hashCode() : 0;
        result = 31 * result + (directorName2 != null ? directorName2.hashCode() : 0);
        result = 31 * result + (int) (cooperTime ^ (cooperTime >>> 32));
        return result;
    }
}