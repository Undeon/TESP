package br.unibh.escola.negocio;

import java.util.List;

import br.unibh.escola.entidades.Aluno;
import br.unibh.escola.entidades.Disciplina;
import br.unibh.escola.entidades.Professor;
import br.unibh.escola.entidades.Sala;

public interface DAO<T, K> {

	public T insert(T t) throws Exception;
	public T update(T t) throws Exception;
	public void delete(T t) throws Exception;
	public T find(K k) throws Exception;
	public List<T> findAll() throws Exception;
	public List<T> findByName(String name) throws Exception;
	void Delete(Professor professor) throws Exception;
	void Delete(Aluno aluno) throws Exception;
	void Delete(Sala t) throws Exception;
	void Delete(Disciplina t) throws Exception;
	
}
