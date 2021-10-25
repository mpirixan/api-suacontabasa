package br.com.bancoamazonia.api.suacontabasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bancoamazonia.api.suacontabasa.domain.model.Conta;
import br.com.bancoamazonia.api.suacontabasa.manager.ContaManager;

@RestController
@RequestMapping(value = "/contas")
public class ContaController {
	
	@Autowired
	private ContaManager manager;
	
	@GetMapping
	public ResponseEntity<List<Conta>> findAll(){
		List<Conta> list = manager.findAll();
		return ResponseEntity.ok().body(list);
				}

	@GetMapping(value = "/{idFiscal}")
	public ResponseEntity<Conta> findById(@PathVariable Long idFiscal){
		Conta obj = manager.findByIdFiscal(idFiscal);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping(value="/saldo/{idFiscal}")
	public ResponseEntity<Double> updateSaldo(@PathVariable Long id, @RequestBody Conta conta){
		conta = manager.update(id, conta);
		return ResponseEntity.ok().body(null);
	}
	
}
