package com.fiap.fastfood.fastfood.application.domain.validation

import com.fiap.fastfood.fastfood.adapter.input.rest.request.PedidoRequest
import com.fiap.fastfood.fastfood.application.domain.exception.BussinessLogicException
import com.fiap.fastfood.fastfood.application.domain.model.Categoria
import com.fiap.fastfood.fastfood.application.domain.model.Pedido
import com.fiap.fastfood.fastfood.application.domain.model.PedidoStatus
import com.fiap.fastfood.fastfood.application.ports.output.repository.ClientePortRepository
import com.fiap.fastfood.fastfood.application.ports.output.repository.ItemPortRepository
import org.springframework.stereotype.Service

@Service
class PedidoValidador(
    val itemPort: ItemPortRepository,
    val userPort: ClientePortRepository
) {
    fun validatePedido(pedido: PedidoRequest){
        validarCliente(pedido.clienteId)
        pedido.lanche?.let{validarItem(it, Categoria.LANCHE)}
        pedido.acompanhamento?.let{validarItem(it, Categoria.ACOMPANHAMENTO)}
        pedido.bebida?.let{validarItem(pedido.bebida, Categoria.BEBIDA)}
        pedido.sobremesa?.let{validarItem(pedido.sobremesa, Categoria.SOBREMESA)}
        peloMenosUmPedido(pedido)
    }

    private fun peloMenosUmPedido(pedido: PedidoRequest) {
        if(
            pedido.lanche == null &&
            pedido.acompanhamento == null &&
            pedido.bebida == null &&
            pedido.sobremesa == null
            ){
            throw BussinessLogicException("Pedido deve ter pelo menos um item!", 400)
        }

    }

    private fun validarCliente(clienteId: String) {
        if(!userPort.exist(clienteId))
            throw BussinessLogicException("Não existe cliente enviado no pedido. Id do cliente: $clienteId", 400)
    }

    fun validarItem(itemId: String, categoria: Categoria){
        if(!itemPort.exists(itemId))
            itemNotValid(categoria, itemId)
        val item = itemPort.getById(itemId)
        if(item.categoria != categoria)
            itemNotValid(categoria, itemId)
    }

    private fun itemNotValid(categoria: Categoria, itemId: String) {
        throw BussinessLogicException(
            "Não existe Item da categoria: ${categoria.value} com o id: ${itemId} cadastrado",
            400
        )
    }

}