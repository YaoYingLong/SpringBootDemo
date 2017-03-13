package com.nokia.example.JDBCTemplateRepository;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

//@Repository
public class JdbcTemplateRepository {

    /*private static final Logger logger = LogManager.getLogger(JdbcTemplateRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(value = "transactionManager", readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public List<Map<String, Object>> getStudents(){
        String sql = "select * from students";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        jdbcTemplate.queryForMap(sql);
        return list;
    }*/

}
