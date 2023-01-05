package com.knackitsolutions.delhimetro.delhimetrobackend;

import com.knackitsolutions.delhimetro.delhimetrobackend.entity.Station;
import com.knackitsolutions.delhimetro.delhimetrobackend.repository.StationRepository;
import com.knackitsolutions.delhimetro.delhimetrobackend.service.StationInfoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Log4j2
public class DelhiMetroBackendApplication implements ApplicationRunner {

	@Autowired
	private StationInfoService stationInfoService;
	@Autowired
	private StationRepository stationRepository;
	public static void main(String[] args) {
		SpringApplication.run(DelhiMetroBackendApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		List<String> codes = stationRepository.findAll().stream().map(Station::getStationCode).toList();
//		for (String code : codes) {
//			try {
//				stationInfoService.saveStationInfo(code);
//			} catch (Exception e) {
//				log.info("Error on code: {}", code);
//			}
//		}
	}
}
