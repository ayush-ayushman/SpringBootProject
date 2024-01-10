package com.ty.userservice.service.imple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.ty.userservice.entity.Hotel;
import com.ty.userservice.entity.Rating;
import com.ty.userservice.entity.User;
import com.ty.userservice.exception.MyException;
import com.ty.userservice.external.services.HotelService;
import com.ty.userservice.repository.UserRepository;
import com.ty.userservice.service.UserService;
@Service
public class UserServiceImplement implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
	private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;
	private Logger logger=LoggerFactory.getLogger(UserServiceImplement.class);
	@Override
	public User saveUser(User user) {
		String s=UUID.randomUUID().toString();
		user.setUserid(s);
		User u=userRepository.save(user);
		return u;
	}

	@Override
	public List<User> getAllUser() {
		List<User> u=userRepository.findAll();
		
		return u;
	}

	@Override
	public User getUser(String userid) {
		
	    User user =userRepository.findById(userid).orElseThrow(()->new MyException("User didnot find by this id"));
	    //fetching rating of the above user from RATING SERVICES
	   Rating[] ratingOfUser=restTemplate.getForObject("http://RATINGSERVICE/rating/user/"+user.getUserid(),Rating[].class);
	   System.out.println(ratingOfUser);
	   logger.info("{}",ratingOfUser);
	   List<Rating> ratings=Arrays.stream(ratingOfUser).toList();
	   
	  List<Rating> ratingList=ratings.stream().map(rating->{
		 // System.out.println(rating.getHotelId());
		//ResponseEntity<Hotel> forEntity=restTemplate.getForEntity("http://HOTELSERVICE/hotel/"+rating.getHotelId(),Hotel.class);
		//Hotel hotel=forEntity.getBody();
		  Hotel hotel=hotelService.getHotel(rating.getHotelId());
		
		//logger.info("{}",forEntity.getStatusCode());
		//set the hotel to rating
		rating.setHotel(hotel);
		return rating;
	   }).collect(Collectors.toList());
	   user.setRating(ratingList);
		return user;
	 
	}
	

}
