package io.github.n0g4y0.cochatest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var botonVerdad: Button
    private lateinit var botonFalso: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonVerdad = findViewById<Button>(R.id.verdad_button)
        botonFalso = findViewById<Button>(R.id.falso_button)

        botonVerdad.setOnClickListener { view: View ->
            val muestraMensaje = Toast.makeText(this, R.string.correcto_toast, Toast.LENGTH_SHORT)
            muestraMensaje.setGravity(Gravity.TOP, 0, 130)
            muestraMensaje.show()
        }

        botonFalso.setOnClickListener { view: View ->

            val muestraMensaje = Toast.makeText(this, R.string.incorrecto_toast, Toast.LENGTH_SHORT)
            muestraMensaje.setGravity(Gravity.TOP, 0, 130)
            muestraMensaje.show()
        }
    }
}
