package com.problem.solutions.redamehali.mapd711_assignment4.admin

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.problem.solutions.redamehali.mapd711_assignment4.R
import com.problem.solutions.redamehali.mapd711_assignment4.order.Order
import com.problem.solutions.redamehali.mapd711_assignment4.pizza.PizzaOrdersAdapter
import kotlinx.android.synthetic.main.admin_pizza_orders_row.view.*

/**
 * Created by Reda Mehali on 12/11/20.
 */
class AdminPizzaOrdersAdapter(context: Context) : PizzaOrdersAdapter(context) {

    private var orderList = emptyList<Order>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.admin_pizza_orders_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        for (order in orderList) {
            if (order.customer == pizzaOrderList[position].customer) {
                when (order.status) {
                    "received" -> {
                        holder.itemView.receivedButton.setBackgroundColor(context.getColor(R.color.colorAccent))
                        holder.itemView.inProgressButton.setBackgroundColor(context.getColor(R.color.grey))
                        holder.itemView.deliveredButton.setBackgroundColor(context.getColor(R.color.grey))
                    }
                    "in progress" -> {
                        holder.itemView.receivedButton.setBackgroundColor(context.getColor(R.color.grey))
                        holder.itemView.inProgressButton.setBackgroundColor(context.getColor(R.color.colorAccent))
                        holder.itemView.deliveredButton.setBackgroundColor(context.getColor(R.color.grey))
                    }
                    else -> {
                        holder.itemView.receivedButton.setBackgroundColor(context.getColor(R.color.grey))
                        holder.itemView.inProgressButton.setBackgroundColor(context.getColor(R.color.grey))
                        holder.itemView.deliveredButton.setBackgroundColor(context.getColor(R.color.colorAccent))
                    }
                }
            }
        }

        holder.itemView.receivedButton.setOnClickListener {
            holder.itemView.receivedButton.setBackgroundColor(context.getColor(R.color.colorAccent))
            holder.itemView.inProgressButton.setBackgroundColor(context.getColor(R.color.grey))
            holder.itemView.deliveredButton.setBackgroundColor(context.getColor(R.color.grey))
        }
        holder.itemView.inProgressButton.setOnClickListener {
            holder.itemView.receivedButton.setBackgroundColor(context.getColor(R.color.grey))
            holder.itemView.inProgressButton.setBackgroundColor(context.getColor(R.color.colorAccent))
            holder.itemView.deliveredButton.setBackgroundColor(context.getColor(R.color.grey))  }
        holder.itemView.deliveredButton.setOnClickListener {
            holder.itemView.receivedButton.setBackgroundColor(context.getColor(R.color.grey))
            holder.itemView.inProgressButton.setBackgroundColor(context.getColor(R.color.grey))
            holder.itemView.deliveredButton.setBackgroundColor(context.getColor(R.color.colorAccent))
        }
    }

    fun setOrderData(orders: List<Order>) {
        this.orderList = orders
    }
}