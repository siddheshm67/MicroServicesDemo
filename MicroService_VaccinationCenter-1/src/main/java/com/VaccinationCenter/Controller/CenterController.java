package com.VaccinationCenter.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Timeouts;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.VaccinationCenter.Service.VaccinationCenterRepo;
import com.VaccinationCenter.entity.VaccinationCenter;
import com.VaccinationCenter.model.Citizen;
import com.VaccinationCenter.model.REquiredResponce;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;



@RestController
@RequestMapping("/VaccinationCenter")
public class CenterController {
	
	@Autowired
	private VaccinationCenterRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/test")
	public ResponseEntity<String> test(){
		
		
		return new ResponseEntity<String>("hello VaccinationCenter ",org.springframework.http.HttpStatus.OK);
	}
	
	@RequestMapping("/add")
	public ResponseEntity<VaccinationCenter> addCenter(@RequestBody VaccinationCenter vaccinationCenter){
		
		VaccinationCenter center = repo.save(vaccinationCenter);
		return new ResponseEntity<VaccinationCenter>(center,HttpStatus.OK);
	}
	
	@RequestMapping("/getData/{id}")
	@HystrixCommand(fallbackMethod = "handelDownTime",commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000")})
	
	public ResponseEntity<REquiredResponce> getDataByCenterID(@PathVariable ("id") int id){
		
		REquiredResponce responce = new REquiredResponce();
		
		VaccinationCenter result = repo.findById(id).get();
		
		
		responce.setCenter(result);
		
		List<Citizen> citizenList = restTemplate.getForObject("http://localhost:8001/citizen/citi/"+id, List.class);
		System.out.println("***********main method called***** "+citizenList);
		responce.setCitizens(citizenList);
		return new ResponseEntity<REquiredResponce>(responce,HttpStatus.OK);
		

	}
	
	ResponseEntity<REquiredResponce> handelDownTime(@PathVariable int id1){
		
		REquiredResponce responce1 = new REquiredResponce();
		
		VaccinationCenter result1 = repo.findById(id1).get();
		
		responce1.setCenter(result1);
		System.out.println("***********second method called***** "+responce1);
		return new ResponseEntity<>(responce1,HttpStatus.OK);
		
		
	}
}
