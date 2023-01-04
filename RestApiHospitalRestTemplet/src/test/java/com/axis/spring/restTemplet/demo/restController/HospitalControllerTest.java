package com.axis.spring.restTemplet.demo.restController;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;


import com.axis.spring.restTemplet.demo.beans.Hospital;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class HospitalControllerTest {

	@Autowired
	RestTemplate restTemplate ;
	
	@Test
	void testAddHospital() {
		Hospital data = new Hospital(106 , "abhishek" , "covid" , LocalDate.of(2022, 05, 25) , LocalDate.of(2022, 05, 29));
		Hospital data1 = restTemplate.postForObject("http://localhost:8080/patient/general/add",data , Hospital.class);
		log.info("data added : "+data1);
	}

	@Test
	void testUpdateHospital() {
		Hospital data = new Hospital(105 , "root" , "covid" , LocalDate.of(2022, 05, 25) , LocalDate.of(2022, 05, 29));
		restTemplate.put("http://localhost:8080/patient/general/update",data , Hospital.class);
	}

	@Test
	void testGetAll() {
		Hospital[] list =  restTemplate.getForObject("http://localhost:8080/patient/general/get", Hospital[].class);
	}

	@Test
	void testGetOne() {
		int id = 101 ;
		Hospital e1 = restTemplate.getForObject("http://localhost:8080/patient/general/get/"+ id, Hospital.class);
		log.info("deails from id : "+e1);
	}

	@Test
	void testDelete() {
		int id = 102 ;
		 restTemplate.delete("http://localhost:8080/patient/general/delete/"+ id , Hospital.class);
	}


}
