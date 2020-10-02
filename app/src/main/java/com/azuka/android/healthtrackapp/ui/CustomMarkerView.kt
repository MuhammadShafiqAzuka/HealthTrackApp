package com.azuka.android.healthtrackapp.ui

import android.annotation.SuppressLint
import android.content.Context
import com.azuka.android.healthtrackapp.db.Run
import com.azuka.android.healthtrackapp.other.TrackingUtility
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import kotlinx.android.synthetic.main.marker_view.view.*
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("ViewConstructor")
class CustomMarkerView(
    val runs: List<Run>,
    c: Context,
    layoutId: Int
) : MarkerView(c, layoutId) {

    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        if (e == null) {
            return
        }
        val curRunId = e.x.toInt()
        val run = runs[curRunId]
        val calendar = Calendar.getInstance().apply {
            timeInMillis = run.timestamp
        }
        val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
        tvDate.text = dateFormat.format(calendar.time)

        "${run.avg_speed}km/h".also {
            tvAvgSpeed.text = it
        }
        "${run.distanceMeter / 1000f}km".also {
            tvDistance.text = it
        }
        tvDuration.text =
            TrackingUtility.getFormattedStopWatchTime(
                run.timeInMillis
            )
        "${run.calories_burn}kcal".also {
            tvCaloriesBurned.text = it
        }
    }

    override fun getOffset(): MPPointF {
        return MPPointF(-width / 2f, -height.toFloat())
    }
}