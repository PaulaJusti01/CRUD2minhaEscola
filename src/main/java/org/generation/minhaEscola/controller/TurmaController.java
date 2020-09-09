package org.generation.minhaEscola.controller;

import java.util.List;

import org.generation.minhaEscola.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turma")
@CrossOrigin("*")

public class TurmaController<Turma> {
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private TurmaRepository repository;
	
	@SuppressWarnings("unchecked")
	@GetMapping
	public ResponseEntity<List<Turma>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}	
	
		@SuppressWarnings("unchecked")
		@GetMapping("/{id}")
		public ResponseEntity<Turma> GetById(@PathVariable long id){
			return (ResponseEntity<Turma>) repository.findById(id)
					.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
			
		}
		
		@SuppressWarnings("unchecked")
		@GetMapping("/titulo/{titulo}")
		public ResponseEntity<List<Turma>> GetByTitulo(@PathVariable String titulo){
			return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
			
		}
		
		@SuppressWarnings("unchecked")
		@PostMapping
		public ResponseEntity <Turma> post (@RequestBody Turma turma){
			return (ResponseEntity<Turma>) ResponseEntity.status(HttpStatus.CREATED).body(repository.save(turma));
		}
		
		@SuppressWarnings("unchecked")
		@PutMapping
		public ResponseEntity <Turma> put (@RequestBody Turma turma){
			return (ResponseEntity<Turma>) ResponseEntity.status(HttpStatus.OK).body(repository.save(turma));
		}
		
		@SuppressWarnings("unchecked")
		@DeleteMapping("/{id}")
		public void delete(@PathVariable long id) {
			repository.deleteById(id);
		}
}




