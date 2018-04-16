package com.ahmadrosid.retrofitkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ahmadrosid.retrofitkotlin.R
import com.ahmadrosid.retrofitkotlin.model.Item

/**
 * Created by ocittwo on 4/17/18.
 */
class QuoteAdapter : RecyclerView.Adapter<QuoteHolder>() {

    private var data = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): QuoteHolder {
        return QuoteHolder(
                LayoutInflater.from(parent?.context)
                        .inflate(R.layout.item_quote, parent, false)
        )
    }

    override fun onBindViewHolder(holder: QuoteHolder?, position: Int) {
        holder?.bindData(data[position])
    }

    override fun getItemCount(): Int = data.size

    fun addData(quotes: List<Item>?) {
        if (quotes != null)
            data.addAll(quotes)
        notifyDataSetChanged()
    }
}