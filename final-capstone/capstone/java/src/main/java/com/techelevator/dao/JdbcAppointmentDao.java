package com.techelevator.dao;

import com.techelevator.model.Appointment;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcAppointmentDao implements AppointmentDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcAppointmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Appointment newAppt(Appointment appointment) {
        return null;
    }

    @Override
    public void cancelAppt(int apptId) {

    }
}
