package mx.tecnm.tepic.ladm_u4_prctica_2_canvas_sensores

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Lienzo(p:MainActivity) : View(p) {
    val principal = p
    var posXc = 300f
    var fondo = 0
    val hijo= BitmapFactory.decodeResource(principal.resources,R.drawable.hijo)
    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p= Paint()

        c.drawColor(fondo)
        //luna
        p.color = Color.WHITE
        c.drawCircle(950f,200f,100f,p)
        p.color = Color.BLACK
        c.drawCircle(975f,235f,75f,p)

        //montañas
        p.color = Color.GREEN
        c.drawOval(-480f,1340f,1350f,1640f,p)
        p.style = Paint.Style.STROKE
        p.color = Color.BLACK
        p.strokeWidth = 5F



        //estrellitas
        p.color = Color.YELLOW
        c.drawCircle(1000f,400f,5f,p)
        c.drawCircle(1000f,200f,5f,p)
        c.drawCircle(900f,100f,5f,p)
        c.drawCircle(700f,400f,5f,p)
        c.drawCircle(550f,50f,5f,p)
        c.drawCircle(601f,550f,5f,p)
        c.drawCircle(900f,700f,5f,p)
        c.drawCircle(700f,900f,5f,p)
        c.drawCircle(930f,1100f,5f,p)
        c.drawCircle(650f,1200f,5f,p)

        c.drawBitmap(hijo,posXc,1200F,p)

    }
}