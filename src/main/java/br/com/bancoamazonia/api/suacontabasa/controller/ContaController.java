package br.com.bancoamazonia.api.suacontabasa.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "http://127.0.0.1:3000")
@RestController
@RequestMapping(value = "/contas")
public class ContaController {
	
	@Autowired
	private ContaManager manager;
	
	@Autowired
	private ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping
	public ResponseEntity<List<Conta>> findAll(){
		List<Conta> list = manager.findAll();
		return ResponseEntity.ok().body(list);
				}
	@GetMapping(value = "/obter-por-idconta/{idConta}")
	public ContaResponse findByIdConta(@PathVariable("idConta") Long idConta) {		
		return modelMapper.map(manager.findByIdConta(idConta) ,ContaResponse.class);
		
	}

	@GetMapping(value = "/saldo/cpf-cnpj")
	public ResponseEntity<String> obterSaldoPorIdFiscal(Long idFiscal){
		Double saldo = manager.obterSaldoPorIdFiscal(idFiscal);
		return ResponseEntity.ok().body("R$ " + saldo);
	}
	
	@GetMapping(value = "/saldo/idconta")
	public ResponseEntity<String> obterSaldoPorIdConta(Long idConta){
		Double saldo = manager.obterSaldoIdConta(idConta);
		return ResponseEntity.ok().body("R$ "+saldo);
	}
	
	@PatchMapping(value = "/deposito/{idConta}")
	public void depositoSaldo(@PathVariable("idConta") Long idConta, @RequestBody Double obj) {
		manager.depositoSaldo(idConta, obj);
	}
	
	@PatchMapping(value="/saque/{idConta}")
	public void saqueSaldo(@PathVariable("idConta") Long idConta, @RequestBody Double obj){
		manager.saqueSaldo(idConta, obj);
		}
	
	// inserção com corpo JSON

	@PostMapping(value="/cadastro")
	public void cadastro( @RequestBody Conta obj){
		 manager.cadastro(obj);
	} 
	/*
	@PostMapping(value="/cadastro")
	public void cadastro(@RequestBody ContaResponse obj) {
		manager.cadastro(obj);
	}
	*/
	@DeleteMapping(value="/desativacao/{idConta}")
	public void delete(@PathVariable("idConta") Long idConta) { 
		 manager.delete(idConta);
	}
}
