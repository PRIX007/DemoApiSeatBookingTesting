package com.exampleapi.demo.controller;



import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exampleapi.demo.model.Location;
import com.exampleapi.demo.repository.LocationRepo;
import com.exampleapi.demo.service.LocationService;

@RestController
@RequestMapping("/location")
public class LocationController {

	@Autowired
	LocationService locationService;
	
	@PostMapping("/create")

	public String createLocation(@RequestBody Location location){
		locationService.createLocation(location);
		return "success";
	}
	@GetMapping("/list")
	public List<Location> getListLocation()
	{ 
		return locationService.listLocation();
	}
	@PostMapping ("/update/{locationCode}")
	public String updateLocation(@PathVariable ("locationCode") String locationCode,@RequestBody Location location )
	{ 
		System.out.println("locaationID:"+locationCode);
		 boolean t =locationService.editByLocationCode(locationCode,location);
		 return "ok";
		
	}
	@PostMapping ("/update/byCode")
	public String updateLocationByCode(@RequestParam(name="code",required = false, defaultValue = "*****") String code,@RequestBody Location location)
	{
		boolean ret=locationService.editByLocationCode(code, location);
		return ret==true?"Success" :"Not a valid code";
	}
		
	
}
