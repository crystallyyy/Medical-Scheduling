package com.techelevator.dao;

import com.techelevator.model.Office;
import com.techelevator.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JdbcOfficeDAO implements OfficeDAO {
    private final JdbcTemplate jdbcTemplate;

    public JdbcOfficeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Office getOfficeByID(int officeId) {
        String sql = "SELECT * FROM users WHERE office_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);
        if (results.next()) {
            return mapRowToOffice(results);
        } else {
            return null;
        }
    }

    @Override
    public List<Office> findAllOffices() {
        List<Office> offices = new ArrayList<>();
        String sql = "select * from office";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            offices.add(mapRowToOffice(results));
        }

        return offices;
    }

    @Override
    public boolean create() {
        return false;
    }

    private Office mapRowToOffice(SqlRowSet rs) {
        Office office = new Office();
        return office;
    }
}
