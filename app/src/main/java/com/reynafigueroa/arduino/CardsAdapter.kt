package com.reynafigueroa.arduino

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CardsAdapter(private val cards: List<Card>, private val clickListener: OnCardClickListener) : RecyclerView.Adapter<CardsAdapter.CardsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_cards, parent, false)
        return CardsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        val card = cards[position]
        holder.bind(card)
        holder.itemView.setOnClickListener {
            clickListener.onCardClick(card)
        }
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    inner class CardsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.title)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.description)
        private val imageView: ImageView = itemView.findViewById(R.id.image)

        fun bind(card: Card) {
            titleTextView.text = card.title
            descriptionTextView.text = card.description
            Picasso.get().load(card.imageUrl).into(imageView)
        }
    }
    interface OnCardClickListener {
        fun onCardClick(card: Card)
    }
}