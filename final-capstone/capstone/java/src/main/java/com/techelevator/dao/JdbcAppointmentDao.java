package com.techelevator.dao;

import com.techelevator.model.Appointment;
import com.techelevator.model.Doctor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAppointmentDao implements AppointmentDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcAppointmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Appointment getApptById(int apptId){
        Appointment appointment = null;
        String sql = "SELECT * FROM appointment WHERE appointment_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, apptId);
        if(result.next()){
            appointment = mapRowToAppointment(result);
        }

        return appointment;
    }

    @Override
    public Appointment newAppt(Appointment appointment) {
        Appointment newAppointment = null;
        String sql = "INSERT INTO appointment (doctor_id, appt_date, start_time, duration, patient_id, office_id) " +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING appointment_id";
        int appointmentId = jdbcTemplate.queryForObject(sql, int.class, appointment.getDoctorId(), appointment.getApptDate(), appointment.getStartTime(),
                appointment.getDuration(), appointment.getPatientId(), appointment.getOfficeId());

        return getApptById(appointmentId);
    }


    @Override
    public void cancelAppt(int apptId) {

    }

    @Override
    public List<Appointment> getAppointmentsByDoctor(int doctorId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointment WHERE doctor_id = ? ORDER BY appt_date ASC";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
        while (results.next()){
            Appointment appointment = mapRowToAppointment(results);
            appointments.add(appointment);
        }
        return appointments;
    }

    @Override
    public List<Appointment> getAppointmentsByPatient(int patientId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointment WHERE patient_id = ? ORDER BY appt_date ASC";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
        while (results.next()) {
            Appointment appointment = mapRowToAppointment(results);
            appointments.add(appointment);
        }
        return appointments;
    }

    @Override
    public List<Appointment> getAppointmentsByDocDate(int doctorId, LocalDate apptDate) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointment WHERE doctor_id = ? AND appt_date = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId, apptDate);
        while (results.next()){
            Appointment appointment = mapRowToAppointment(results);
            appointments.add(appointment);
        }
        return appointments;
    }

    private Appointment mapRowToAppointment(SqlRowSet row){
        Appointment appointment = new Appointment(
                row.getInt("appointment_id"),
                row.getInt("doctor_id"),
                row.getDate("appt_date").toLocalDate(),
                row.getTime("start_time").toLocalTime(),
                row.getInt("duration"),
                row.getInt("patient_id"),
                row.getInt("office_id")
        );

        return appointment;
    }
}
