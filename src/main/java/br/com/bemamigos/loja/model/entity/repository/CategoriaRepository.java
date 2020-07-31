package br.com.bemamigos.loja.model.entity.repository;

import br.com.bemamigos.loja.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
