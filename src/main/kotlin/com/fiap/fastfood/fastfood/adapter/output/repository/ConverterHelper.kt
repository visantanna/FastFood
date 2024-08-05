package com.fiap.fastfood.fastfood.adapter.output.repository

import com.fiap.fastfood.fastfood.adapter.output.repository.entities.ClienteEntity
import com.fiap.fastfood.fastfood.adapter.output.repository.entities.ItemEntity
import com.fiap.fastfood.fastfood.application.domain.model.Categoria
import com.fiap.fastfood.fastfood.application.domain.model.Cliente
import com.fiap.fastfood.fastfood.application.domain.model.Item


fun Cliente.toEntity(): ClienteEntity =
    with(this){
        return ClienteEntity(
            cpf= this.cpf,
            nome= this.nome,
            email=this.email
        )
    }

fun ClienteEntity.toDomain(): Cliente =
    with(this){
        return Cliente(
            cpf= this.cpf,
            nome= this.nome,
            email=this.email
        )
    }

fun Item.toEntity():ItemEntity =
    with(this){
        return ItemEntity(
            nome = this.nome,
            preco = this.preco,
            descricao = this.descricao,
            imagens = this.imagens,
            categoria = this.categoria.name
        )
    }

fun ItemEntity.toDomain(): Item =
    with(this){
        return Item(
            nome = this.nome,
            preco = this.preco,
            descricao = this.descricao,
            imagens = this.imagens,
            categoria = Categoria.valueOf(this.categoria)
        )
    }