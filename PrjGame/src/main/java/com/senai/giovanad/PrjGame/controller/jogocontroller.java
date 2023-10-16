package com.senai.giovanad.PrjGame.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.giovanad.PrjGame.entities.jogo;
import com.senai.giovanad.PrjGame.services.jogoservices;

@RestController
@RequestMapping ("/jogos")
public class jogocontroller {
	
	@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}
	
	private final jogoservices jogoServices;
	
	@Autowired
	public jogocontroller (jogoservices jogoService) {
		this.jogoServices = jogoService;
	}
	
	@PostMapping
	public jogo createjogo (@RequestBody jogo Jogo) {
		return jogoServices.saveJogo(Jogo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <jogo> getJogo(@PathVariable Long id) {
		jogo Jogo = jogoServices.getjogoById(id);
		if (Jogo != null) {
			return ResponseEntity.ok(Jogo);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping
	public List<jogo> getAllJogos(){
		return jogoServices.getAllJogos();
	}
	
	@DeleteMapping
	public void deletejogo(@PathVariable Long id) {
		jogoServices.deletejogo(id);
	}
	

	
	
}
