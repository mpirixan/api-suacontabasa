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

import br.com.bancoamazonia.api.suacontabasa.controller.dto.PessoaResponse;
import br.com.bancoamazonia.api.suacontabasa.domain.model.Pessoa;
import br.com.bancoamazonia.api.suacontabasa.manager.PessoaManager;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

	private PessoaManager manager;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll(){
		List<Pessoa> list = manager.findAll();
		return ResponseEntity.ok().body(list);
				}

	@GetMapping(value = "/idpessoa/{idPessoa}")
	public ResponseEntity<Pessoa> findById(@PathVariable("idPessoa") Long idPessoa){
		Pessoa pessoa = manager.findByIdPessoa(idPessoa);
		return ResponseEntity.ok().body(pessoa);
	}
	

	@GetMapping(value = "/cpf-cnpj/{idFiscal}")
	public ResponseEntity<Pessoa> findByIdFiscal(@PathVariable("idFiscal") Long idFiscal){
		Pessoa pessoa = manager.findByIdFiscal(idFiscal);
		return ResponseEntity.ok().body(pessoa);
	}
	
	@PatchMapping(value="/dados/{idFiscal}")
	public void updateDados(@PathVariable("idFiscal") Long id, @RequestBody Pessoa pessoa){
		pessoa = manager.update(id, pessoa);
		
	}
	@PostMapping(value="/cadastro")
	public PessoaResponse insert(@RequestBody Pessoa obj) {
		return modelMapper.map(manager.insert(obj), PessoaResponse.class);
	}
	
	/*
	@PostMapping(value="/cadastro")
	public ResponseEntity<Conta> insert(@RequestBody Conta obj){
		obj = manager.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idPessoa}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	} */
	
	@DeleteMapping(value="/desativacao/{idPessoa}")
	public void delete(@PathVariable("idPessoa") Long idPessoa, @RequestBody Pessoa pessoa) {
		 pessoa = manager.delete(idPessoa, pessoa);
	}
}
