import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        var field1 by remember { mutableStateOf(TextFieldValue("")) }
        var field2 by remember { mutableStateOf(TextFieldValue("")) }
        val (focus1, focus2) = remember { FocusRequester.createRefs() }


        Scaffold(Modifier.systemBarsPadding()) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedTextField(
                    modifier = Modifier.focusRequester(focus1).weight(1f),
                    value = field1,
                    onValueChange = {
                        field1 = it
                        if (it.text.length >= 6) {
                            focus2.requestFocus()
                        }
                    }
                )
                OutlinedTextField(
                    modifier = Modifier.focusRequester(focus2).weight(1f),
                    value = field2,
                    onValueChange = { field2 = it }
                )
            }
        }
    }
}