package calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FilterChip
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import calculator.operation.Division
import calculator.operation.Multiplication
import calculator.operation.Operation
import calculator.operation.Subtraction
import calculator.operation.Sum

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun OperationSelection(
    selected: Operation,
    onSelect: (Operation) -> Unit,
    modifier: Modifier = Modifier
) {
    val operations = remember { listOf(Sum(), Subtraction(), Multiplication(), Division()) }

    LazyRow(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items = operations) {
            FilterChip(
                selected = selected == it,
                onClick = {
                    onSelect(it)
                },
                content = { Text(it.label) }
            )
        }
    }
}