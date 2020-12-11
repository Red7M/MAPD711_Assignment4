package com.problem.solutions.redamehali.mapd711_assignment4.customer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.problem.solutions.redamehali.mapd711_assignment4.R
import com.problem.solutions.redamehali.mapd711_assignment4.pizza.ViewPizzaOrders

/**
 * Created by Reda Mehali on 12/3/20.
 */
class CustomerScreen: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customer_screen_layout)

        setClickListeners()
    }

    private fun setClickListeners() {
        val editInformationButton = findViewById<Button>(R.id.editPersonalInfoButton)
        editInformationButton.setOnClickListener {
            val intent = Intent(this, CustomerInformation::class.java)
            startActivity(intent)
        }

        val viewOrdersButton = findViewById<Button>(R.id.viewOrdersButton)
        viewOrdersButton.setOnClickListener {
            val intent = Intent(this, ViewPizzaOrders::class.java)
            startActivity(intent)
        }

        val placeOrderButton = findViewById<Button>(R.id.placeOrderButton)
        placeOrderButton.setOnClickListener {
            val intent = Intent(this, CustomerPlaceOrder::class.java)
            startActivity(intent)
        }
    }


}