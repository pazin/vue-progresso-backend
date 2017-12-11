package com.example.progresso.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.progresso.business.ProgressoServiceTemp;
import com.example.progresso.business.ReporteStatus;

@RestController
public class ControllerTemp {
	
	@Autowired
	private ProgressoServiceTemp service;
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(value="/progressos")
	public List<ReporteStatus> getProgressos() {
		return service.getReporte();
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(value="/add")
	public String addProgresso() {
		service.addProgresso();
		return "ok";
	}
}
