package br.com.bancoamazonia.api.suacontabasa.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bancoamazonia.api.suacontabasa.controller.dto.ContaResponse;
import br.com.bancoamazonia.api.suacontabasa.domain.model.Conta;
import br.com.bancoamazonia.api.suacontabasa.manager.ContaManager;

@RestController
@RequestMapping(value = "/contas")
public class ContaController {
	
	@Autowired
	private ContaManager manager;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public ResponseEntity<List<Conta>> findAll(){
		List<Conta> list = manager.findAll();
		return ResponseEntity.ok().body(list);
				}

	@GetMapping(value = "/{agencia}")
	public ResponseEntity<Conta> findById(@PathVariable Long agencia){
		Conta obj = manager.findByAgencia(agencia);
		return ResponseEntity.ok().body(obj);
	}
	
	@PatchMapping(value="/saldo/{idFiscal}")
	public void updateSaldo(@PathVariable Long id, @RequestBody Conta conta){
		conta = manager.update(id, conta);
		
	}
	@PostMapping(value="/cadastro")
	public ContaResponse insert(@RequestBody Conta obj) {
		return modelMapper.map(manager.insert(obj), ContaResponse.class);
	}
	
	/*
	@PostMapping(value="/cadastro")
	public ResponseEntity<Conta> insert(@RequestBody Conta obj){
		obj = manager.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idPessoa}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	} */
	
	@DeleteMapping(value="/desativacao/{idConta}")
	public void delete(@PathVariable("idConta") Long idConta, @RequestBody Conta conta) {
		 conta = manager.delete(idConta, conta);
	}
}
