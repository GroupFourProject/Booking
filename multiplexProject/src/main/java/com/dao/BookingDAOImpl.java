package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Booking;
@Component
public class BookingDAOImpl implements BookingDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addBooking(Booking b) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(b);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Booking find(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Booking bk= session.get(Booking.class, id);
		return bk;
	}

	@Override
	public List<Booking> findAll() {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		List<Booking> bookinglist= session.createQuery("select i from Booking i").list();
		return bookinglist;
	}

	@Override
	public boolean updateBooking(Booking b) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(b);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteBooking(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Booking booking=session.find(Booking.class,id);
		session.getTransaction().begin();
		session.delete(booking);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	
}
