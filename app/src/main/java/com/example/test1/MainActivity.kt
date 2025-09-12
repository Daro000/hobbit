package com.example.test1

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spinner : Spinner = findViewById<Spinner>(R.id.MySpinner)

        val postacie : ImageView = findViewById<ImageView>(R.id.Postacie)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent:AdapterView<*>, view: View?, position: Int, id:Long) {
                when(position){
                    1 -> postacie.setImageResource(R.drawable.pierscien)
                    2 -> postacie.setImageResource(R.drawable.miecz)
                    3 -> postacie.setImageResource(R.drawable.luk)
                    4 -> postacie.setImageResource(R.drawable.topor)
                    5 -> postacie.setImageResource(R.drawable.rozdzka)
                    else -> postacie.setImageResource(R.drawable.frodo)

                }

            }

            override fun onNothingSelected(parent: AdapterView<*>) {}

        }


        val items = listOf("wybierz postac","hobbit", "człowiek", "elf", "krasnolud", "czarodziej")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            items

        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter


        val summaryButton : Button = findViewById<Button>(R.id.summaryButton)

        val summaryTextView : TextView = findViewById<TextView>(R.id.podsumowanie_textview)

        summaryButton.setOnClickListener {
            val name : EditText = findViewById<EditText>(R.id.editText)

            val race = spinner.selectedItem.toString()

            val radioGroup : RadioGroup = findViewById<RadioGroup>(R.id.sposob_chodu_radio)

            val selectedRadio = findViewById<RadioGroup>(radioGroup.checkedRadioButtonId)

            //val priotytet = selectedRadio. ?: ""

            val eq1 : CheckBox = findViewById<CheckBox>(R.id.checkbox1)
            val eq2 : CheckBox = findViewById<CheckBox>(R.id.checkbox2)
            val eq3 : CheckBox = findViewById<CheckBox>(R.id.checkbox3)
            val eq4 : CheckBox = findViewById<CheckBox>(R.id.checkbox4)

            val eqlist = listOf(eq1,eq2,eq3,eq4). filter { it.isChecked } . map { it.text }
            val fulleq = eqlist.joinToString(", ")

            val ratingbar = findViewById<RatingBar>(R.id.ocena_podrozy_rating)


        }



    }



}