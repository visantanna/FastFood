package com.fiap.fastfood.fastfood.adapter.input.rest.helper

import com.fiap.fastfood.fastfood.adapter.input.rest.request.ClienteRequest
import com.fiap.fastfood.fastfood.adapter.input.rest.request.ItemRequest
import com.fiap.fastfood.fastfood.adapter.input.rest.response.ClienteResponse
import com.fiap.fastfood.fastfood.adapter.input.rest.response.PedidoResponse
import com.fiap.fastfood.fastfood.adapter.output.repository.toResponse
import com.fiap.fastfood.fastfood.application.domain.model.*
import org.springframework.web.multipart.MultipartFile
import java.awt.Image


fun ItemRequest.toDomain(): Item {
    return Item(
        id = null,
        nome = this.nome,
        preco = this.preco,
        descricao = this.descricao,
        imagem= this.imagem.toImageMetada(),
        categoria = Categoria.valueOf(this.categoria),
    )
}
fun MultipartFile.toImageMetada(): ImagemMetadata? {
    if(this.isEmpty){
        return null
    }
    return with(this) {
        ImagemMetadata(
            nomeArquivo = originalFilename!!,
            extensao = contentType!!
        )
    }
}

fun Pedido.toResponse(): PedidoResponse =
    with(this){
        PedidoResponse(
            id = id!!,
            cliente = cliente,
            lanche = lanche?.toResponse(),
            acompanhamento = acompanhamento?.toResponse(),
            bebida = bebida?.toResponse(),
            sobremesa = sobremesa?.toResponse(),
            status =  status.name
        )
    }

fun Cliente.toResponse(): ClienteResponse =
    with(this){
        return ClienteResponse(
            id = id!!,
            cpf=cpf,
            nome=nome,
            email=email
        )
    }
fun ClienteRequest.toDomain(): Cliente =
    with(this){
        return Cliente(
            id = null,
            cpf = cpf,
            nome = nome,
            email = email
        )
    }