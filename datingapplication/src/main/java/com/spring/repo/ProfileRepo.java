package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.spring.entity.Profiles;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;


public interface ProfileRepo extends JpaRepository<Profiles, Long>  {

	Optional<Profiles> findByLoginRegiId(Long loginRegiId);
	
	 @Modifying
	@Transactional
	@Query("UPDATE Profiles p SET p.image1 = :image1, p.image2 = :image2, p.image3 = :image3, p.image4 = :image4, " +
	           "p.image5 = :image5, p.bio = :bio, p.interests = :interests WHERE p.loginRegiId = :loginRegiId")
	    int updateProfileByLoginRegiId(Long loginRegiId, String image1, String image2, String image3, 
	                                   String image4, String image5, String bio, String interests);

}