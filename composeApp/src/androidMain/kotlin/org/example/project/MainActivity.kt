package org.example.project

import App
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity(), AppShakeListener {

    private var sensorManager: SensorManager? = null
    private var sensorListener: AppSensorEventListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        sensorListener = AppSensorEventListener(
            initialAcceleration = SensorManager.GRAVITY_EARTH
        )
        setContent {
            App()
        }
    }

    override fun onStart() {
        super.onStart()
        sensorManager?.let { manager ->
            val accelerometer = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
            manager.registerListener(
                sensorListener,
                accelerometer,
                SensorManager.SENSOR_DELAY_NORMAL
            )
        }
        sensorListener?.listener = this
    }

    override fun onPause() {
        super.onPause()
        sensorManager?.unregisterListener(sensorListener)
        sensorListener?.listener = null
    }

    override fun onShake() {
        Toast.makeText(this, "App Shaked", Toast.LENGTH_LONG).show()
    }
}