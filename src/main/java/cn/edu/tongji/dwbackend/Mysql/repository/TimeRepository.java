package cn.edu.tongji.dwbackend.Mysql.repository;

import cn.edu.tongji.dwbackend.Mysql.entity.TimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author 梁乔 2021/12/10
 **/
public interface TimeRepository extends JpaRepository<TimeEntity, Integer> {
    List<TimeEntity>  findAllByYearGreaterThanEqualAndYearLessThanEqualAndMonthGreaterThanEqualAndMonthLessThanEqualAndDayGreaterThanEqualAndDayLessThanEqual(byte minYear,byte maxYear, byte minMonth,byte MaxMonth, byte minDay, byte maxDay);

    List<TimeEntity> findAllByTimeStrAfterAndTimeStrBefore(Timestamp minDate, Timestamp maxDate);

    TimeEntity findByTimeId(Integer timeId);
}
