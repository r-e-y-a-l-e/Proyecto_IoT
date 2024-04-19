package com.reynafigueroa.arduino

import ArduinosAdapter
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.reynafigueroa.arduino.Arduinos
import com.reynafigueroa.arduino.R

class SecondFragment : Fragment(), ArduinosAdapter.OnCardClickListener {

    private var cards: List<Arduinos> = emptyList()
    private var filteredCards: List<Arduinos> = emptyList()
    private lateinit var adapter: ArduinosAdapter
    private lateinit var searchEditText: TextInputEditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        initData()
        val recyclerView = view.findViewById<RecyclerView>(R.id.list)
        adapter = ArduinosAdapter(filteredCards, this)
        val layoutManager = LinearLayoutManager(view.context)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        searchEditText = view.findViewById(R.id.searchEditText)
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val searchQuery = s.toString().trim()
                filterCards(searchQuery)
            }

            override fun afterTextChanged(s: Editable?) {}
        })

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
            Arduinos(1, getString(R.string.uno), getString(R.string.uno_description), getString(R.string.uno_charac), "https://m.media-amazon.com/images/I/71z22cRPeeL._AC_UF894,1000_QL80_.jpg"),
            Arduinos(2, getString(R.string.mega), getString(R.string.mega_description), getString(R.string.mega_charac), "https://aelectronics.com.mx/6/arduino-mega-2560-g.jpg"),
            Arduinos(3, getString(R.string.nano), getString(R.string.nano_description), getString(R.string.nano_charac), "https://m.media-amazon.com/images/I/616RyK0v6oL._AC_UF894,1000_QL80_.jpg"),
            Arduinos(4, getString(R.string.due), getString(R.string.due_description), getString(R.string.due_charc), "https://www.hwlibre.com/wp-content/uploads/2020/06/arduino-due.jpg"),
            Arduinos(5, getString(R.string.leo), getString(R.string.leo_description), getString(R.string.leo_charc), "https://electronicamade.com/wp-content/uploads/2020/02/ARDUINO-LEONARDO.jpg"),
            Arduinos(6, getString(R.string.proMini), getString(R.string.proMini_description), getString(R.string.proMini_charac), "https://alselectro.wordpress.com/wp-content/uploads/2017/05/arduinopromini000b.jpg")
        )
        filteredCards = cards
    }

    private fun filterCards(searchQuery: String) {
        filteredCards = if (searchQuery.isBlank()) {
            cards
        } else {
            cards.filter { it.model.contains(searchQuery, true) }
        }
        adapter.updateData(filteredCards)
    }
}