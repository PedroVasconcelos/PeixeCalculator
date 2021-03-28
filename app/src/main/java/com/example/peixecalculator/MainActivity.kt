package com.example.peixecalculator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

 abstract class MainActivity : AppCompatActivity(), View.OnClickListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btCalcular: Button = calcular
        val valorFinal: TextView = valorFinal

        btCalcular.setOnClickListener {

            val algasFornecidas = Integer.parseInt(algas.text.toString())
            val peixesPicados = Integer.parseInt(peixes.text.toString())

            val quantiDeAlgasT1 = (algasFornecidas / 1)
            val quantiDeAlgasT2 = (algasFornecidas / 3)
            val quantiDeAlgasT3 = (algasFornecidas / 9)

            val quantiDePeiPicT1 = peixesPicados - (quantiDeAlgasT1 * 15)
            val quantiDePeiPicT2 = peixesPicados - (quantiDeAlgasT1 * 45)
            val quantiDePeiPicT3 = peixesPicados - (quantiDeAlgasT1 * 125)

            val diviPeiPicT1 = (peixesPicados / 15)
            val diviPeiPicT2 = (peixesPicados / 45)
            val diviPeiPicT3 = (peixesPicados / 125)

            val diviAlgasT1 = (quantiDeAlgasT1 - diviPeiPicT1)
            val diviAlgasT2 = (quantiDeAlgasT2 - diviPeiPicT2)
            val diviAlgasT3 = (quantiDeAlgasT3 - diviPeiPicT3)

            fun onRadioButtonClicked (view:View){
                if (view is RadioButton){
                    val checked = view.isChecked
                    when (view.getId()) {
                                R.id.radioButton1 ->
                            if (checked) {
                                if (diviPeiPicT1 < quantiDeAlgasT1) {
                                    valorFinal.setText("""     
                 A Quantidade de molhosT1 será de: $diviPeiPicT1 
                 Sobrando 0 de Peixes Picados.
                 Sobrando $diviAlgasT1 de Algas para os molhos t1.
                                   """)
                                }
                                else{
                                    valorFinal.setText("""
          A Quantidade de molhosT1 será de: $quantiDeAlgasT1 
          Sobrando $quantiDePeiPicT1 de Peixes Picados.
                               """)
                                }
                            }
                                R.id.radioButton2 ->
                                if (checked) {
                                    if (diviPeiPicT2 < quantiDeAlgasT2 ){
                                        valorFinal.setText("""     
                 A Quantidade de molhosT2 será de: $diviPeiPicT2 
                 Sobrando 0 de Peixes Picados.
                 Sobrando $diviAlgasT2 de Algas para os molhos t2.
                                   """)
                                    }
                                    else{
                                        valorFinal.setText("""
          A Quantidade de molhosT2 será de: $quantiDeAlgasT2 
          Sobrando $quantiDePeiPicT2 de Peixes Picados.
                               """)
                                    }
                                }

                                R.id.radioButton3 ->
                                if (checked){
                                    if (diviPeiPicT3 < quantiDeAlgasT3 ){
                                        valorFinal.setText("""     
                 A Quantidade de molhosT3 será de: $diviPeiPicT3 
                 Sobrando 0 de Peixes Picados.
                 Sobrando $diviAlgasT3 de Algas para os molhos t3.
                                   """)
                                    }
                                    else {
                                        valorFinal.setText("""
          A Quantidade de molhosT3 será de: $quantiDeAlgasT3 
          Sobrando $quantiDePeiPicT3 de Peixes Picados.
                               """)
                                    }
                                }
                         }
                    }
                }
            }
        }
    }



