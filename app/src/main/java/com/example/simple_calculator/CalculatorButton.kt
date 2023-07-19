package com.example.simple_calculator

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    buttonText: String,
    modifier: Modifier,
    buttonOnClick: () -> Unit,
    buttonColors: ButtonColors
) {
    Button(
        onClick = buttonOnClick,
        shape = RoundedCornerShape(24),
        modifier = modifier,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp,
            pressedElevation = 2.dp
        ),
        colors = buttonColors
    ) {
        Text(text = buttonText,
            style = TextStyle(
                fontSize = 24.sp
            )
        )
    }
}