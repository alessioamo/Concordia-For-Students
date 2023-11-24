package com.example.concordiaforstudents.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.concordiaforstudents.R

class CustomArrayAdapter(
    context: Context,
    resource: Int,
    private val objects: Array<String>,
    private val icons: Array<Int>
) : ArrayAdapter<String>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rowView = inflater.inflate(R.layout.list_item, parent, false)

        val iconImageView = rowView.findViewById<ImageView>(R.id.icon)
        iconImageView.setImageResource(icons[position])

        val textView = rowView.findViewById<TextView>(R.id.list_me_text)
        textView.text = getItem(position)

        return rowView
    }
}