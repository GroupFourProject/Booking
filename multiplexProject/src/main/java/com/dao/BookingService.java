package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Booking;
@Service
public class BookingService {
	@Autowired
	BookingDAO bookingDAOImpl;

	public void add(Booking b) {
		bookingDAOImpl.addBooking(b);
	}
	public Booking findBooking(int id) {
	  return bookingDAOImpl.find(id);
	}
	public List<Booking> findAllBookings(){
		return bookingDAOImpl.findAll();
	}
	public boolean update(Booking b) {
		return bookingDAOImpl.updateBooking(b);
	}
	public boolean delete(int id) {
		return bookingDAOImpl.deleteBooking(id);
	}
}
