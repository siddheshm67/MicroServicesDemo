package com.CitizenService.Repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CitizenService.entity.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Integer>{
	
	public List<Citizen> findByVacCentId(Integer idInteger);
}
