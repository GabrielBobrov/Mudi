package br.com.alura.mvc.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	List<Pedido> findByNomeProduto(String nomeProduto);

	List<Pedido> findByStatusPedido(StatusPedido status);
	
	@Query("select p from Pedido p join p.user u where u.username = :username")
	List<Pedido> findAllByUsuario(@Param("username")String username);
	
	@Query("select p from Pedido p join p.user u where u.username = :username and p.statusPedido = :status")
	List<Pedido> findByStatusUsuario(@Param("status")StatusPedido status,@Param("username") String username);

}
