package br.usjt.hamilton.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import br.usjt.hamilton.model.bean.City;
import br.usjt.hamilton.model.repository.CityRepository;


@RestController
@RequestMapping("/api/city/")
public class CityController {
	@Autowired
	private REController responseController;
	@Autowired
	private CityRepository cityRepo;


	@RequestMapping(value = "/cities/", method = RequestMethod.GET) // @GetMapping ("/list")
	public List<City> AllCities() {
		return cityRepo.findAll();
	}

	@PostMapping("/save")
	public ResponseEntity<?> Save(@RequestBody City city, HttpServletResponse response) {
		City c = cityRepo.save(city);
		return responseController.responseController(c, HttpStatus.OK);
	}

	@GetMapping("/latitudeLongitude/{latitude}/{longitude}")
	public City GetCityByLatitudeLongitude(@PathVariable String latitude, @PathVariable String longitude) {
		return cityRepo.buscarPelaLatitudeLongitudeNQ(latitude, longitude);
	}

	@GetMapping("/letter/{letter}")
	public List<City> GetCityByLetter(@PathVariable String letter) {
		return cityRepo.findByFirstLetter(letter);
	}
}
