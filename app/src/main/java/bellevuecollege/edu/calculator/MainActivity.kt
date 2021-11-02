package bellevuecollege.edu.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var display_digits = StringBuilder(14)//maximum digits can be displayed
    //no need to lateinit for primitive types
    private var operation: Char = ' '
    private var leftHandside: Double = 0.0
    private var rightHandSide: Double = 0.0
    private var finishedOperation: Boolean = false

    //override onCreate to display UI when user turn on the app
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //display UI

        "0".also { display_res.text = it } //display_res.text = 0 , always show 0 when turn on the app

        calculate() //call main function to control calculation
    }

    private fun calculate() {
        functionalButtons()
        operationChoice()
        digitDisplay()
    }

    // call helper to display digits on the screen
    private fun digitDisplay() {

        buttonOne.setOnClickListener {
            displayNumberOnTheScreen("1")
        }

        buttonTwo.setOnClickListener {
            displayNumberOnTheScreen("2")
        }

        buttonThree.setOnClickListener {
            displayNumberOnTheScreen("3")
        }

        buttonFour.setOnClickListener {
            displayNumberOnTheScreen("4")
        }

        buttonFive.setOnClickListener {
            displayNumberOnTheScreen("5")
        }

        buttonSix.setOnClickListener {
            displayNumberOnTheScreen("6")
        }

        buttonSeven.setOnClickListener {
            displayNumberOnTheScreen("7")
        }

        buttonEight.setOnClickListener {
            displayNumberOnTheScreen("8")
        }

        buttonNine.setOnClickListener {
            displayNumberOnTheScreen("9")
        }

        buttonZero.setOnClickListener {
            displayNumberOnTheScreen("0")
        }

        buttonDot.setOnClickListener {
            displayNumberOnTheScreen(".")
        }

    }

    // method to display digits on screen when user clicks on digit buttons
    private fun displayNumberOnTheScreen(digit: String) {

        // Add each digit to concatenate in string builder
        if (finishedOperation) {
            display_digits.clear()
            finishedOperation = false
        }
        display_digits.append(digit)

        // display on screen
        display_res.text = display_digits.toString()
    }

    //direct to choices of operation
    private fun operationChoice() {

        buttonAddition.setOnClickListener {
            selectOperation('+')
        }

        buttonSubtraction.setOnClickListener {
            selectOperation('-')
        }

        buttonMultiplication.setOnClickListener {
            selectOperation('x')
        }
        buttonDivision.setOnClickListener {
            selectOperation('/')
        }

    }

    //method to assign the sign of operation
    private fun selectOperation(c: Char) {

        operation = c
        leftHandside = display_digits.toString().toDouble()
        display_digits.clear()
        display_res.text = operation.toString() //display operational sign
    }

    //method to control clear and backspace buttons
    private fun functionalButtons() {
        //clear everything and display 0 to resume initial UI
        buttonClearEverything.setOnClickListener {
            display_digits.clear()
            display_res.text = "0"
        }

        buttonClear.setOnClickListener {
            if (display_digits.length <= 0) {
                return@setOnClickListener
            } else {
                clearDigit()
            }
        }

        buttonBackSpace.setOnClickListener {
            if (display_digits.length <= 0) {
                return@setOnClickListener
            } else {
                clearDigit()
            }
        }

        buttonEqual.setOnClickListener {
            performMathOperation()
        }
    }

    //method to call OperationHelper to do math operation +,-,x,:
    private fun performMathOperation() {

        rightHandSide = display_digits.toString().toDouble()
        //leftHandSide = display_digits.toString().toDouble()
        when (operation) {

            '+' -> {
                //calculate
                val sum = MathOperation.addition(leftHandside, rightHandSide)
                //get the result
                display_res.text = sum.toString()
                display_digits.clear()
                display_digits.append(sum)
            }
            '-' -> {
                val subtract = MathOperation.subtraction(leftHandside, rightHandSide)
                display_res.text = subtract.toString()
                display_digits.clear()
                display_digits.append(subtract)
            }
            'x' -> {
                val multiply = MathOperation.multiplication(leftHandside, rightHandSide)
                display_res.text = multiply.toString()
                display_digits.clear()
                display_digits.append(multiply)
            }
            '/' -> {
                val divide = MathOperation.division(leftHandside, rightHandSide)
                display_res.text = divide.toString()
                display_digits.clear()
                display_digits.append(divide)
            }
        }
        finishedOperation = true
    }

    //Method to remove the last digit on screen.
    private fun clearDigit() {

        val length = display_digits.length
        display_digits.deleteCharAt(length - 1)
        if (length <= 0) {
            display_res.text = "0"
        }else{
            display_res.text = display_digits.toString()
        }
    }
}