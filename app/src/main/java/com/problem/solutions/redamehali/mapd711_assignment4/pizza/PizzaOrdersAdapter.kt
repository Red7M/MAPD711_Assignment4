package com.problem.solutions.redamehali.mapd711_assignment4.pizza

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.problem.solutions.redamehali.mapd711_assignment4.R
import kotlinx.android.synthetic.main.pizza_orders_row.view.*

/**
 * Created by Reda Mehali on 12/3/20.
 */
open class PizzaOrdersAdapter(val context: Context): RecyclerView.Adapter<PizzaOrdersAdapter.MyViewHolder>() {

    var pizzaOrderList = emptyList<Pizza>()


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pizza_orders_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = pizzaOrderList[position]

        holder.itemView.pizzaName.text = currentItem.pizzaName
        holder.itemView.customerText.text = currentItem.customer
        holder.itemView.quantityText.text = currentItem.quantity
    }

    fun setData(pizza: List<Pizza>) {
        this.pizzaOrderList = pizza
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return pizzaOrderList.size
    }
}