import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class ShakeFlow {
    private val _shakeFlow = MutableSharedFlow<Unit>()
    val shakeFlow: SharedFlow<Unit> = _shakeFlow

    fun sendShakeEvent() {
        CoroutineScope(Dispatchers.Default).launch {
            _shakeFlow.emit(Unit)
        }
    }

}