package com.santasgo.houseofthedragon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Detectar si se ha pulsado salir y cerrar la actividad.
        if (intent.getBooleanExtra("Exit", false)) finish()

        // Enlace al botón e incorporación de evento "click".
        val btnAnswer = findViewById<Button>(R.id.btnAnswer)
        val etName = findViewById<EditText>(R.id.etName)

        btnAnswer.setOnClickListener {
            val name = etName.text.toString()
            if (name.isBlank()) {
                // Mostrar mensaje si no se introduce el nombre.
                Toast.makeText(this, "Debe introducir un nombre.", Toast.LENGTH_SHORT).show()
            } else {
                goToElection(name)
            }
        }
    }

    private fun goToElection(name: String) {
        // Crear el intent y añadir el nombre al intent.
        val intent = Intent(this@MainActivity, ElectionActivity::class.java)
        intent.putExtra("NAME", name)
        // Iniciar la nueva actividad.
        startActivity(intent)
    }
}
