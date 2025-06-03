package com.spring.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.LoginRegDto;
import com.spring.entity.LoginRegister;
import com.spring.entity.ProfileLoginDataDTO;
import com.spring.entity.Profiles;
import com.spring.entity.Request;
import com.spring.repo.LoginRegisterRepo;
import com.spring.repo.ProfileRepo;
import com.spring.repo.RequestRepo;
import com.spring.service.ProfileService;
import com.spring.service.RequestService;
import com.spring.service.loginService;

@RestController
//@RequestMapping("")
@CrossOrigin("*")
public class LoginRestController {
	@Autowired
	LoginRegisterRepo loginRegisterRepo;
	@Autowired
	loginService loginService;

	@Autowired
	ProfileRepo profileRepo;

	@Autowired
	ProfileService profileService;
	
	@Autowired
	RequestService requestService;
	
	@Autowired
	RequestRepo requestRepo;
	
	
	
	

	@PostMapping("/Register")
	public LoginRegister register(@RequestBody LoginRegister loginRegister) {
		System.out.println(loginRegister);
		return loginService.register(loginRegister);

	}

	@PostMapping("/login")
	public LoginRegister login(@RequestBody LoginRegister loginRegister) {
		System.out.println("login" + loginRegister);

		return loginService.loginuser(loginRegister); 
	}
 
	@GetMapping("/showAllData/{gender}")
	public List<LoginRegDto> showAllData(@PathVariable String gender ) {
		System.out.println(gender);
		
		if (gender.equalsIgnoreCase("woman")) {
			System.out.println(loginService.showAllDataByGender("man"));
				return loginService.showAllDataByGender("man");
			} else {
				return loginService.showAllDataByGender("woman");
			}
	
		

	}
	
	
	@GetMapping("/getProfile/{id}")
	public Profiles getProfileByLoginId(@PathVariable Long id) {
		System.out.println(id);
		Optional<Profiles> profile=profileRepo.findByLoginRegiId(id);
		System.out.println("profile"+profile);
		if (!profile.isEmpty()) {
			return profile.get();
		}
		return null;
		
	}

	
	@PostMapping("/editProfile/{LoginId}")
	public int editSaveProfileAndLogin(@RequestBody ProfileLoginDataDTO dataDTO, @PathVariable Long LoginId) {
		System.out.println(dataDTO);
//		System.out.println(dataDTO);
		
		Optional<Profiles> profile = profileRepo.findByLoginRegiId(LoginId);
		System.out.println(profile);
		
		
		LoginRegister loginRegister = new LoginRegister();
		loginRegister.setUsername(dataDTO.getUsername());
		loginRegister.setLoginRegId(LoginId);
		loginRegister.setDateOfBirth(dataDTO.getDateOfBirth());
		loginRegister.setEmail(dataDTO.getEmail());
		loginRegister.setFullName(dataDTO.getFullName());
		loginRegister.setGender(dataDTO.getGender());
		
		
		LoginRegister loginRegister22 =loginRegisterRepo.findById(LoginId).orElse(new LoginRegister());
		loginRegister.setPassword(loginRegister22.getPassword());
		
		if (!profile.isEmpty()) {
			System.out.println("method called");
			profileRepo.updateProfileByLoginRegiId(LoginId, dataDTO.getImage1(), dataDTO.getImage2(), dataDTO.getImage3(), dataDTO.getImage4(), dataDTO.getImage5(), dataDTO.getBio(), dataDTO.getInterests());
			loginRegisterRepo.save(loginRegister);
			return 1;
		}else if(profile.isEmpty()){
			
			Profiles profiles = new Profiles(LoginId, dataDTO.getImage1(), dataDTO.getImage2(), dataDTO.getImage3(), dataDTO.getImage4(), dataDTO.getImage5(), dataDTO.getBio(), dataDTO.getInterests());
			loginRegisterRepo.save(loginRegister);
			profileRepo.save(profiles);
			return 1;
		}else {
			return 0;
		}	
	}
	
	@GetMapping("/getLoginData/{id}")
	public LoginRegister getLoginData(@PathVariable Long id) {
		return loginRegisterRepo.findById(id).orElse(new LoginRegister());
	}
	
	@GetMapping("/getByprofile/{id}")
	public Profiles profileshow(@PathVariable Long id) {
		Optional<Profiles> profile = profileRepo.findByLoginRegiId(id);
		System.out.println(profile);
		return profile.get();	
	}
	
	@PostMapping("/Request/{reciverId}")
	public Request request(@PathVariable Long reciverId,@RequestBody Long senderid) {
	    System.out.println("Received request: " + reciverId);
	    System.out.println(senderid);
	    return requestService.requestdata(reciverId, senderid);
	    
	}
	
	@GetMapping("/Viewrequestshow/{reciverId}")
	public List<LoginRegister>  requestshow(@PathVariable Long reciverId) {
		System.out.println(reciverId);
		return requestService.showrequest(reciverId);
//		return null;
	}
	

	@GetMapping("/acceptStatus/{reciverId}/{senderId}")
	public Request acceptStatus(@PathVariable Long reciverId,@PathVariable Long senderId) {
		return requestService.acceptStatus(reciverId,senderId);
	}
	@GetMapping("/showFriendsInMessages/{reciverId}")
	public List<LoginRegister>  showFriendsInMessages(@PathVariable Long reciverId) {
		System.out.println(reciverId);
		return requestService.showFriendsInMessages(reciverId);
//		return null;
	}
	
	
	
}
