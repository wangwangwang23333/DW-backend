package cn.edu.tongji.dwbackend.Hive.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * TODO:此处写HiveController类的描述
 *
 * @author shotray
 * @since 2021/12/14 20:42
 */


@RestController
@RequestMapping("/hive2")
public class HiveController {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/list")
    public List<Map<String, Object>> list() {
        String sql = "select * from cooperation";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

}

