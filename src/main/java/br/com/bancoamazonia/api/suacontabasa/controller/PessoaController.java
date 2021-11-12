package br.com.bancoamazonia.api.suacontabasa.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bancoamazonia.api.suacontabasa.controller.dto.PessoaResponse;
import br.com.bancoamazonia.api.suacontabasa.domain.model.Conta;
import br.com.bancoamazonia.api.suacontabasa.domain.model.Pessoa;
import br.com.bancoamazonia.api.suacontabasa.manager.ContaManager;
import br.com.bancoamazonia.api.suacontabasa.manager.PessoaManager;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

	@Autowired
	private PessoaManager manager;
	
	@Autowired
	private ContaManager contaManager;
	
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
	
	@GetMapping(value="/nome/{nome}")
	public ResponseEntity<List<Conta>> obterPorNome(@PathVariable("nome")String nome){
		Pessoa pessoa = manager.findByNome(nome);
		List<Conta> conta = contaManager.findByIdPessoa(pessoa.getIdPessoa());
		return ((BodyBuilder) ResponseEntity.ok().body(pessoa)).body(conta);
	}
	
	@GetMapping(value = "/cpf-cnpj/{idFiscal}")
	public ResponseEntity<List<Conta>> obterPorIdFiscal(@PathVariable("idFiscal") Long idFiscal){
		Pessoa pessoa = manager.findByIdFiscal(idFiscal);
		List<Conta> conta = contaManager.findByIdPessoa(pessoa.getIdPessoa());
		return ((BodyBuilder) ResponseEntity.ok().body(pessoa)).body(conta);
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
	public void delete(@PathVariable("idPessoa") Long idPessoa) {
		 manager.delete(idPessoa);
	}
}
