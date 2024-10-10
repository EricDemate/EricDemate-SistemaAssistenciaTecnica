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
@RequestMapping("/clientes")

public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping // Criar Cliente.
	public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteDTO clienteDTO) {
		ClienteDTO novoCliente = clienteService.salvarCliente(clienteDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoClente);
	}

	@GetMapping // Lista todos os clientes.
	public ResponseEntity<List<ClienteDTO>> listarClientes() {
		List<ClienteDTO> clientes = clientesService.listarClientes();
		return ResponseEntity.ok(clientes);
	}

	@GetMapping("/{id}") // Busca clientte por ID
	public ResponseEntity<ClienteDTO> buscarClientePorId(@PathVariable Long id) {
		ClienteDTO cliente = clienteService.buscarClientePorId(id);
		return ResponseEntity.ok(cliente);

	}

	@PutMapping("/{id}") // Atualiza Cliente
	public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
		ClienteDTO clienteAtualizado = clienteService.atualizarCliente(id, clienteDTO);
		return ResponseEntity.ok(clienteAtualizado);
	}

	@DeleteMapping("/{id}") // Deleta Cliente
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
		clienteService.deletarCliente(id);
		return ResponseEntity.noContent().build();
	}

}
