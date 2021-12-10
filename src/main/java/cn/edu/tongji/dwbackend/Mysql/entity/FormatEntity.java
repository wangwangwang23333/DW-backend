package
        cn.edu.tongji.dwbackend.Mysql.entity;/**
 * @author 梁乔 2021/12/11
 **/

import javax.persistence.*;

/**
 * 此处写FormatEntity类的描述
 * @author 梁乔
 * @since 2021/12/11 0:18 
 */
@Entity
@Table(name = "format", schema = "DataWarehouse", catalog = "")
public class FormatEntity {
    private int formatId;
    private String formatName;

    @Id
    @Column(name = "format_id")
    public int getFormatId() {
        return formatId;
    }

    public void setFormatId(int formatId) {
        this.formatId = formatId;
    }

    @Basic
    @Column(name = "format_name")
    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FormatEntity that = (FormatEntity) o;

        if (formatId != that.formatId) return false;
        if (formatName != null ? !formatName.equals(that.formatName) : that.formatName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = formatId;
        result = 31 * result + (formatName != null ? formatName.hashCode() : 0);
        return result;
    }
}