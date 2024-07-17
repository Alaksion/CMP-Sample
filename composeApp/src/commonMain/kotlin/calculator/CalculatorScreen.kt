package calculator

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
internal fun CalculatorScreen() {
    val state = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    BoxWithConstraints(Modifier.fillMaxSize()) {
        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet {
                    Column {
                        Text("Hello World")
                    }
                }
            },
            drawerState = state
        ) {
            Scaffold {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .imePadding(),
                    bottomBar = {
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .navigationBarsPadding()
                        ) {
                            Text("Hello World")
                        }
                    }
                ) { paddings ->
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                top = paddings.calculateTopPadding() + 32.dp,
                                bottom = paddings.calculateBottomPadding(),
                                start = 20.dp,
                                end = 20.dp
                            )
                    ) {
                        item {
                            Button(onClick = {
                                scope.launch { state.open() }
                            }) {
                                Text("Open drawer")
                            }
                        }

                        items((1..30).toList()) {
                            Text(
                                text = it.toString(),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            )
                        }
                        item {
                            Spacer(Modifier.height(40.dp))
                            OutlinedTextField(
                                value = "",
                                onValueChange = {}
                            )
                            Spacer(Modifier.height(40.dp))
                        }
                    }
                }
            }
        }
    }
}