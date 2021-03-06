package com.dev.republica.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.republica.model.Morador;
import com.dev.republica.service.MoradorService;
import com.dev.republica.service.RepublicaService;

@RestController
@RequestMapping("/moradores")
@CrossOrigin
public class MoradorController {

	private RepublicaService republicaService;
	private MoradorService moradorService;

	public MoradorController(RepublicaService republicaService, MoradorService moradorService) {
		this.republicaService = republicaService;
		this.moradorService = moradorService;
	}

	@GetMapping
	public List<Morador> getMoradores() {
		return moradorService.getAllMoradores();
	}

	@GetMapping(path = { "/{id}" })
	public Morador getMorador(@PathVariable Long id) {
		return moradorService.getMorador(id);
	}

	@PostMapping
	public Morador create(@RequestBody Morador morador) {
		return moradorService.save(morador);
	}

	@PutMapping(value = "/{id}")
	public Morador update(@PathVariable("id") Long id, @RequestBody Morador morador) {
		return moradorService.update(id, morador);
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return republicaService.deleteById(id);
	}

}
