package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Booking;
@Repository
public interface BookingDAO {
public void addBooking(Booking b);
public Booking find(int id);
public List<Booking> findAll();
public boolean updateBooking(Booking b);
public boolean deleteBooking(int id);

}
