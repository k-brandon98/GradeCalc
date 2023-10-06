package com.example.gradecalc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val p1 = findViewById<EditText>(R.id.prelim1Score)
        val p2 = findViewById<EditText>(R.id.prelim2Score)
        val fin = findViewById<EditText>(R.id.finalExamScore)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener(View.OnClickListener {
            val p1Score = p1.text.toString().toDouble()
            val p2Score = p2.text.toString().toDouble()
            val finScore = fin.text.toString().toDouble()

            val courseGrade = (0.25 * p1Score) +
                    (0.25 * p2Score) + (0.5 * finScore)

            val letter = letterGrade(courseGrade)

            val display = findViewById<TextView>(R.id.displayGrade)
            display.text = "$courseGrade ($letter)"
        })

    }

    private fun letterGrade (score : Double) : String {
        return if (score >= 90) {
            "A"
        } else if (score >= 80) {
            "B"
        } else if (score >= 70) {
            "C"
        } else if (score >= 60) {
            "D"
        } else {
            "F"
        }
    }
}