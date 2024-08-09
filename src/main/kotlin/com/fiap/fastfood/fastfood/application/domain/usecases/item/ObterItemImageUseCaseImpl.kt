package com.fiap.fastfood.fastfood.application.domain.usecases.item

import com.fiap.fastfood.fastfood.application.domain.exception.BussinessLogicException
import com.fiap.fastfood.fastfood.application.domain.model.Imagem
import com.fiap.fastfood.fastfood.application.ports.service.item.ObterItemImageUseCase
import com.fiap.fastfood.fastfood.application.ports.service.item.ObterItemUseCase
import com.fiap.fastfood.fastfood.application.ports.output.file.FileStoragePort
import org.springframework.stereotype.Service

@Service
class ObterItemImageUseCaseImpl(
    val obterItemUseCase: ObterItemUseCase,
    val fileStoragePort: FileStoragePort
): ObterItemImageUseCase {
    override fun execute(id: String): Imagem {
        val item = obterItemUseCase.execute(id)
        if(item.imagem == null){
            throw BussinessLogicException("Item com id: $id não tem imagem disponível", 404)
        }
        val imageContent = fileStoragePort.get(item.id!!, item.imagem)
            ?: throw BussinessLogicException("Erro ao tentar recuperar imagem", 500)
        return Imagem( imageContent, item.imagem)
    }
}