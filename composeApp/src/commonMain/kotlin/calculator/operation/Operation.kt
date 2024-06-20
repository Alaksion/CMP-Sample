package calculator.operation

abstract class Operation {
    abstract val label: String

    abstract fun operation(value1: Long, value2: Long): Long

    abstract fun validate(value1: Long, value2: Long)

    fun calculate(value1: Long, value2: Long): Long {
        validate(value1, value2)
        return calculate(value1, value2)
    }

    class OperationError(override val message: String?) : Throwable()
}