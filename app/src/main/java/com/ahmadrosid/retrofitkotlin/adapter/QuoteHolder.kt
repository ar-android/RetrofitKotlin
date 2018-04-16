package com.ahmadrosid.retrofitkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.ahmadrosid.retrofitkotlin.R
import com.ahmadrosid.retrofitkotlin.model.Item

/**
 * Created by ocittwo on 4/17/18.
 */
class QuoteHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val title = view.findViewById<TextView>(R.id.title)
    private val author = view.findViewById<TextView>(R.id.author)
    private val content = view.findViewById<TextView>(R.id.content)

    fun bindData(item: Item) {
        title.text = item.title
        author.text = "-- ${item.author} --"
        content.text = item.content_text
    }
}