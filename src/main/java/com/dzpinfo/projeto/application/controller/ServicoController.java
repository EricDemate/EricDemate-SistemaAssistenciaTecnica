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
@RequestMapping("/api/servico")

public class ServicoController {

	@Autowired
	private ServicoService servicoService;

	// Listar todos os serviços
	@GetMapping
	public ResponseEntity<List<ServicoDTO>> listarServicos() {
		List<ServicoDTO> servicos = servicoService.listarServicos();
		return new ResponseEntity<>(servicos, HttpStatus.OK);
	}

	// Obter um serviço por ID
	@GetMapping("/{id}")
	public ResponseEntity<ServicoDTO> obterServicoPorId(@PathVariable Long id) {
		ServicoDTO servico = servicoService.obterServicoPorId(id);
		if (servico != null) {
			return new ResponseEntity<>(servico, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Criar um novo serviço
	@PostMapping
	public ResponseEntity<ServicoDTO> criarServico(@RequestBody ServicoDTO servicoDTO) {
		ServicoDTO novoServico = servicoService.criarServico(servicoDTO);
		return new ResponseEntity<>(novoServico, HttpStatus.CREATED);
	}

	// Atualizar um serviço existente
	@PutMapping("/{id}")
	public ResponseEntity<ServicoDTO> atualizarServico(@PathVariable Long id, @RequestBody ServicoDTO servicoDTO) {
		ServicoDTO servicoAtualizado = servicoService.atualizarServico(id, servicoDTO);
		if (servicoAtualizado != null) {
			return new ResponseEntity<>(servicoAtualizado, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Deletar um serviço
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarServico(@PathVariable Long id) {
		boolean deletado = servicoService.deletarServico(id);
		if (deletado) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
