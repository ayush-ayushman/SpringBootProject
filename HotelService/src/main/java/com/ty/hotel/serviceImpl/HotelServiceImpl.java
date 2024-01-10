package com.ty.hotel.serviceImpl;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ty.hotel.entity.Hotel;
import com.ty.hotel.exception.MyException;
import com.ty.hotel.repository.HotelRepository;
import com.ty.hotel.service.HotelService;
@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel SaveHotal(Hotel hotel) {
		String st=UUID.randomUUID().toString();
		hotel.setId(st);
	 Hotel h=hotelRepository.save(hotel);
		return h;
	}

	@Override
	public Hotel get(String id) {
		
		return hotelRepository.findById(id).orElseThrow(()-> new MyException("hotel not found by this id"));
	}

	@Override
	public List<Hotel> getAllHotel() {
		
		return hotelRepository.findAll();
	}
	
	
}
