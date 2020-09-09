package org.generation.minhaEscola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository<Turma> extends JpaRepository<Turma, Long> {
	public List<Turma> findAllByTituloContainingIgnoreCase(String turma);

}
