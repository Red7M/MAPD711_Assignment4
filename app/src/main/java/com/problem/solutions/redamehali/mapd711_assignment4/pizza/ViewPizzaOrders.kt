package com.problem.solutions.redamehali.mapd711_assignment4.pizza

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.problem.solutions.redamehali.mapd711_assignment4.R
import kotlinx.android.synthetic.main.view_orders_layout.*

class ViewPizzaOrders: AppCompatActivity() {

    private lateinit var pizzaViewModel: PizzaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_orders_layout)

        val adapter = PizzaOrdersAdapter()
        val recyclerView = pizzaOrdersView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        pizzaViewModel = ViewModelProvider(this).get(PizzaViewModel::class.java)
        pizzaViewModel.readAllPizzaOrdersData.observe(this, Observer { pizza ->
            adapter.setData(pizza)
        })
    }
}
