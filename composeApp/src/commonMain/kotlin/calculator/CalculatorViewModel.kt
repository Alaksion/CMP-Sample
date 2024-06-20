package calculator

import calculator.operation.Operation
import calculator.operation.Sum
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CalculatorViewModel {

    val value1 = MutableStateFlow(0L)

    val value2 = MutableStateFlow(0L)

    private val _result = MutableStateFlow<Long?>(null)
    val result: StateFlow<Long?> = _result

    val operation = MutableStateFlow<Operation>(Sum())

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun calculate() {
        runCatching {
            operation.value.calculate(value1.value, value2.value)
        }.fold(
            onSuccess = {
                _error.value = null
                _result.value = it
            },
            onFailure = {
                _error.value = it.message
            }
        )
    }

    fun updateValue1(value: Long) {
        value1.update { value }
    }

    fun updateValue2(value: Long) {
        value2.update { value }
    }

    fun updateOperation(operation: Operation) {
        this.operation.update { operation }
    }
}