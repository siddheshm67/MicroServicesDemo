package com.VaccinationCenter.Service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VaccinationCenter.entity.VaccinationCenter;

public interface VaccinationCenterRepo extends JpaRepository<VaccinationCenter, Integer> {
	
}
