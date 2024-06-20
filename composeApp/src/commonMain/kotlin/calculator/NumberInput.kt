package calculator

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun NumberInput(
    value: Long,
    onValueChange: (Long) -> Unit,
    modifier: Modifier = Modifier,
    characterLimit: Int = 10
) {
    var internalState by remember { mutableStateOf(value.toString()) }
    val longState by remember {
        derivedStateOf {
            internalState.toLongOrNull() ?: 0L
        }
    }
    LaunchedEffect(longState) {
        onValueChange(longState)
    }

    TextField(
        value = internalState,
        modifier = modifier,
        onValueChange = { newValue ->
            val filtered =
                newValue.filterIndexed { index, preFiltered ->
                    preFiltered.isDigit() || (preFiltered == '-') && index == 0
                }
            if (filtered.length <= characterLimit) {
                internalState = filtered
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number
        )
    )
}
