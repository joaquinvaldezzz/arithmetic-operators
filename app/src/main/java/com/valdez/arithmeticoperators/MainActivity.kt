package com.valdez.arithmeticoperators

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {

    private lateinit var tvTotalAmount: TextView
    private lateinit var btnCalculateTotal: Button
    val prices = mapOf(
        "FriedChicken" to 149.0,
        "ChickenBurger" to 99.0,
        "BuffaloChickenWings" to 149.0,
        "ChickenNuggets" to 99.0,
        "FriedPotatoes" to 149.0,
        "CreamyCarbonara" to 99.0,
        "MilkTeaSmall" to 120.0,
        "MilkTeaMedium" to 140.0,
        "MilkTeaLarge" to 160.0,
        "MatchaLatteSmall" to 120.0,
        "MatchaLatteMedium" to 140.0,
        "MatchaLatteLarge" to 160.0,
        "LycheeDrinkSmall" to 120.0,
        "LycheeDrinkMedium" to 140.0,
        "LycheeDrinkLarge" to 160.0,
    )
    private lateinit var etQuantityFriedChicken: EditText
    private lateinit var etQuantityChickenBurger: EditText
    private lateinit var etQuantityBuffaloChickenWings: EditText
    private lateinit var etQuantityChickenNuggets: EditText
    private lateinit var etQuantityFriedPotatoes: EditText
    private lateinit var etQuantityCreamyCarbonara: EditText

    private lateinit var etQuantityMilkTeaSmall: EditText
    private lateinit var etQuantityMilkTeaMedium: EditText
    private lateinit var etQuantityMilkTeaLarge: EditText

    private lateinit var etQuantityMatchaLatteSmall: EditText
    private lateinit var etQuantityMatchaLatteMedium: EditText
    private lateinit var etQuantityMatchaLatteLarge: EditText

    private lateinit var etQuantityLycheeDrinkSmall: EditText
    private lateinit var etQuantityLycheeDrinkMedium: EditText
    private lateinit var etQuantityLycheeDrinkLarge: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_food_menu)

        tvTotalAmount = findViewById(R.id.tv_total_amount)

        etQuantityFriedChicken = findViewById(R.id.et_quantity_fried_chicken)
        etQuantityChickenBurger = findViewById(R.id.et_quantity_chicken_burger)
        etQuantityBuffaloChickenWings = findViewById(R.id.et_quantity_buffalo_chicken_wings)
        etQuantityChickenNuggets = findViewById(R.id.et_quantity_chicken_nuggets)
        etQuantityFriedPotatoes = findViewById(R.id.et_quantity_fried_potatoes)
        etQuantityCreamyCarbonara = findViewById(R.id.et_quantity_creamy_carbonara)

        etQuantityMilkTeaSmall = findViewById(R.id.et_quantity_milk_tea_small)
        etQuantityMilkTeaMedium = findViewById(R.id.et_quantity_milk_tea_medium)
        etQuantityMilkTeaLarge = findViewById(R.id.et_quantity_milk_tea_large)

        etQuantityMatchaLatteSmall = findViewById(R.id.et_quantity_matcha_latte_small)
        etQuantityMatchaLatteMedium = findViewById(R.id.et_quantity_matcha_latte_medium)
        etQuantityMatchaLatteLarge = findViewById(R.id.et_quantity_matcha_latte_large)

        etQuantityLycheeDrinkSmall = findViewById(R.id.et_quantity_lychee_drink_small)
        etQuantityLycheeDrinkMedium = findViewById(R.id.et_quantity_lychee_drink_medium)
        etQuantityLycheeDrinkLarge = findViewById(R.id.et_quantity_lychee_drink_large)

        btnCalculateTotal = findViewById(R.id.btn_calculate_total)

        btnCalculateTotal.setOnClickListener {
            calculateTotal()
        }

    }

    private fun calculateTotal(): Double {
        var total = 0.0

        total += calculateItemTotal(etQuantityFriedChicken, prices["FriedChicken"]!!)
        total += calculateItemTotal(etQuantityChickenBurger, prices["ChickenBurger"]!!)
        total += calculateItemTotal(etQuantityBuffaloChickenWings, prices["BuffaloChickenWings"]!!)
        total += calculateItemTotal(etQuantityChickenNuggets, prices["ChickenNuggets"]!!)
        total += calculateItemTotal(etQuantityFriedPotatoes, prices["FriedPotatoes"]!!)
        total += calculateItemTotal(etQuantityCreamyCarbonara, prices["CreamyCarbonara"]!!)

        total += calculateItemTotal(etQuantityMilkTeaSmall, prices["MilkTeaSmall"]!!)
        total += calculateItemTotal(etQuantityMilkTeaMedium, prices["MilkTeaMedium"]!!)
        total += calculateItemTotal(etQuantityMilkTeaLarge, prices["MilkTeaLarge"]!!)

        total += calculateItemTotal(etQuantityMatchaLatteSmall, prices["MatchaLatteSmall"]!!)
        total += calculateItemTotal(etQuantityMatchaLatteMedium, prices["MatchaLatteMedium"]!!)
        total += calculateItemTotal(etQuantityMatchaLatteLarge, prices["MatchaLatteLarge"]!!)

        total += calculateItemTotal(etQuantityLycheeDrinkSmall, prices["LycheeDrinkSmall"]!!)
        total += calculateItemTotal(etQuantityLycheeDrinkMedium, prices["LycheeDrinkMedium"]!!)
        total += calculateItemTotal(etQuantityLycheeDrinkLarge, prices["LycheeDrinkLarge"]!!)


        tvTotalAmount.text = buildString {
            append("₱")
            append(total.format(2))
        }

        return total
    }

    private fun calculateItemTotal(quantityEditText: EditText, price: Double): Double {
        val quantity = quantityEditText.text.toString().toDoubleOrNull() ?: 0.0
        return quantity * price
    }

    private fun Double.format(digits: Int) = "%.${digits}f".format(this)
}
