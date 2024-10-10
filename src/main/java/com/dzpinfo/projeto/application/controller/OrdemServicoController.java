package com.dzpinfo.projeto.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ordem-servico")

public class OrdemServicoController {

	@Autowired
	private OrdemServicoService ordemServicoService;

	// Buscar todas as ordens de serviço
	@GetMapping
	public ResponseEntity<List<OrdemServicoDTO>> listarOrdensServico() {
		List<OrdemServicoDTO> ordens = ordemServicoService.listarOrdensServico();
		return new ResponseEntity<>(ordens, HttpStatus.OK);
	}

	// Buscar uma ordem de serviço por ID
	@GetMapping("/{id}")
	public ResponseEntity<OrdemServicoDTO> obterOrdemServicoPorId(@PathVariable Long id) {
		OrdemServicoDTO ordemServico = ordemServicoService.obterOrdemServicoPorId(id);
		if (ordemServico != null) {
			return new ResponseEntity<>(ordemServico, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Criar uma nova ordem de serviço
	@PostMapping
	public ResponseEntity<OrdemServicoDTO> criarOrdemServico(@RequestBody OrdemServicoDTO ordemServicoDTO) {
		OrdemServicoDTO novaOrdemServico = ordemServicoService.criarOrdemServico(ordemServicoDTO);
		return new ResponseEntity<>(novaOrdemServico, HttpStatus.CREATED);
	}

	// Atualizar uma ordem de serviço existente
	@PutMapping("/{id}")
	public ResponseEntity<OrdemServicoDTO> atualizarOrdemServico(@PathVariable Long id,
			@RequestBody OrdemServicoDTO ordemServicoDTO) {
		OrdemServicoDTO ordemAtualizada = ordemServicoService.atualizarOrdemServico(id, ordemServicoDTO);
		if (ordemAtualizada != null) {
			return new ResponseEntity<>(ordemAtualizada, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Deletar uma ordem de serviço
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarOrdemServico(@PathVariable Long id) {
		boolean deletado = ordemServicoService.deletarOrdemServico(id);
		if (deletado) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
