package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.BookingService;
import com.model.Booking;

@RestController
public class BookingRestController {
@Autowired
BookingService service;

@GetMapping("/getbookings")
public List<Booking> findall() {
	return service.findAllBookings();
}
public String add(Booking b) {
	service.add(b);
	return "Booking added successfully";
}
}
