package com.ty.repositories;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ty.entity.RefreshToken;


public interface RefreshTokenRepository  extends JpaRepository<RefreshToken,String>{
	Optional<RefreshToken> findByRefreshToken(String token);

}
