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
@RequestMapping("/equipamentos")

public class EquipamentoController {

	@Autowired
	private EquipamentoService equipamentoService;

	@PostMapping
	public ResponseEntity<EquipamentoDTO> criarEquipamento(@RequestBody EquipamentoDTO equipamentoDTO) {
		EquipamentoDTO novoEquipamento = equipamentoService.salvarEquipamento(equipamentoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoEquipamento);
	}

	@GetMapping
	public ResponseEntity<List<EquipamentoDTO>> listarEquipamentos() {
		List<EquipamentoDTO> equipamentos = equipamentoService.listarEquipamentos();
		return ResponseEntity.ok(equipamentos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EquipamentoDTO> buscarEquipamentoPorId(@PathVariable Long id) {
		EquipamentoDTO equipamento = equipamentoService.buscarEquipamentoPorId(id);
		return ResponseEntity.ok(equipamento);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EquipamentoDTO> atualizarEquipamento(@PathVariable Long id,
			@RequestBody EquipamentoDTO equipamentoDTO) {
		EquipamentoDTO equipamentoAtualizado = equipamentoService.atualizarEquipamento(id, equipamentoDTO);
		return ResponseEntity.ok(equipamentoAtualizado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarEquipamento(@PathVariable Long id) {
		equipamentoService.deletarEquipamento(id);
		return ResponseEntity.noContent().build();
	}

}
