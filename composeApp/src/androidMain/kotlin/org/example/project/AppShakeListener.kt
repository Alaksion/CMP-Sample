package org.example.project

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import kotlin.math.sqrt

interface AppShakeListener {
    fun onShake()
}

class AppSensorEventListener(
    initialAcceleration: Float
) : SensorEventListener {

    var listener: AppShakeListener? = null

    private var acceleration = 10f

    private var currentAcceleration = initialAcceleration
    private var lastAcceleration = initialAcceleration

    override fun onSensorChanged(event: SensorEvent) {

        // Fetching x,y,z values
        val x = event.values[0]
        val y = event.values[1]
        val z = event.values[2]
        lastAcceleration = currentAcceleration

        // Getting current accelerations
        // with the help of fetched x,y,z values
        currentAcceleration = sqrt((x * x + y * y + z * z).toDouble()).toFloat()
        val delta: Float = currentAcceleration - lastAcceleration
        acceleration = acceleration * 0.9f + delta

        // Display a Toast message if
        // acceleration value is over 12
        if (acceleration > 12) {
            listener?.onShake()
        }
    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}
}