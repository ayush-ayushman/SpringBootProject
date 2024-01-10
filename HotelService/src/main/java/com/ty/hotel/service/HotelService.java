package com.ty.hotel.service;
import java.util.List;
import com.ty.hotel.entity.Hotel;
public interface HotelService {
    Hotel SaveHotal(Hotel hotel);
    Hotel get(String id);
    List<Hotel> getAllHotel();
}
