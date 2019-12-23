package br.com.eicon.model.query;


import javax.persistence.criteria.JoinType;

import org.springframework.data.jpa.domain.Specification;

import br.com.eicon.model.Pedido;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.JoinFetch;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Joins;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@Joins(fetch = {
        @JoinFetch(paths = "cliente", joinType = JoinType.LEFT),
        @JoinFetch(paths = "listaPedidoItens", joinType = JoinType.LEFT)
    })
@And({
    @Spec(path = "id", spec = Equal.class),
    @Spec(path = "dataDoPedido", spec = Equal.class),
    @Spec(path = "valorTotalDoPedido", spec = Equal.class),
    
    @Spec(path="cliente.nomeCliente", params="nomeCliente", spec=Like.class)
})
public interface CustomSpecificationPedido extends Specification<Pedido> {

}
