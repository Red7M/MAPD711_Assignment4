package com.problem.solutions.redamehali.mapd711_assignment4.admin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.problem.solutions.redamehali.mapd711_assignment4.R
import com.problem.solutions.redamehali.mapd711_assignment4.order.OrderViewModel
import com.problem.solutions.redamehali.mapd711_assignment4.pizza.PizzaViewModel
import kotlinx.android.synthetic.main.admin_home_screen_layout.*

/**
 * Created by Reda Mehali on 12/11/20.
 */
class AdminHomeScreen : AppCompatActivity() {

    private lateinit var pizzaViewModel: PizzaViewModel
    private lateinit var orderViewModel: OrderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_home_screen_layout)

        val adapter = AdminPizzaOrdersAdapter(this)
        val recyclerView = adminPizzaOrdersRecycler
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        pizzaViewModel = ViewModelProvider(this).get(PizzaViewModel::class.java)
        orderViewModel = ViewModelProvider(this).get(OrderViewModel::class.java)

        pizzaViewModel.readAllPizzaOrdersData.observe(this, { pizza ->
            adapter.setData(pizza)
        })

        orderViewModel.readAllOrders.observe(this, {orders ->
            adapter.setOrderData(orders)
        })
    }
}