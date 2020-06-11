package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void canFindWhiskyByYear() {
		List<Whisky> found = whiskyRepository.findByYear(2018);
		assertEquals(1L, found.get(0).getId().longValue());
	}

	@Test
	public void canFindDistilleryByRegion() {
		List<Distillery> found = distilleryRepository.findByRegion("Speyside");
		assertEquals(3l, found.get(0).getId().longValue());
	}

	@Test
	public void canFindWhiskyByDistilleryAndAge() {
		List<Whisky> found = whiskyRepository.findByDistilleryNameAndAge("Glendronach", 15);
		assertEquals(1L, found.get(0).getId().longValue());
	}

}
