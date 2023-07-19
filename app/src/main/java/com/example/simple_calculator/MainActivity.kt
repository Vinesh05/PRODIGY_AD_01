package com.example.simple_calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simple_calculator.ui.theme.Primary
import com.example.simple_calculator.ui.theme.Secondary
import com.example.simple_calculator.ui.theme.SecondaryDark
import com.example.simple_calculator.ui.theme.Simple_CalculatorTheme

class MainActivity : ComponentActivity() {

    private val calculatorViewModel = CalculatorViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UI()
        }
    }

    @Composable
    fun TextCard(
        modifier: Modifier,
        backgroundColor: Color
    ){
        Card(
            shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp),
            modifier = modifier,
            elevation = CardDefaults.cardElevation(
                defaultElevation = 16.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = backgroundColor
            )
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(8.dp)
            ){
//                Button(
//                    onClick = {},
//                    shape = RoundedCornerShape(24),
//                    modifier = Modifier
//                        .padding(8.dp)
//                        .weight(1f)
//                        .align(Alignment.End),
//                    elevation = ButtonDefaults.buttonElevation(
//                        defaultElevation = 4.dp,
//                        pressedElevation = 2.dp
//                    ),
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = Primary
//                    )
//                ){
//                    Image(painter = painterResource(id = R.drawable.ic_share), contentDescription = "Share Button")
//                }
                Text(
                    modifier = Modifier
                        .weight(2f)
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    style = TextStyle(
                        fontSize = 48.sp,
                        textAlign = TextAlign.End
                    ),
                    text = calculatorViewModel.inputString.value,
                    maxLines = 1
                )
                Text(
                    modifier = Modifier
                        .weight(2f)
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    style = TextStyle(
                        fontSize = 64.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.End
                    ),
                    text = calculatorViewModel.outputString.value,
                    maxLines = 1
                )
            }
        }
    }

    @Composable
    fun KeyPad(
        modifier: Modifier,
        operationsButtonColor: Color,
        operationsContentColor: Color,
        operationsBackgroundColor: Color
    ){
        Column(modifier = modifier){
            Row(
                modifier = Modifier.weight(4f)
            ){
                Column(
                    modifier = Modifier
                        .weight(3f)
                ) {
                    //AC, DEL
                    Row(
                        modifier = Modifier.weight(1f)
                    ) {
                        CalculatorButton(
                            buttonText = "AC",
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f)
                                .fillMaxHeight(),
                            buttonOnClick = {
                                calculatorViewModel.onAction(CalculatorAction.Clear)
                            },
                            buttonColors = ButtonDefaults.buttonColors(
                                containerColor = operationsButtonColor,
                                contentColor = operationsContentColor
                            )
                        )
                        CalculatorButton(
                            buttonText = "DEL",
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f)
                                .fillMaxHeight(),
                            buttonOnClick = {
                                calculatorViewModel.onAction(CalculatorAction.Delete)
                            },
                            buttonColors = ButtonDefaults.buttonColors(
                                containerColor = operationsButtonColor,
                                contentColor = operationsContentColor
                            )
                        )
                    }

                    //7,8,9
                    Row(
                        modifier = Modifier.weight(1f)
                    ) {
                        CalculatorButton(
                            buttonText = "7",
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f)
                                .fillMaxHeight(),
                            buttonOnClick = {
                                calculatorViewModel.onAction(CalculatorAction.Input('7'))
                            },
                            buttonColors = ButtonDefaults.buttonColors()
                        )
                        CalculatorButton(
                            buttonText = "8",
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f)
                                .fillMaxHeight(),
                            buttonOnClick = {
                                calculatorViewModel.onAction(CalculatorAction.Input('8'))
                            },
                            buttonColors = ButtonDefaults.buttonColors()
                        )
                        CalculatorButton(
                            buttonText = "9",
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f)
                                .fillMaxHeight(),
                            buttonOnClick = {
                                calculatorViewModel.onAction(CalculatorAction.Input('9'))
                            },
                            buttonColors = ButtonDefaults.buttonColors()
                        )
                    }

                    //4,5,6
                    Row(
                        modifier = Modifier.weight(1f)
                    ) {
                        CalculatorButton(
                            buttonText = "4",
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f)
                                .fillMaxHeight(),
                            buttonOnClick = {
                                calculatorViewModel.onAction(CalculatorAction.Input('4'))
                            },
                            buttonColors = ButtonDefaults.buttonColors()
                        )
                        CalculatorButton(
                            buttonText = "5",
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f)
                                .fillMaxHeight(),
                            buttonOnClick = {
                                calculatorViewModel.onAction(CalculatorAction.Input('5'))
                            },
                            buttonColors = ButtonDefaults.buttonColors()
                        )
                        CalculatorButton(
                            buttonText = "6",
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f)
                                .fillMaxHeight(),
                            buttonOnClick = {
                                calculatorViewModel.onAction(CalculatorAction.Input('6'))
                            },
                            buttonColors = ButtonDefaults.buttonColors()
                        )
                    }

                    //1,2,3
                    Row(
                        modifier = Modifier.weight(1f)
                    ) {
                        CalculatorButton(
                            buttonText = "1",
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f)
                                .fillMaxHeight(),
                            buttonOnClick = {
                                calculatorViewModel.onAction(CalculatorAction.Input('1'))
                            },
                            buttonColors = ButtonDefaults.buttonColors()
                        )
                        CalculatorButton(
                            buttonText = "2",
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f)
                                .fillMaxHeight(),
                            buttonOnClick = {
                                calculatorViewModel.onAction(CalculatorAction.Input('2'))
                            },
                            buttonColors = ButtonDefaults.buttonColors()
                        )
                        CalculatorButton(
                            buttonText = "3",
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f)
                                .fillMaxHeight(),
                            buttonOnClick = {
                                calculatorViewModel.onAction(CalculatorAction.Input('3'))
                            },
                            buttonColors = ButtonDefaults.buttonColors()
                        )
                    }

                }
                Column(
                    modifier = Modifier
                        .background(operationsBackgroundColor, shape = RoundedCornerShape(32.dp))
                        .weight(1f)
                        .padding(4.dp)
                ){
                    CalculatorButton(
                        buttonText = "+",
                        modifier = Modifier
                            .padding(12.dp)
                            .weight(1f)
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        buttonOnClick = {
                            calculatorViewModel.onAction(CalculatorAction.Input('+'))
                        },
                        buttonColors = ButtonDefaults.buttonColors()
                    )
                    CalculatorButton(
                        buttonText = "-",
                        modifier = Modifier
                            .padding(12.dp)
                            .weight(1f)
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        buttonOnClick = {
                            calculatorViewModel.onAction(CalculatorAction.Input('-'))
                        },
                        buttonColors = ButtonDefaults.buttonColors()
                    )
                    CalculatorButton(
                        buttonText = "X",
                        modifier = Modifier
                            .padding(12.dp)
                            .weight(1f)
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        buttonOnClick = {
                            calculatorViewModel.onAction(CalculatorAction.Input('X'))
                        },
                        buttonColors = ButtonDefaults.buttonColors()
                    )
                    CalculatorButton(
                        buttonText = "/",
                        modifier = Modifier
                            .padding(12.dp)
                            .weight(1f)
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        buttonOnClick = {
                            calculatorViewModel.onAction(CalculatorAction.Input('/'))
                        },
                        buttonColors = ButtonDefaults.buttonColors()
                    )
                }
            }
            Row(
                modifier = Modifier.weight(1f)
            ){
                CalculatorButton(
                    buttonText = ".",
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(1f)
                        .fillMaxHeight(),
                    buttonOnClick = {
                        calculatorViewModel.onAction(CalculatorAction.Input('.'))
                    },
                    buttonColors = ButtonDefaults.buttonColors()
                )
                CalculatorButton(
                    buttonText = "0",
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(1f)
                        .fillMaxHeight(),
                    buttonOnClick = {
                        calculatorViewModel.onAction(CalculatorAction.Input('0'))
                    },
                    buttonColors = ButtonDefaults.buttonColors()
                )
                CalculatorButton(
                    buttonText = "=",
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 4.dp)
                        .weight(2f)
                        .fillMaxHeight(),
                    buttonOnClick = {
                        calculatorViewModel.onAction(CalculatorAction.Calculate)
                    },
                    buttonColors = ButtonDefaults.buttonColors(
                        operationsBackgroundColor,
                        operationsButtonColor
                    )
                )
            }
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun UI() {

        var backgroundColor = Primary
        var operationsButtonColor = Primary
        var operationsContentColor = SecondaryDark
        var operationsBackgroundColor = SecondaryDark

        Simple_CalculatorTheme {

            if(isSystemInDarkTheme()){
                backgroundColor = Secondary
                operationsButtonColor = SecondaryDark
                operationsContentColor = Primary
                operationsBackgroundColor = Primary
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(backgroundColor)
            ) {

                TextCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f)
                        .height(IntrinsicSize.Max)
                        .padding(bottom = 16.dp),
                    operationsButtonColor
                )

                KeyPad(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(3f)
                        .padding(8.dp),
                    operationsButtonColor,
                    operationsContentColor,
                    operationsBackgroundColor
                )

            }
        }
    }

}

