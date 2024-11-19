package com.santasgo.houseofthedragon

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        // Recuperar la elección del Intent
        val choice = intent.getStringExtra("CHOICE")
        val tvFinalMessage = findViewById<TextView>(R.id.tvFinalMessage)
        val btnExit = findViewById<Button>(R.id.btnExit)

        // Mostrar mensaje final
        tvFinalMessage.text = when (choice) {
            "Rhaenyra" -> "Has elegido a Rhaenyra."
            "Aegon" -> "Has elegido a Aegon."
            "ambos" -> "Has intentado jugar a ambos lados."
            else -> "No has tomado una decisión."
        }

        // Botón para salir de la aplicación
        btnExit.setOnClickListener {
            finishAffinity() // Cierra todas las actividades y termina la aplicación
        }
    }
}
