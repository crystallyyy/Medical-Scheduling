package com.techelevator.dao;

import com.techelevator.model.Office;
import com.techelevator.model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
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
    public List<Office> listAllOffices() {
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

    @Override
    public boolean updateOffice(Office office) {
        String sql = "UPDATE office SET office_name = ? , address = ? , phone_number = ? WHERE office_id = ? ;";
        boolean suc = false;
        try {
            jdbcTemplate.update(sql, office.getOfficeName(), office.getAddress(), office.getPhoneNumber(), office.getOfficeId());
            suc = true;
        } catch (CannotGetJdbcConnectionException | BadSqlGrammarException | DataIntegrityViolationException e) {
            return false;
        }
        return suc;
    }

    @Override
    public List<Office> getOfficesByDoctor(int doctorId) {
        List<Office> offices = new ArrayList<>();
        String sql = "SELECT * FROM office AS o " +
                "JOIN doctor_office AS d_o ON o.office_id = d_o.office_id " +
                "JOIN doctor AS d ON d_o.doctor_id = d.doctor_id " +
                "WHERE d.doctor_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
        while (results.next()){
            Office office = mapRowToOffice(results);
            offices.add(office);
        }
        return offices;
    }

    public List<Integer> getOfficeIdsByDoctorId(int doctorId){
        List<Integer> officeIds = new ArrayList<>();
        String sql = "SELECT office_id FROM doctor_office WHERE doctor_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
        while (results.next()){
            Integer officeId = results.getInt("office_id");
            officeIds.add(officeId);
        }

        return officeIds;
    }




    private Office mapRowToOffice(SqlRowSet rs) {
        Office office = new Office();
        office.setOfficeId(rs.getInt("office_id"));
        office.setOfficeName(rs.getString("office_name"));
        office.setAddress(rs.getString("address"));
        office.setPhoneNumber(rs.getString("phone_number"));
        return office;
    }

}