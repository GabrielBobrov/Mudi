package br.com.alura.mvc.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.mvc.mudi.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	List<Pedido> findByNomeProduto(String nomeProduto);

}
