package com.algaworks.algafood.domain.repository;

import java.util.List;

public interface GenericsRepository<T> {

	List<T> listar();
	T buscar(Long id);
	T salvar(T entity);
	void remover(T entity);
	
}
