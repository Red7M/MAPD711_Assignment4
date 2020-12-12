package com.problem.solutions.redamehali.mapd711_assignment4.pizza

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.problem.solutions.redamehali.mapd711_assignment4.Constant
import com.problem.solutions.redamehali.mapd711_assignment4.R
import kotlinx.android.synthetic.main.view_orders_layout.*

class ViewCustomerPizzaOrders: AppCompatActivity() {

    private lateinit var pizzaViewModel: PizzaViewModel
    private lateinit var username: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_orders_layout)

        val adapter = PizzaOrdersAdapter(this)
        val recyclerView = pizzaOrdersView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        getUsernameAndPasswordFromSharedPref()

        pizzaViewModel = ViewModelProvider(this).get(PizzaViewModel::class.java)
        pizzaViewModel.readAllPizzaOrdersData.observe(this, Observer { pizza ->
            adapter.setData(showOnlyCustomerPizzas(pizza))
        })
    }

    private fun showOnlyCustomerPizzas(pizzas: List<Pizza>) : List<Pizza> {
        val filteredPizza = ArrayList<Pizza>()
        for (pizza in pizzas) {
            if (pizza.customer == username) {
                filteredPizza.add(pizza)
            }
        }
        return filteredPizza
    }

    private fun getUsernameAndPasswordFromSharedPref() {
        val sharedPref = getSharedPreferences("customer_key", Context.MODE_PRIVATE)?: return
        username = sharedPref.getString(Constant.SHARED_PREF_COSTUMER_USER_KEY, "").toString()
    }
}
