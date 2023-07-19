package com.example.simple_calculator

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {
    var inputString = mutableStateOf(String())
        private set
    var outputString = mutableStateOf(String())
        private set

    fun onAction(action: CalculatorAction){
        when(action){
            is CalculatorAction.Clear->{
                inputString.value = ""
                outputString.value = ""
            }
            is CalculatorAction.Delete->{
                inputString.value = inputString.value.dropLast(1)
            }
            is CalculatorAction.Input->{
                input(action.symbol)
            }
            is CalculatorAction.Calculate->{
                calculate()
            }
        }
    }

    private fun input(symbol: Char){
        if(inputString.value.isNotEmpty() && inputString.value.last()<'0' && symbol<'0'){
            return
        }
        inputString.value += symbol
    }

    private fun calculate(){
        val nums = ArrayList<Int>()
        val operators = ArrayList<Char>()
        var temp = 0
        var negative = false

        if(inputString.value[0]=='-'){
            negative = true
        }

        inputString.value.forEachIndexed {index, currentChar ->
            if(currentChar in '0'..'9'){
                temp*=10
                temp+=(currentChar-'0')
            }
            else{
                if(temp!=0){
                    if(negative){
                        temp*=-1
                        negative = false
                    }
                    nums.add(temp)
                    temp = 0
                }
                if(index!=0) {
                    operators.add(currentChar)
                }
            }
        }
        nums.add(temp)

        if(nums.lastIndex-operators.lastIndex<=1){
            var ans = nums[0].toFloat()
            operators.forEachIndexed { index, currentOperator ->
                when(currentOperator){
                    '+'->{
                        ans+=nums[index+1]
                    }
                    '-'->{
                        ans-=nums[index+1]
                    }
                    'X'->{
                        ans*=nums[index+1]
                    }
                    '/'->{
                        ans/=nums[index+1]
                    }
                    else->{}
                }
            }
            if(negative){
                ans*=-1
            }
            outputString.value = ans.toString()
        }


    }

}