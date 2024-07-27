package com.fiap.fastfood.fastfood.domain.model

class Pedidos(
    val categoria: Categoria,
    val nome :String,
    val preco: Double,
    val descricao : String,
    val imagens: List<Array<Byte>>
) {


}