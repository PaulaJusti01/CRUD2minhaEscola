package org.generation.minhaEscola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.minhaEscola.turma.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	public List<Aluno> findAllByDescricaoContainingIgnoreCase(String nome);
}
