package com.axis.spring.restTemplet.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import com.axis.spring.restTemplet.demo.beans.Hospital;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HospitalServiceImpTest {

	@Autowired
	HospitalServiceImp service ;
	
	@Test
	void testAddPatient() {
		Hospital data = new Hospital(105 , "john" , "covid" , LocalDate.of(2022, 05, 25) , LocalDate.of(2022, 05, 29));
		Hospital d1 = service.addPatient(data);
		assertEquals("john" , d1.getPatientName());
	}

	@Test
	void testUpdatePatient() {
		Hospital data = new Hospital(105 , "root" , "covid" , LocalDate.of(2022, 05, 25) , LocalDate.of(2022, 05, 29));
		Hospital d1 = service.updatePatient(data);
		assertEquals("root" , d1.getPatientName());
	}

	@Test
	void testGetPatientById() {
		int id = 105 ;
		Hospital data = service.getPatientById(id);
		assertNotNull(data);
	}


	@Test
	void testGetAllPatient() {
		List<Hospital> list = service.getAllPatient();
		assertNotNull(list);
	}

	@Test
	void testFindByPatientName() {
		String name = "root" ; 
		List<Hospital> data = service.findByPatientName(name);
		assertNotNull(data);
	}

	@Test
	void testFindByDiseases() {
		String diseases = "covid" ; 
		List<Hospital> data = service.findByPatientName(diseases);
		assertNotNull(data);
	}


}
