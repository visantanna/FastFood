package com.fiap.fastfood.fastfood.adapter.input.rest.helper

import com.fiap.fastfood.fastfood.adapter.input.rest.request.ItemRequest
import com.fiap.fastfood.fastfood.application.domain.model.Categoria
import com.fiap.fastfood.fastfood.application.domain.model.Item


fun ItemRequest.toDomain(): Item {
    return Item(
        nome = this.nome,
        preco = this.preco,
        descricao = this.descricao,
        imagens = this.imagens,
        categoria = Categoria.valueOf(this.categoria),

    )
}
