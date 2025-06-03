package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.entity.LoginRegister;
import java.util.List;
import java.util.Optional;


public interface LoginRegisterRepo extends JpaRepository<LoginRegister, Long> {
	
	Optional<LoginRegister> findByEmailAndPassword(String email, String password);
	@Query("SELECT u FROM LoginRegister u WHERE u.gender <> :gender")
	List<LoginRegister> findByGender(@Param("gender") String gender);
	
	List<LoginRegister> findByLoginRegId(Long loginRegId);

}
