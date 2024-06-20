package calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun CalculatorScreen() {
    val viewModel = remember { CalculatorViewModel() }


    val field1 by viewModel.value1.collectAsState()
    val field2 by viewModel.value2.collectAsState()

    val result by viewModel.result.collectAsState()
    val error by viewModel.error.collectAsState()
    val operation = viewModel.operation.collectAsState()

    Scaffold(
        modifier = Modifier.systemBarsPadding()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                NumberInput(
                    modifier = Modifier.weight(1f),
                    value = field1,
                    onValueChange = viewModel::updateValue1
                )
                NumberInput(
                    modifier = Modifier.weight(1f),
                    value = field2,
                    onValueChange = viewModel::updateValue2
                )
            }

            Button(onClick = viewModel::calculate) {
                Text(text = "Calculate!")
            }

            Text(text = "Result: ${result?.toString() ?: ""}")

            error?.let { operationError ->
                Text(
                    text = operationError,
                    color = MaterialTheme.colors.error,
                )
            }

            OperationSelection(
                selected = operation.value,
                onSelect = viewModel::updateOperation,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}