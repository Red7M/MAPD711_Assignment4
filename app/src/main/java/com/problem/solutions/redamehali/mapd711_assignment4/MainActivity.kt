package com.problem.solutions.redamehali.mapd711_assignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var customerInputEditText : TextInputEditText
    lateinit var pizzaAdminsEditText : TextInputEditText
    lateinit var loginButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customerInputEditText = findViewById(R.id.customerInputEditText)
        pizzaAdminsEditText = findViewById(R.id.pizzaAdminsEditText)
        loginButton = findViewById(R.id.loginButton)

        setListenersForInputTexts()
    }

    private fun setListenersForInputTexts() {
        customerInputEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                enableButtonOnOnlyOneLoginBoxFilled()
            }
        })

        pizzaAdminsEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                enableButtonOnOnlyOneLoginBoxFilled()
            }
        })
    }

    private fun enableButtonOnOnlyOneLoginBoxFilled() {
        loginButton.isEnabled = !customerInputEditText.text!!.isBlank()
            .xor(!pizzaAdminsEditText.text!!.isBlank())
    }
}