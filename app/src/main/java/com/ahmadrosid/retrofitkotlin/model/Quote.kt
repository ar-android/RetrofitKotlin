package com.ahmadrosid.retrofitkotlin.model

/**
 * Created by ocittwo on 4/17/18.
 */

data class Quote(
        var items: List<Item> = listOf()
)

data class Item(
        var title: String = "",
        var author: String = "",
        var content_text: String = "",
        var url: String = ""
)
