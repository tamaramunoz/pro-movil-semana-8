package com.example.tamara_munoz_semana8

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var rgSystem: RadioGroup
    private lateinit var rbDecimal: RadioButton
    private lateinit var etNumber1: EditText
    private lateinit var etNumber2: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnConvert: Button
    private lateinit var btnClear: Button
    private lateinit var tvResultDecimal: TextView
    private lateinit var tvResultBinary: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialización de vistas
        rgSystem = findViewById(R.id.rgSystem)
        rbDecimal = findViewById(R.id.rbDecimal)
        etNumber1 = findViewById(R.id.etNumber1)
        etNumber2 = findViewById(R.id.etNumber2)
        btnAdd = findViewById(R.id.btnAdd)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnConvert = findViewById(R.id.btnConvert)
        btnClear = findViewById(R.id.btnClear)
        tvResultDecimal = findViewById(R.id.tvResultDecimal)
        tvResultBinary = findViewById(R.id.tvResultBinary)

        // Configuración de listeners
        btnAdd.setOnClickListener { executeOperation(OperationType.ADD) }
        btnSubtract.setOnClickListener { executeOperation(OperationType.SUBTRACT) }
        btnConvert.setOnClickListener { executeConversion() }
        btnClear.setOnClickListener { clearFields() }
    }

    private enum class OperationType { ADD, SUBTRACT }

    private fun isDecimalMode(): Boolean = rbDecimal.isChecked

    // Valida si la cadena ingresada es un número binario válido (solo 0s y 1s)
    private fun isValidBinary(input: String): Boolean {
        return input.matches(Regex("^[01]+$"))
    }

    private fun parseToDecimal(input: String): Long? {
        return if (isDecimalMode()) {
            input.toLongOrNull()
        } else {
            if (isValidBinary(input)) input.toLongOrNull(2) else null
        }
    }

    private fun executeOperation(operation: OperationType) {
        val str1 = etNumber1.text.toString().trim()
        val str2 = etNumber2.text.toString().trim()

        if (str1.isEmpty() || str2.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese ambos números para operar", Toast.LENGTH_SHORT).show()
            return
        }

        val num1 = parseToDecimal(str1)
        val num2 = parseToDecimal(str2)

        if (num1 == null || num2 == null) {
            val errorMsg = if (!isDecimalMode()) "Formato binario inválido (solo 0 y 1)" else "Número decimal inválido"
            Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show()
            return
        }

        val result = when (operation) {
            OperationType.ADD -> num1 + num2
            OperationType.SUBTRACT -> num1 - num2
        }

        displayResults(result)
    }

    private fun executeConversion() {
        val str1 = etNumber1.text.toString().trim()

        if (str1.isEmpty()) {
            Toast.makeText(this, "Ingrese el Número 1 para realizar la conversión", Toast.LENGTH_SHORT).show()
            return
        }

        val num1 = parseToDecimal(str1)

        if (num1 == null) {
            val errorMsg = if (!isDecimalMode()) "Formato binario inválido (solo 0 y 1)" else "Número decimal inválido"
            Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show()
            return
        }

        displayResults(num1)
    }

    private fun displayResults(decimalValue: Long) {
        tvResultDecimal.text = "Resultado Decimal: $decimalValue"
        tvResultBinary.text = "Resultado Binario: ${java.lang.Long.toBinaryString(decimalValue)}"
    }

    private fun clearFields() {
        etNumber1.text.clear()
        etNumber2.text.clear()
        tvResultDecimal.text = "Resultado Decimal: -"
        tvResultBinary.text = "Resultado Binario: -"
    }
}