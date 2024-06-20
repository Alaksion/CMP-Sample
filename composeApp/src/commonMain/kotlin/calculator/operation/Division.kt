package calculator.operation

class Division : Operation() {

    override val label: String = "Division"

    override fun operation(value1: Long, value2: Long): Long {
        return value1 % value2
    }

    override fun validate(value1: Long, value2: Long) {
        if (value2 == 0L && value1 == 0L) {
            throw OperationError("Cannot divide by 0")
        }
    }
}