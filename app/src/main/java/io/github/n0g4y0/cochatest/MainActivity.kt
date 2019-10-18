package io.github.n0g4y0.cochatest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var botonVerdad : Button
    private lateinit var botonFalso : Button
    private lateinit var botonSiguiente : Button
    private lateinit var botonAnterior : Button
    private lateinit var texto : TextView

    private var indiceActual = 0

    private val bancoPreguntas = listOf(
        Pregunta(R.string.question_1, false),
        Pregunta(R.string.question_2,false),
        Pregunta(R.string.question_3,true),
        Pregunta(R.string.question_4,false),
        Pregunta(R.string.question_5,true),
        Pregunta(R.string.question_6,false),
        Pregunta(R.string.question_7,true),
        Pregunta(R.string.question_8,false)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonVerdad = findViewById<Button>(R.id.verdad_button)
        botonFalso = findViewById<Button>(R.id.falso_button)
        botonSiguiente = findViewById(R.id.botonSiguiente)
        botonAnterior = findViewById(R.id.botonAnterior)
        texto = findViewById(R.id.textoPregunta)

        botonVerdad.setOnClickListener { view: View ->
            verificarRespuesta(true)
        }

        botonFalso.setOnClickListener { view: View ->
            verificarRespuesta(false)
        }

        botonSiguiente.setOnClickListener {view: View ->
            if (indiceActual==7){
                indiceActual = 0
            }else{
                indiceActual = indiceActual + 1
            }
            actualizarPregunta()
        }

        botonAnterior.setOnClickListener {view: View ->
            if (indiceActual==0){
                indiceActual = 7
            }else{
                indiceActual = indiceActual - 1
            }
            actualizarPregunta()
        }
    }

    private fun actualizarPregunta(){

        val textoPreguntaID = bancoPreguntas[indiceActual].idTexto
        texto.setText(textoPreguntaID)

    }

    private fun verificarRespuesta(respuestaUsuario: Boolean){

        val respuestaCorrecta = bancoPreguntas[indiceActual].respuesta
        val mostrarMensajeID =  if (respuestaUsuario == respuestaCorrecta){
            "Correcto"
        } else {
            "Incorrecto"
        }
        Toast.makeText(this,mostrarMensajeID,Toast.LENGTH_SHORT).show()

    }
}
