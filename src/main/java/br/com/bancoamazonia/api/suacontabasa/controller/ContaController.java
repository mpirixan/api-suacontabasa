package br.com.bancoamazonia.api.suacontabasa.controller;

import java.util.List;

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
	
	
	@GetMapping
	public ResponseEntity<List<Conta>> findAll(){
		List<Conta> list = manager.findAll();
		return ResponseEntity.ok().body(list);
				}
	@GetMapping(value = "/idconta/{idConta}")
	public ResponseEntity<Conta> findByIdConta(@PathVariable("idConta") Long idConta){
		Conta obj = manager.findByIdConta(idConta);
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping(value = "/agencia/{agencia}")
	public ResponseEntity<Conta> findById(@PathVariable("agencia") Long agencia){
		Conta obj = manager.findByAgencia(agencia);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/saldo/cpf-cnpj")
	public ResponseEntity<Double> obterSaldoPorIdFiscal(Long idFiscal){
		Double saldo = manager.obterSaldoPorIdFiscal(idFiscal);
		return ResponseEntity.ok().body(saldo);
	}
	
	@GetMapping(value = "/saldo/idconta")
	public ResponseEntity<Double> obterSaldoPorIdConta(Long idConta){
		Double saldo = manager.obterSaldoIdConta(idConta);
		return ResponseEntity.ok().body(saldo);
	}
	
	@PatchMapping(value = "/deposito/{idConta}")
	public void depositoSaldo(@PathVariable("idConta") Long idConta, @RequestBody Double obj) {
		manager.depositoSaldo(idConta, obj);
	}
	
	@PatchMapping(value="/saque/{idConta}")
	public void saqueSaldo(@PathVariable("idConta") Long idConta, @RequestBody Double obj){
	
		manager.saqueSaldo(idConta, obj);
		//modelMapper.map(manager.update(idConta, conta), ContaResponse.class);
		}
	
	@PatchMapping(value="/update/{idConta}" , consumes = "application/json-patch+json")
	public void updateSaldo(@PathVariable("idConta") Long idConta, @RequestBody Double obj){
		 manager.services(idConta, obj);
		
	}
	
	// inserção com corpo JSON

	@PostMapping(value="/cadastro")
	public void cadastro( @RequestBody ContaResponse obj){
		//obj.setIdConta(idPessoa);
		manager.cadastro(obj);
	} 
	
	@DeleteMapping(value="/desativacao/{idConta}")
	public void delete(@PathVariable("idConta") Long idConta) { 
		 manager.delete(idConta);
	}
}
