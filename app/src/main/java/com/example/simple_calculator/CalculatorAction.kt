package com.example.simple_calculator

sealed class CalculatorAction {

    data class Input(val symbol: Char): CalculatorAction()
    object Clear: CalculatorAction()
    object Delete: CalculatorAction()
    object Calculate: CalculatorAction()

}
