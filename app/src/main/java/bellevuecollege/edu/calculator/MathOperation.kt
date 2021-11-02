package bellevuecollege.edu.calculator

class MathOperation {

    companion object {

        // Addition Operation
        fun addition(leftNumber: Double, rightNumber: Double): Double {
            return (leftNumber + rightNumber)
        }

        //Subtraction Operation
        fun subtraction(leftNumber: Double, rightNumber: Double): Double {
            return (leftNumber - rightNumber)
        }

        //Division Operation
        fun division(leftNumber: Double, rightNumber: Double): Double {
            return (leftNumber/rightNumber)
        }

        //Multiplication Operation
        fun multiplication(leftNumber: Double, rightNumber: Double): Double {
            return (leftNumber * rightNumber)
        }
    }
}