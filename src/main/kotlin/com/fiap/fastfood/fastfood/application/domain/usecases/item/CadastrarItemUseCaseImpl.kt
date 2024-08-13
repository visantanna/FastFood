package com.fiap.fastfood.fastfood.application.domain.usecases.item

import com.fiap.fastfood.fastfood.adapter.input.rest.helper.toDomain
import com.fiap.fastfood.fastfood.adapter.input.rest.request.ItemRequest
import com.fiap.fastfood.fastfood.application.domain.model.Item
import com.fiap.fastfood.fastfood.application.domain.validation.ItemValidador
import com.fiap.fastfood.fastfood.application.ports.service.item.CadastrarItemUseCase
import com.fiap.fastfood.fastfood.application.ports.output.file.FileStoragePort
import com.fiap.fastfood.fastfood.application.ports.output.repository.ItemPortRepository
import org.springframework.stereotype.Service

@Service
class CadastrarItemUseCaseImpl(
    val itemValidador: ItemValidador,
    val itemRepository: ItemPortRepository,
    val fileStorage : FileStoragePort
): CadastrarItemUseCase {
    override fun execute(item: ItemRequest): Item {
        itemValidador.validate(item);

        val itemDomain:Item = item.toDomain()
        val savedItem = itemRepository.save(itemDomain)
        if (savedItem.imagem != null && savedItem.id != null){
            fileStorage.save(item.imagem.inputStream, savedItem.id, savedItem.imagem)
        }
        return savedItem
    }

}
