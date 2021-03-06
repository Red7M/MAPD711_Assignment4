package com.problem.solutions.redamehali.mapd711_assignment4

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.problem.solutions.redamehali.mapd711_assignment4.admin.AdminHomeScreen
import com.problem.solutions.redamehali.mapd711_assignment4.admin.AdminViewModel
import com.problem.solutions.redamehali.mapd711_assignment4.customer.CustomerScreen
import com.problem.solutions.redamehali.mapd711_assignment4.customer.CustomerViewModel

class StartActivity : AppCompatActivity() {

    private lateinit var customerInputEditText: TextInputEditText
    private lateinit var customerInputEditPassword: TextInputEditText
    private lateinit var loginCustomerButton: Button

    private lateinit var pizzaAdminsEditText: TextInputEditText
    private lateinit var pizzaAdminsEditPassword: TextInputEditText
    private lateinit var loginAdminButton: Button

    private lateinit var customerViewModel: CustomerViewModel
    private lateinit var adminViewModel : AdminViewModel

    private var userPassWordMap: HashMap<String, String> = HashMap()
    private var adminPasswordMap : HashMap<String, String> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customerInputEditText = findViewById(R.id.customerInputEditText)
        customerInputEditPassword = findViewById(R.id.customerInputEditPassword)
        loginCustomerButton = findViewById(R.id.loginCustomerButton)

        pizzaAdminsEditText = findViewById(R.id.pizzaAdminsEditText)
        pizzaAdminsEditPassword = findViewById(R.id.pizzaAdminsEditPassword)
        loginAdminButton = findViewById(R.id.loginAdminButton)

        customerViewModel = ViewModelProvider(this).get(CustomerViewModel::class.java)
        adminViewModel = ViewModelProvider(this).get(AdminViewModel::class.java)

        customerViewModel.readAllCustomerData.observe(this, Observer { customers ->
            for (customer in customers) {
                userPassWordMap[customer.username] = customer.password
            }
        })
        adminViewModel.readAllAdminData.observe(this, Observer { admins ->
            for (admin in admins) {
                adminPasswordMap[admin.username] = admin.password
            }
        })

        setListenersForInputTexts()
        setButtonListeners()
    }

    private fun checkWhetherUserExists(): Boolean {
        for (username in userPassWordMap.keys) {
            if (username == customerInputEditText.text.toString() &&
                userPassWordMap[username]!! == customerInputEditPassword.text.toString()) {
                return true
            }
        }
        return false
    }

    private fun checkIfAdminExist() : Boolean {
        for (admin in adminPasswordMap.keys) {
            if (admin == pizzaAdminsEditText.text.toString() &&
                    adminPasswordMap[admin]!! == pizzaAdminsEditPassword.text.toString()) {
                return true
            }
        }
        return false
    }

    private fun setButtonListeners() {
        loginCustomerButton.setOnClickListener {
            if (checkWhetherUserExists()) {
                //SAVE TO SHARED PREF
                saveNameAndPassword(
                    customerInputEditText.text!!,
                    customerInputEditPassword.text!!,
                    Constant.SHARED_PREF_COSTUMER_USER_KEY,
                    Constant.SHARED_PREF_COSTUMER_PASSWORD_KEY
                )
                // LOGIN
                val intent = Intent(this, CustomerScreen::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this,
                    "Customer profile does not exists",
                    Toast.LENGTH_LONG).show()
            }
        }

        loginAdminButton.setOnClickListener {
            if (checkIfAdminExist()) {
                saveNameAndPassword(
                    customerInputEditText.text!!,
                    customerInputEditPassword.text!!,
                    Constant.SHARED_PREF_ADMIN_USER_KEY,
                    Constant.SHARED_PREF_ADMIN_PASSWORD_KEY)

                // Login into admin Screen
                val intent = Intent(this, AdminHomeScreen::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this,
                    "Admin profile does not exists",
                    Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun saveNameAndPassword(
        name: Editable,
        password: Editable,
        userKey: String,
        passwordKey: String
    ) {
        val sharedRef = getSharedPreferences("customer_key", Context.MODE_PRIVATE) ?: return
        with(sharedRef.edit()) {
            putString(userKey, name.toString())
            putString(passwordKey, password.toString())
            apply()
        }
    }

    private fun setListenersForInputTexts() {
        customerInputEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                enableLoginButton(
                    customerInputEditText.text!!,
                    customerInputEditPassword.text!!,
                    loginCustomerButton
                )
            }
        })

        customerInputEditPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                enableLoginButton(
                    customerInputEditText.text!!,
                    customerInputEditPassword.text!!,
                    loginCustomerButton
                )
            }
        })

        pizzaAdminsEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                enableLoginButton(
                    pizzaAdminsEditText.text!!,
                    pizzaAdminsEditPassword.text!!,
                    loginAdminButton
                )
            }
        })

        pizzaAdminsEditPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                enableLoginButton(
                    pizzaAdminsEditText.text!!,
                    pizzaAdminsEditPassword.text!!,
                    loginAdminButton
                )
            }
        })
    }

    private fun enableLoginButton(username: Editable, password: Editable, button: Button) {
        button.isEnabled = !username.isBlank() && !password.isBlank()
    }
}