import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reynafigueroa.arduino.Arduinos
import com.reynafigueroa.arduino.R

class SecondFragment : Fragment(), ArduinosAdapter.OnCardClickListener {

    private var cards: List<Arduinos> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        initData()
        val recyclerView = view.findViewById<RecyclerView>(R.id.list)
        val adapter = ArduinosAdapter(cards, this)
        val layoutManager = LinearLayoutManager(view.context)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        return view
    }

    override fun onCardClick(card: Arduinos) {
        val navController = findNavController()
        val bundle = Bundle().apply {
            putParcelable("arduinoData", card)
        }
        navController.navigate(R.id.action_secondFragment_to_seventhFragment, bundle)
    }

    private fun initData() {
        cards = listOf(
            Arduinos(1, "Arduinos", "Tarjeta electrónica programable que permite la creación rápida de prototipos", "https://i.blogs.es/ad563d/arduino/450_1000.jpg"),
            Arduinos(2, "Componentes Basicos", "Tarjeta electrónica programable que permite la creación rápida de prototipos", "https://i.blogs.es/ad563d/arduino/450_1000.jpg"),
            Arduinos(3, "Componentes Avanzados", "Tarjeta electrónica programable que permite la creación rápida de prototipos", "https://i.blogs.es/ad563d/arduino/450_1000.jpg"),
            Arduinos(4, "Resistencias", "Tarjeta electrónica programable que permite la creación rápida de prototipos", "https://i.blogs.es/ad563d/arduino/450_1000.jpg"),
            Arduinos(5, "Cables", "Tarjeta electrónica programable que permite la creación rápida de prototipos", "https://i.blogs.es/ad563d/arduino/450_1000.jpg")
        )
    }
}