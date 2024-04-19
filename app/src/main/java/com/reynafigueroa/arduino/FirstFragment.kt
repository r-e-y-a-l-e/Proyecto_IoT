package com.reynafigueroa.arduino

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FirstFragment : Fragment(), CardsAdapter.OnCardClickListener {
    private var cardList: List<Card> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        initData()

        val recyclerView = view.findViewById<RecyclerView>(R.id.listRecycler)
        val adapter = CardsAdapter(cardList, this)
        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return view
    }
    override fun onCardClick(card: Card) {
        if (card.id == 1) {
            val navController = findNavController()
            navController.navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }

    private fun initData() {
        cardList = listOf(
            Card(1, getString(R.string.arduinos), "https://publys.cl/wp-content/uploads/2019/06/515b4656ce395f8a38000000.png"),
            Card(2, getString(R.string.basic_components), "https://cdn1.coppel.com/images/catalog/mkp/3691/3000/36911065-1.jpg"),
            Card(3, getString(R.string.advanced_components), "https://m.media-amazon.com/images/I/81JSQLUMNiL._AC_UF894,1000_QL80_.jpg"),
            Card(4, getString(R.string.resistors), "https://autosoporte.com/wp-content/uploads/2021/05/Resistencias-electricas.jpg"),
            Card(5, getString(R.string.cables), "https://www.researchgate.net/profile/Gopi-Manoj-Vuyyuru-2/publication/351917963/figure/fig4/AS:1028128814166018@1622136419283/Arduino-Uno-USB-Cable-F-Jumper-Wires-Jumper-wires-are-simple-cables-having-connector.jpg")
        )
    }
}