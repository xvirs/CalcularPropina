package com.example.myapplication

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var calcular = findViewById<Button>(R.id.button)
        var costo = findViewById<EditText>(R.id.InputText)
        var exelente  = findViewById<RadioButton>(R.id.exelente)
        var muyBueno = findViewById<RadioButton>(R.id.muyBueno)
        var bueno = findViewById<RadioButton>(R.id.bueno)
        var resultado = findViewById<TextView>(R.id.resultado)
        var redondear = findViewById<Switch>(R.id.redondear)

        var total = 0.0

        try{
            calcular.setOnClickListener{
                if(costo.text.isEmpty()){
                    Toast.makeText(this, "Ingrese un valor", Toast.LENGTH_SHORT).show()
                    resultado.text= ""
                }else {
                    if(exelente.isChecked){
                        total = (costo.text.toString()).toDouble() * 0.20f
                    }else if(muyBueno.isChecked){
                        total = (costo.text.toString()).toDouble() * 0.18
                        resultado.text = total.toString()
                    }else if(bueno.isChecked){
                        total = (costo.text.toString()).toDouble() * 0.15
                        resultado.text = total.toString()
                    }else{
                        Toast.makeText(this, "Seleccione el estado del servicio", Toast.LENGTH_SHORT).show()
                    }

                    if(redondear.isChecked){
                        resultado.text = (Math.round(total)).toInt().toString()
                    }else{
                        resultado.text = total.toFloat().toString()
                    }
                    esconderTeclado()
                }

            }
        }catch (e: Exception){
            Toast.makeText(this,"Ah ocurrido alguin error  >  $e",Toast.LENGTH_SHORT).show()
            resultado.text= ""
        }
    }

    fun esconderTeclado(){
        val imm: InputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
    }
}