package com.fiap.fastfood.fastfood.domain.ports.input

import com.fiap.fastfood.fastfood.domain.model.Item

interface ApiItem {
    fun cadastraItem(item: Item);
    fun alteraItem(id: String, item:Item)
    fun removeItem(id: String)
    fun obterItemsPorCategoria(categoria:String)
}