package br.com.bancoamazonia.api.suacontabasa.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bancoamazonia.api.suacontabasa.controller.dto.DadosGeraisResponse;
import br.com.bancoamazonia.api.suacontabasa.controller.dto.PessoaResponse;
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
	public PessoaResponse findById(@PathVariable("idPessoa") Long idPessoa){
		return modelMapper.map(manager.findByIdPessoa(idPessoa),PessoaResponse.class);
	}
	
	@GetMapping(value="/nome/{nome}" )
	public DadosGeraisResponse obterPorNome(@PathVariable("nome")String nome){
		Pessoa pessoa =  manager.findByNome(nome);
		return   modelMapper.map(contaManager.findById(pessoa.getIdPessoa()),DadosGeraisResponse.class);
	}
	
	@GetMapping(value = "/cpf-cnpj/{idFiscal}")
	public DadosGeraisResponse obterPorIdFiscal(@PathVariable("idFiscal") Long idFiscal){
		Pessoa pessoa = manager.findByIdFiscal(idFiscal);
		return  modelMapper.map(contaManager.findById(pessoa.getIdPessoa()),DadosGeraisResponse.class);
	}
	
	
	@PostMapping(value="/cadastro")
	public PessoaResponse insert(@RequestBody Pessoa obj) {
		return modelMapper.map(manager.insert(obj), PessoaResponse.class);
	}
	
	@DeleteMapping(value="/desativacao/{idPessoa}")
	public void delete(@PathVariable("idPessoa") Long idPessoa) {
		 manager.delete(idPessoa);
	}
}
