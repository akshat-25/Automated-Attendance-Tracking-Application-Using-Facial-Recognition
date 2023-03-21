package com.example.attendancetracker

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.i
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_list.*
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.BufferedReader

class ListActivity : AppCompatActivity() {

    private lateinit var date : String
    lateinit var contentListView : TextView
    lateinit var selectedDate : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        setSupportActionBar(appBarListActivity)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            appBarListActivity.setNavigationOnClickListener {
                finish()
            }
        }

        selectedDate = findViewById(R.id.selectedDate)
        contentListView = findViewById(R.id.contentListView)
        date = intent.getStringExtra("date selected").toString()
        selectedDate.append(date)

        loadAttendance()

    }

    private fun loadAttendance(){

        val selectedFile = "$date.csv".trim()
        val bufferReader = BufferedReader(assets.open(selectedFile).reader())
        val csvParser = CSVParser.parse(
            bufferReader,
            CSVFormat.DEFAULT
        )

        val list = mutableListOf<Student>()
        csvParser.forEach {
            it?.let{
                val students = Student(
                    studentRoll = it.get(0),
                    studentName = it.get(1),
                    studentAttend = it.get(2)
                )
                list.add(students)
            }
        }

        var count = 0
        list.forEach {

            if(count == 0){
                contentListView.append(
                    "${it.studentRoll}\t ${it.studentName}\t ${it.studentAttend}\n\n"
                )
                count += 1
            }else{
                contentListView.append(
                    "${it.studentRoll}\t\t\t ${it.studentName}\t\t\t ${it.studentAttend}\n\n"
                )
            }

        }
    }
}