package com.fiap.fastfood.fastfood.adapter.output.repository

import com.fiap.fastfood.fastfood.adapter.input.rest.response.ItemResponse
import com.fiap.fastfood.fastfood.adapter.output.repository.entities.ClienteEntity
import com.fiap.fastfood.fastfood.adapter.output.repository.entities.ItemEntity
import com.fiap.fastfood.fastfood.adapter.output.repository.entities.PedidoEntity
import com.fiap.fastfood.fastfood.application.domain.model.Categoria
import com.fiap.fastfood.fastfood.application.domain.model.Cliente
import com.fiap.fastfood.fastfood.application.domain.model.Item
import com.fiap.fastfood.fastfood.application.domain.model.Pedido


fun Cliente.toEntity(): ClienteEntity =
    with(this){
        return ClienteEntity(
            id = id ,
            cpf= this.cpf,
            nome= this.nome,
            email=this.email
        )
    }

fun ClienteEntity.toDomain(): Cliente =
    with(this){
        return Cliente(
            id = id,
            cpf= this.cpf,
            nome= this.nome,
            email=this.email
        )
    }

fun Item.toEntity():ItemEntity =
    with(this){
        return ItemEntity(
            id = id,
            nome = nome,
            preco = preco,
            descricao = descricao,
            imagem = imagem,
            categoria = categoria.name
        )
    }

fun ItemEntity.toDomain(): Item =
    with(this){
        return Item(
            id = id,
            nome = this.nome,
            preco = this.preco,
            descricao = this.descricao,
            imagem = this.imagem,
            categoria = Categoria.valueOf(this.categoria)
        )
    }

fun Item.toResponse():ItemResponse =
    with(this){
        return ItemResponse(
            id = id!!,
            nome = nome,
            preco = preco,
            descricao = descricao,
            categoria = categoria.name
        )
    }

fun Pedido.toEntity():PedidoEntity =
    with(this){
        return PedidoEntity(
            id = id,
            cliente = cliente.toEntity(),
            lanche = lanche?.toEntity(),
            acompanhamento = acompanhamento?.toEntity(),
            bebida = bebida?.toEntity(),
            sobremesa = sobremesa?.toEntity()
        )
    }

fun PedidoEntity.toDomain(): Pedido =
    with(this){
        return Pedido(
            id = id,
            cliente = cliente.toDomain(),
            lanche = lanche?.toDomain(),
            acompanhamento = acompanhamento?.toDomain(),
            bebida = bebida?.toDomain(),
            sobremesa = sobremesa?.toDomain()
        )
    }

