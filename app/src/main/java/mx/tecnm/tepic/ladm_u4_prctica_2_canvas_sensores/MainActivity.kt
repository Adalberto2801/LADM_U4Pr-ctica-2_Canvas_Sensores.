package mx.tecnm.tepic.ladm_u4_prctica_2_canvas_sensores

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(),SensorEventListener {
    lateinit var sensorManager: SensorManager
    lateinit var Lienzo: Lienzo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Lienzo = Lienzo(this)
        Lienzo.fondo = Color.BLUE
        setContentView(Lienzo)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
      //SENSOR ACELEROMETRO
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL)
       //SENSOIR PROXIMIDAD
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
        SensorManager.SENSOR_DELAY_NORMAL)


    }

    override fun onSensorChanged(event: SensorEvent) {
        when(event.sensor.type){
            Sensor.TYPE_ACCELEROMETER ->{
                if(event.values[2]<0){
                    Lienzo.posXc = Lienzo.posXc-5
                }else {
                    Lienzo.posXc = Lienzo.posXc+5
                }
            }
            Sensor.TYPE_PROXIMITY ->{
                if(event.values[0]<1.8f){
                    Lienzo.fondo = Color.MAGENTA
                }else {
                    Lienzo.fondo = Color.BLUE
                }
            }

        }
        Lienzo.postInvalidate()
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}