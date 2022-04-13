package com.multiplex.multiplexProject;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.BookingService;
import com.model.Booking;

import junit.framework.Assert;
@SpringBootTest
class BookingTest {
	@Autowired
	BookingService service;

	@Test
	void addtest() {
		Booking b = new Booking();
		b.setShowId(123);
		b.setUserId(124);
		String str="2022-04-12";
		Date d=Date.valueOf(str);
		String str1="2022-04-14";
		Date d1=Date.valueOf(str1);
		b.setBookDate(d);
		b.setShowDate(d1);
		service.add(b);
		Booking b1=service.findBooking(b.getBookingId());
		Assert.assertEquals(123,b1.getShowId());
		Assert.assertEquals(124,b1.getUserId());
		 
	}
	
	@Test
	void delete() {
		Booking b1=new Booking();
		service.add(b1);
		Booking b=service.findBooking(1);
		service.delete(1);
		Booking b2 = service.findBooking(1);
		Assert.assertNull(b2);
		
	}
	
	@Test
	void update() {
		Booking b = new Booking();
		b.setShowId(1256);
		String str ="2022-04-01";
		Date d = Date.valueOf(str);
		String str1 ="2022-04-02";
		Date d1=Date.valueOf(str1);
		b.setBookDate(d);
		b.setShowDate(d1);
		b.setUserId(111);
		service.add(b);
		b.setShowId(123567);
		service.update(b);
		Assert.assertEquals(true,service.update(b));
	}
	@Test
	void findAllBookings() {
		Booking b = new Booking();
		String str="2022-04-1";
		Date d=Date.valueOf(str);
		String str1="2022-04-3";
		Date d1=Date.valueOf(str1);
		b.setBookDate(d);
		b.setShowDate(d1);
		b.setShowId(1);
		b.setUserId(11);
		service.add(b);
		Booking b1 = new Booking();
		String str2="2022-04-12";
		Date d2=Date.valueOf(str2);
		String str3="2022-04-14";
		Date d3=Date.valueOf(str3);
		b1.setBookDate(d2);
		b1.setShowDate(d3);
		b1.setShowId(12);
		b1.setUserId(112);
		service.add(b1);
		Booking b2 = new Booking();
		String str4="2022-04-12";
		Date d4=Date.valueOf(str4);
		String str5="2022-04-14";
		Date d5=Date.valueOf(str5);
		b2.setBookDate(d4);
		b2.setShowDate(d5);
		b2.setShowId(122);
		b2.setUserId(1122);
		service.add(b2);
		List<Booking> bookinglist=service.findAllBookings();
		Assert.assertEquals(123, bookinglist.get(0).getShowId());
	}
	@Test
	void findBooking() {
		Booking b = new Booking();
		String str="2022-04-10";
		Date d=Date.valueOf(str);
		String str1="2022-04-30";
		Date d1=Date.valueOf(str1);
		b.setBookDate(d);
		b.setShowDate(d1);
		b.setShowId(12345);
		b.setUserId(111);
		service.add(b);
		Booking b1=service.findBooking(b.getBookingId());
		Assert.assertEquals(111,b1.getUserId());
	}
}


