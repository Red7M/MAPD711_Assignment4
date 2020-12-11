package com.problem.solutions.redamehali.mapd711_assignment4.customer

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.problem.solutions.redamehali.mapd711_assignment4.pizza.Pizza
import com.problem.solutions.redamehali.mapd711_assignment4.pizza.PizzaViewModel
import com.problem.solutions.redamehali.mapd711_assignment4.R
import kotlinx.android.synthetic.main.customer_place_order_layout.*

class CustomerPlaceOrder: AppCompatActivity() {

    private lateinit var pizzaOrderViewModel: PizzaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customer_place_order_layout)

        pizzaOrderViewModel = ViewModelProvider(this).get(PizzaViewModel::class.java)

        orderButton.setOnClickListener {
            insertPizzaIntoDB()
        }
    }

    private fun insertPizzaIntoDB() {
        if (pizzaText.text.isBlank() ||
            customerName.text.isBlank() ||
            pizzaQuantity.text.isBlank()) {
            Toast.makeText(
                this,
                "Please fill out all fields",
                Toast.LENGTH_LONG).show()
            return
        }

        val pizzaName = pizzaText.text.toString()
        val customer = customerName.text.toString()
        val quantity = pizzaQuantity.text.toString()

        val pizza = Pizza(0, pizzaName, customer, quantity)
        pizzaOrderViewModel.addPizza(pizza)
        Toast.makeText(
            this,
            "Successfully added!",
            Toast.LENGTH_LONG).show()
    }
}
