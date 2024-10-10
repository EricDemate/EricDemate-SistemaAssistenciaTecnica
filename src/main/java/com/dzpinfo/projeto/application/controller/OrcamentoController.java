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
@RequestMapping("/orcamentos")

public class OrcamentoController {

	@Autowired
	private OrcamentoService orcamentoService;

	@PostMapping
	public ResponseEntity<OrcamentoDTO> criarOrcamento(@RequestBody OrcamentoDTO orcamentoDTO) {
		OrcamentoDTO novoOrcamento = orcamentoService.salvarOrcamento(orcamentoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoOrcamento);
	}

	@GetMapping
	public ResponseEntity<List<OrcamentoDTO>> listarOrcamentos() {
		List<OrcamentoDTO> orcamentos = orcamentoService.listarOrcamentos();
		return ResponseEntity.ok(orcamentos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrcamentoDTO> buscarOrcamentoPorId(@PathVariable Long id) {
		OrcamentoDTO orcamento = orcamentoService.buscarOrcamentoPorId(id);
		return ResponseEntity.ok(orcamento);
	}

	@PutMapping("/{id}")
	public ResponseEntity<OrcamentoDTO> atualizarOrcamento(@PathVariable Long id,
			@RequestBody OrcamentoDTO orcamentoDTO) {
		OrcamentoDTO orcamentoAtualizado = orcamentoService.atualizarOrcamento(id, orcamentoDTO);
		return ResponseEntity.ok(orcamentoAtualizado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarOrcamento(@PathVariable Long id) {
		orcamentoService.deletarOrcamento(id);
		return ResponseEntity.noContent().build();
	}

}
