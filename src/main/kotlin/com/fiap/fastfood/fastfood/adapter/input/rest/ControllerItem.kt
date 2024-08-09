package com.fiap.fastfood.fastfood.adapter.input.rest

import com.fiap.fastfood.fastfood.adapter.input.rest.request.ItemRequest
import com.fiap.fastfood.fastfood.adapter.input.rest.response.ItemResponse
import com.fiap.fastfood.fastfood.adapter.output.repository.toResponse
import com.fiap.fastfood.fastfood.application.domain.model.Item
import com.fiap.fastfood.fastfood.application.ports.input.rest.ApiItem
import com.fiap.fastfood.fastfood.application.ports.service.item.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/v1/items")
class ControllerItem(
    val cadastraItemUseCase: CadastrarItemUseCase,
    val alteraItemUseCase: AlterarItemUseCase,
    val removeItemUseCase: RemoverItemUseCase,
    val obterItemPorCategoriaUseCase: ObterItemPorCategoriaUseCase,
    val obterItemUsecase: ObterItemUseCase,
    val obterItemImagemUseCase: ObterItemImageUseCase
): ApiItem {
    @PostMapping(consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    override fun cadastraItem(@ModelAttribute item: ItemRequest): ResponseEntity<Item> {
        val itemSaved = cadastraItemUseCase.execute(item)
        val getUri =ServletUriComponentsBuilder.fromCurrentRequestUri().build("/"+itemSaved.id)
        return ResponseEntity.created(getUri).build()
    }

    @PutMapping("/{id}", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    override fun alteraItem(@PathVariable id: String, @ModelAttribute item: ItemRequest): ResponseEntity<Item> {
        return ResponseEntity.ok(alteraItemUseCase.execute(id,item))
    }

    @DeleteMapping("/{id}")
    override fun removeItem(@PathVariable id: String) :ResponseEntity<Item> {
        removeItemUseCase.execute(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping()
    override fun obterItemsPorCategoria(@RequestParam categoria: String): ResponseEntity<List<ItemResponse>> {
        return ResponseEntity.ok(obterItemPorCategoriaUseCase.execute(categoria).map { it.toResponse() })
    }
    @GetMapping("/{id}")
    override fun obterItemById(@PathVariable id: String): ResponseEntity<ItemResponse>{
        return ResponseEntity.ok(obterItemUsecase.execute(id).toResponse())
    }
    @GetMapping("/{id}/imagem")
    override fun obterItemImageById(@PathVariable id: String):ResponseEntity<ByteArray>{
        val imagem = obterItemImagemUseCase.execute(id)

        val headers = HttpHeaders()
        headers.add("Content-Type", imagem.imagemMetadata.extensao)
        headers.add("Content-Size", imagem.content.size.toString())
        val response = ResponseEntity(imagem.content,headers, HttpStatus.OK)
        return  response
    }

}