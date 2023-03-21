package com.example.attendancetracker

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.nav_header.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class Home : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle
    lateinit var selectedDate : TextView
    lateinit var dateBtn : Button
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        firebaseAuth = FirebaseAuth.getInstance()

        dateBtn = findViewById(R.id.dateBtn)

        dateBtn.setOnClickListener {
            showDatePicker()
        }
        setUpViews()



    }

    private fun setUpViews(){
        setUpDrawerLayout()
    }

    private fun showDatePicker(){

        val cal = Calendar.getInstance()
        val mYear = cal.get(Calendar.YEAR)
        val mMonth = cal.get(Calendar.MONTH)
        val mDay = cal.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this,R.style.DialogTheme,
            DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDayOfMonth ->

                val date = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
                //selectedDate?.text = date
                val intent = Intent(this,ListActivity::class.java)
                startActivity(intent)

                //Simple Date Format is used to arrange the date in form of a particular format
                /*val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)

                val theDate = sdf.parse(date)
                theDate?.let{       //for null safety

                    //val selectedDateInMinutes = theDate.time / 60000
                    *//*Here in the above statement we are using time property to get the selected date time
                    milliseconds and this property is same as using getTime() function in Kotlin
                    Now to convert in minutes from milliseconds we have to first divide by 1000 then we have to divide by 60
                    so we divide by 60000
                     *//*

                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                    currentDate?.let{   // for null safety
                        val currentDateInMinutes = currentDate.time/60000
                        val difference = currentDateInMinutes - selectedDateInMinutes

                        selectDateMinutes?.text = difference.toString()
                    }

                }*/
            },
            mYear,
            mMonth,
            mDay
        )

        dpd.datePicker.maxDate = System.currentTimeMillis()
        dpd.show()
    }

    private fun setUpDrawerLayout(){
        //you can directly use the id without using R.id.id_name
        setSupportActionBar(appBarHome)
        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener {

            it.isChecked = true
            drawerLayout.closeDrawer(GravityCompat.START)
            when(it.itemId){

                R.id.home->{
                    val intent = Intent(applicationContext,Home::class.java)
                    startActivity(intent)
                }
                R.id.aboutus -> replaceFragment(AboutFragment())
                R.id.logout -> {
                    FirebaseAuth.getInstance().signOut()
                    val intent = Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                }
                R.id.feedback -> replaceFragment(FeedbackFragment())
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment: Fragment){

        val rootView : ConstraintLayout = findViewById(R.id.rootView)
        rootView.removeAllViews()
        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        finishAffinity()
    }

}