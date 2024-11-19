package com.santasgo.houseofthedragon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

class ElectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_election)

        // Referencias a elementos gráficos
        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        val cbRhaenyra = findViewById<CheckBox>(R.id.cbRhaenyra)
        val cbAegon = findViewById<CheckBox>(R.id.cbAegon)
        val tvChoiceInfo = findViewById<TextView>(R.id.tvChoiceInfo)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        // Recuperar el nombre del Intent
        val name = intent.getStringExtra("NAME")
        tvGreeting.text = "Sir $name, es el momento de que tomes una difícil elección..."

        // Actualizar mensaje dinámico
        fun updateChoiceInfo() {
            tvChoiceInfo.text = when {
                cbRhaenyra.isChecked && cbAegon.isChecked ->
                    "Jugar a dos bandas es muy peligroso... Tu cabeza podrá rodar en cualquier momento."
                cbRhaenyra.isChecked ->
                    "Has decidido apoyar a una mujer por encima del primogénito varón... Lo pagarás con sangre."
                cbAegon.isChecked ->
                    "Has elegido a Aegon contra la voluntad del difunto rey... Arderás por tu elección... Dracarys!"
                else ->
                    "Si no tomas una decisión no podrás salir de esta encrucijada."
            }
        }

        // Listeners para los CheckBox
        cbRhaenyra.setOnCheckedChangeListener { _, _ -> updateChoiceInfo() }
        cbAegon.setOnCheckedChangeListener { _, _ -> updateChoiceInfo() }

        // Botón "Hincar la rodilla"
        btnSubmit.setOnClickListener {
            val chosen = when {
                cbRhaenyra.isChecked && cbAegon.isChecked -> "ambos"
                cbRhaenyra.isChecked -> "Rhaenyra"
                cbAegon.isChecked -> "Aegon"
                else -> null
            }

            if (chosen == null) {
                tvChoiceInfo.text = "Debes tomar una decisión."
            } else {
                val intent = Intent(this, FinalActivity::class.java)
                intent.putExtra("CHOICE", chosen)
                startActivity(intent)
            }
        }
    }
}
