package com.reynafigueroa.arduino

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


class SeventhFragment : Fragment() {

    private lateinit var arduinoData: Arduinos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            arduinoData = it.getParcelable("arduinoData")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_seventh, container, false)

        // Utiliza los datos de arduinoData para configurar la vista
        view.findViewById<TextView>(R.id.textViewTitle).text = arduinoData.model
        view.findViewById<TextView>(R.id.textViewDescription).text = arduinoData.description
        Picasso.get().load(arduinoData.image).into(view.findViewById<ImageView>(R.id.imageView))

        return view
    }
}