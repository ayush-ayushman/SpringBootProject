package com.ty.service;
import java.time.Instant;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ty.entity.RefreshToken;
import com.ty.entity.User;
import com.ty.repositories.RefreshTokenRepository;
import com.ty.repositories.UserRepository;

@Service
public class RefreshTokenService {
	public long refreshTokenValidity=2*60*1000;
	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	@Autowired
	private UserRepository userRepository;
	public RefreshToken createRefreshToken(String username)
	{
		User user=userRepository.findByEmail(username).get();
		RefreshToken refreshToken1=user.getRefreshToken();
		if(refreshToken1==null)
		{
			refreshToken1=RefreshToken.builder()
					.refreshToken(UUID.randomUUID().toString())
					.expiry(Instant.now().plusMillis(refreshTokenValidity))
					.user(user)
					.build();
		}
		else
		{
			refreshToken1.setExpiry(Instant.now().plusMillis(refreshTokenValidity));
		}
		user.setRefreshToken(refreshToken1);
		
		refreshTokenRepository.save(refreshToken1);
		return refreshToken1;
		
	}
	public RefreshToken varifyRefreshToken(String refreshToken)
	{
		RefreshToken refreshTokenOb=refreshTokenRepository.findByRefreshToken(refreshToken).orElseThrow(()->new RuntimeException("invalid token"));
		if(refreshTokenOb.getExpiry().compareTo(Instant.now())<0)
		{
			refreshTokenRepository.delete(refreshTokenOb);
			throw new RuntimeException("Refresh Token Invalid");
			
		}
		else
			return refreshTokenOb;
		
		
		
	}

}
