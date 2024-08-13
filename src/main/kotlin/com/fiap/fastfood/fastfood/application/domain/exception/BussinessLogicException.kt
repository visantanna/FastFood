package com.fiap.fastfood.fastfood.application.domain.exception

class BussinessLogicException( val mensagem: String, val status: Int ): Exception(mensagem) {

}