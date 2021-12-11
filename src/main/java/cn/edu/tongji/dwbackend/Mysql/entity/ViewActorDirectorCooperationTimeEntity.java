package
        cn.edu.tongji.dwbackend.Mysql.entity;/**
 * @author 梁乔 2021/12/11
 **/

import javax.persistence.*;

/**
 * 此处写ViewActorDirectorCooperationTimeEntity类的描述
 * @author 梁乔
 * @since 2021/12/11 20:29 
 */
@Entity
@Table(name = "view_actor_director_cooperation_time", schema = "DataWarehouse", catalog = "")
public class ViewActorDirectorCooperationTimeEntity {
    private String actorName;
    private String directorName;
    private long cooperTime;

    @Basic
    @Column(name = "actor_name")
    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @Basic
    @Column(name = "director_name")
    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
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

        ViewActorDirectorCooperationTimeEntity that = (ViewActorDirectorCooperationTimeEntity) o;

        if (cooperTime != that.cooperTime) return false;
        if (actorName != null ? !actorName.equals(that.actorName) : that.actorName != null) return false;
        if (directorName != null ? !directorName.equals(that.directorName) : that.directorName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = actorName != null ? actorName.hashCode() : 0;
        result = 31 * result + (directorName != null ? directorName.hashCode() : 0);
        result = 31 * result + (int) (cooperTime ^ (cooperTime >>> 32));
        return result;
    }
}