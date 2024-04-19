import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.reynafigueroa.arduino.Arduinos
import com.reynafigueroa.arduino.R
import com.squareup.picasso.Picasso

class ArduinosAdapter(private var cards: List<Arduinos>, private val listener: OnCardClickListener) : RecyclerView.Adapter<ArduinosAdapter.ArduinosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArduinosViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_arduinos, parent, false)
        return ArduinosViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ArduinosViewHolder, position: Int) {
        val card = cards[position]
        holder.bind(card)
        holder.itemView.setOnClickListener {
            listener.onCardClick(card)
        }
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    inner class ArduinosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.model)
        private val imageView: ImageView = itemView.findViewById(R.id.image)

        fun bind(card: Arduinos) {
            titleTextView.text = card.model
            Picasso.get().load(card.image).into(imageView)
        }
    }

    interface OnCardClickListener {
        fun onCardClick(card: Arduinos)
    }
    fun updateData(newCards: List<Arduinos>) {
        cards = newCards
        notifyDataSetChanged()
    }
}