package calculator.operation

class Sum : Operation() {

    override val label: String = "Sum"
    override fun operation(value1: Long, value2: Long): Long {
        return value1 + value2
    }

    override fun validate(value1: Long, value2: Long) = Unit
}