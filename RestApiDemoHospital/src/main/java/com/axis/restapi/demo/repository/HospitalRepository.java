package com.axis.restapi.demo.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import com.axis.restapi.demo.beans.Hospital;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

	List<Hospital> findByPatientName(String patientName);
	List<Hospital> findByDiseases(String diseases);
	List<Hospital> findByAdmitDate(LocalDate admitDate);
	List<Hospital> findByDischargeDate(LocalDate dischargeDate);
	List<Hospital> findByOrderByPatientId(); 
	
	@Query("select h from Hospital h where h.admitDate between ?1 and  ?2")
	List<Hospital> findByAdmitDateRange(LocalDate date1 , LocalDate date2);
	
	@Query("select h from Hospital h where h.dischargeDate between ?1 and  ?2")
	List<Hospital> findByDischargeDateRange(LocalDate date1 , LocalDate date2);
	
	@Query("select h from Hospital h where h.admitDate > ?1")
	List<Hospital> findByAfterAdmitDate(LocalDate date1);
	
	@Query("select h from Hospital h where h.admitDate < ?1")
	List<Hospital> findByBeforeAdmitDate(LocalDate date1);
	
	@Query("select h from Hospital h where h.dischargeDate > ?1")
	List<Hospital> findByAfterDischargeDate(LocalDate date1);
	
	@Query("select h from Hospital h where h.dischargeDate < ?1")
	List<Hospital> findByBeforeDischargeDate(LocalDate date1);
	
	@Transactional
	@Modifying
	@Query("delete from Hospital h where h.patientName= ?1")
	void deleteByPatientName(String patientName);
	
	@Transactional
	@Modifying
	@Query("delete from Hospital h where h.diseases= ?1")
	void deleteByDiseases(String diseases);
	
	@Transactional
	@Modifying
	@Query("delete from Hospital h where h.admitDate= ?1")
	void deleteByAdmitDate(LocalDate admitDate);
	
	@Transactional
	@Modifying
	@Query("delete from Hospital h where h.dischargeDate= ?1")
	void deleteByDischargeDate(LocalDate dischargeDate);
	
	@Transactional
	@Modifying
	@Query("update Hospital h set h= ?1 where h.patientName= ?2")
	void updateByPatientName(Hospital hospital , String patientName);
	
	@Transactional
	@Modifying
	@Query("update Hospital h set h= ?1 where h.diseases= ?2")
	void updateByDiseases(Hospital hospital, String diseases);
	
}
