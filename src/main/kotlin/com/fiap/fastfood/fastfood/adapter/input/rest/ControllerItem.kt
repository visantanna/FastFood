package com.fiap.fastfood.fastfood.adapter.input.rest

import com.fiap.fastfood.fastfood.adapter.input.rest.request.ItemRequest
import com.fiap.fastfood.fastfood.application.domain.model.Item
import com.fiap.fastfood.fastfood.application.ports.input.rest.ApiItem
import com.fiap.fastfood.fastfood.application.ports.item.AlterarItemUseCase
import com.fiap.fastfood.fastfood.application.ports.item.CadastrarItemUseCase
import com.fiap.fastfood.fastfood.application.ports.item.ObterItemPorCategoriaUseCase
import com.fiap.fastfood.fastfood.application.ports.item.RemoverItemUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import javax.xml.stream.Location

@RestController
@RequestMapping("/v1/items")
class ControllerItem(
    val cadastraItemUseCase: CadastrarItemUseCase,
    val alteraItemUseCase: AlterarItemUseCase,
    val removeItemUseCase: RemoverItemUseCase,
    val obterItemPorCategoriaUseCase: ObterItemPorCategoriaUseCase
): ApiItem {
    @PostMapping()
    override fun cadastraItem(@RequestBody item: ItemRequest): ResponseEntity<Item> {
        cadastraItemUseCase.execute(item)
        return ResponseEntity.created(URI()).build()
    }

    @PutMapping("/{id}")
    override fun alteraItem(@PathVariable id: String, @RequestBody item: ItemRequest): ResponseEntity<Item> {
        return ResponseEntity.ok(alteraItemUseCase.execute(id,item))
    }

    @DeleteMapping("/id")
    override fun removeItem(@PathVariable id: String) :ResponseEntity<Item> {
        removeItemUseCase.execute(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping()
    override fun obterItemsPorCategoria(@RequestParam categoria: String): ResponseEntity<List<Item>> {
        return ResponseEntity.ok(obterItemPorCategoriaUseCase.execute(categoria))
    }

}