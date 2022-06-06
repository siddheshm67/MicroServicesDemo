package com.CitizenService.Controller;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CitizenService.Repositery.CitizenRepository;
import com.CitizenService.entity.Citizen;

@RestController
@RequestMapping("/citizen")
public class Citizen_Controller {
	
	@Autowired
	private CitizenRepository citizenRepository;
	
	@RequestMapping("/test")
	public ResponseEntity<String> test(){
		
		
		return new ResponseEntity<String>("hello",org.springframework.http.HttpStatus.OK);
	}
	
	@RequestMapping("/citi/{id}")
	public ResponseEntity<List<Citizen>> getByid(@PathVariable("id") Integer id){
		
		List<Citizen> list = citizenRepository.findByVacCentId(id);
		return new ResponseEntity<>(list,org.springframework.http.HttpStatus.OK);
		
	}
	
	@RequestMapping("/add")
	public ResponseEntity<Citizen> addEntity(@RequestBody Citizen citizen){
		
		Citizen citizen2 = citizenRepository.save(citizen);
		
		return new ResponseEntity<>(citizen2,org.springframework.http.HttpStatus.OK);
	}
}
