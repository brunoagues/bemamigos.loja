package br.com.bemamigos.loja.model.entity.repository;

import br.com.bemamigos.loja.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
