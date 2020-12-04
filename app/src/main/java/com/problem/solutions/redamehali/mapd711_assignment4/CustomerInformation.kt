package com.problem.solutions.redamehali.mapd711_assignment4

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.customer_information_layout.*

/**
 * Created by Reda Mehali on 12/3/20.
 */
class CustomerInformation : AppCompatActivity() {

    private lateinit var saveInformationButton: Button
    private lateinit var customerViewModel: CustomerViewModel
    private lateinit var username: String
    private lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customer_information_layout)

        saveInformationButton = findViewById(R.id.saveInformationButton)
        customerViewModel = ViewModelProvider(this).get(CustomerViewModel::class.java)

        getUsernameAndPasswordFromSharedPref()

        customerViewModel.readAllCustomerData.observe(this, Observer { customers ->
            setPersonalInfo(customers)
        })

        saveInformationButton.setOnClickListener {
            insertCustomerInformationIntoDB()
        }
    }

    private fun setPersonalInfo(customers: List<Customer>) {
        for (customer in customers) {
            if (customer.username == username && customer.password == password) {
                userNameText.setText(customer.username)
                passwordText.setText(customer.password)
                firstNameText.setText(customer.firstName)
                lastNameText.setText(customer.lastName)
                addressText.setText(customer.address)
                cityText.setText(customer.city)
                postalCodeText.setText(customer.postalCode)
            }
        }
    }

    private fun getUsernameAndPasswordFromSharedPref() {
        val sharedPref = getSharedPreferences("customer_key", Context.MODE_PRIVATE)?: return
        username = sharedPref.getString(Constant.SHARED_PREF_COSTUMER_USER_KEY, "").toString()
        password = sharedPref.getString(Constant.SHARED_PREF_COSTUMER_PASSWORD_KEY, "").toString()
    }

    private fun insertCustomerInformationIntoDB() {
        if (userNameText.text.isBlank() || passwordText.text.isBlank() ||
            firstNameText.text.isBlank() || lastNameText.text.isBlank() ||
            addressText.text.isBlank() || cityText.text.isBlank() ||
            postalCodeText.text.isBlank()) {

            Toast.makeText(
                this,
                "Please fill out all fields",
                Toast.LENGTH_LONG).show()
            return;
        }

        val userName = userNameText.text.toString()
        val password = passwordText.text.toString()
        val firstName = firstNameText.text.toString()
        val lastName = lastNameText.text.toString()
        val address = addressText.text.toString()
        val city = cityText.text.toString()
        val postalCode = postalCodeText.text.toString()

        val customer = Customer(0, userName, password,
            firstName, lastName, address, city, postalCode)

        customerViewModel.addCustomer(customer)
        Toast.makeText(
            this,
            "Successfully added!",
            Toast.LENGTH_LONG).show()
    }
}