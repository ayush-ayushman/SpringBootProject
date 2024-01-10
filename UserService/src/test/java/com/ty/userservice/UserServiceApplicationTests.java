package com.ty.userservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import com.ty.userservice.entity.Rating;
import com.ty.userservice.external.services.RatingService;

@SpringBootTest
class UserServiceApplicationTests {
    
	@Test
	void contextLoads() {
	}
	//@Autowired
	//private RatingService ratingService;
	//@Test
	//void createRating()
	//{
	//	Rating rat=Rating.builder().rating(10).userId("abcde").hotelId("fghij").feedBack("need to be").build();
	//	Rating saveRating=ratingService.creatRating(rat);
	//	System.out.println("hello");
		
		
	//}

}
