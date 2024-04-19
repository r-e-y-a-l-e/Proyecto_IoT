package com.castelo.componentesavanzados

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val componentes = mutableListOf(
            "SW-520D sensor de inclinación", "KY-015 módulo sensor de humedad",
            "HC-SR04 sensor ultrasónico de distancia", "HC-SR501 sensor PIR de movimiento", "MPU6050 acelerómetro y giroscopio",
            "Sensor de humedad de suelo FC-28", "KY-037 módulo sensor de sonido", "MQ2 sensor de gas"
        )

        val listView = findViewById<ListView>(R.id.listacomponentes)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, componentes)
        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val componenteSeleccionado = componentes[position]
            // Aquí cambiamos de vista según el componente seleccionado
            when (componenteSeleccionado) {
                "SW-520D sensor de inclinación" -> startActivity(Intent(this, InclinacionActivity::class.java))
                "KY-015 módulo sensor de humedad" -> startActivity(Intent(this, HumedadActivity::class.java))
                "HC-SR04 sensor ultrasónico de distancia" -> startActivity(Intent(this, DistanciaActivity::class.java))
                "HC-SR501 sensor PIR de movimiento" -> startActivity(Intent(this, MovimientoActivity::class.java))
                "MPU6050 acelerómetro y giroscopio" -> startActivity(Intent(this, AcelerometroActivity::class.java))
                "Sensor de humedad de suelo FC-28" -> startActivity(Intent(this, SueloActivity::class.java))
                "KY-037 módulo sensor de sonido" -> startActivity(Intent(this, Sonido037Activity::class.java))
                "MQ2 sensor de gas" -> startActivity(Intent(this, GasActivity::class.java))
                else -> Toast.makeText(this, "Vista no definida para $componenteSeleccionado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
