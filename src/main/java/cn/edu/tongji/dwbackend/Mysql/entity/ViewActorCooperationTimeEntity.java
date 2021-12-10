package
        cn.edu.tongji.dwbackend.Mysql.entity;/**
 * @author 梁乔 2021/12/8
 **/

import javax.persistence.*;

/**
 * 此处写ViewActorCooperationTimeEntity类的描述
 * @author 梁乔
 * @since 2021/12/8 21:45 
 */
@Entity
@Table(name = "view_actor_cooperation_time", schema = "DataWarehouse", catalog = "")
public class ViewActorCooperationTimeEntity {
    private String actorName1;
    private String actorName2;
    private long cooperTime;

    @Basic
    @Column(name = "actor_name1")
    public String getActorName1() {
        return actorName1;
    }

    public void setActorName1(String actorName1) {
        this.actorName1 = actorName1;
    }

    @Basic
    @Column(name = "actor_name2")
    public String getActorName2() {
        return actorName2;
    }

    public void setActorName2(String actorName2) {
        this.actorName2 = actorName2;
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

        ViewActorCooperationTimeEntity that = (ViewActorCooperationTimeEntity) o;

        if (cooperTime != that.cooperTime) return false;
        if (actorName1 != null ? !actorName1.equals(that.actorName1) : that.actorName1 != null) return false;
        if (actorName2 != null ? !actorName2.equals(that.actorName2) : that.actorName2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = actorName1 != null ? actorName1.hashCode() : 0;
        result = 31 * result + (actorName2 != null ? actorName2.hashCode() : 0);
        result = 31 * result + (int) (cooperTime ^ (cooperTime >>> 32));
        return result;
    }
}