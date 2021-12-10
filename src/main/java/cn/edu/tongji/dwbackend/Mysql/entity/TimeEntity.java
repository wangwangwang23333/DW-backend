package
        cn.edu.tongji.dwbackend.Mysql.entity;/**
 * @author 梁乔 2021/12/10
 **/

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 此处写TimeEntity类的描述
 * @author 梁乔
 * @since 2021/12/10 20:17 
 */
@Entity
@Table(name = "time", schema = "DataWarehouse", catalog = "")
public class TimeEntity {
    private int timeId;
    private short year;
    private byte month;
    private byte day;
    private byte season;
    private byte weekday;
    private Timestamp timeStr;

    @Id
    @Column(name = "time_id")
    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
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

    @Basic
    @Column(name = "season")
    public byte getSeason() {
        return season;
    }

    public void setSeason(byte season) {
        this.season = season;
    }

    @Basic
    @Column(name = "weekday")
    public byte getWeekday() {
        return weekday;
    }

    public void setWeekday(byte weekday) {
        this.weekday = weekday;
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

        TimeEntity that = (TimeEntity) o;

        if (timeId != that.timeId) return false;
        if (year != that.year) return false;
        if (month != that.month) return false;
        if (day != that.day) return false;
        if (season != that.season) return false;
        if (weekday != that.weekday) return false;
        if (timeStr != null ? !timeStr.equals(that.timeStr) : that.timeStr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = timeId;
        result = 31 * result + (int) year;
        result = 31 * result + (int) month;
        result = 31 * result + (int) day;
        result = 31 * result + (int) season;
        result = 31 * result + (int) weekday;
        result = 31 * result + (timeStr != null ? timeStr.hashCode() : 0);
        return result;
    }
}