package hr.algebra.testiranje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvRez   : TextView
    private lateinit var etPrvi  : EditText
    private lateinit var etDrugi : EditText
    private lateinit var bPuta   : Button
    private lateinit var bKroz   : Button
    private lateinit var bPlus   : Button
    private lateinit var bMinus  : Button

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )
    }

    private fun initViews( ) {
        tvRez =   findViewById( R.id.tvRez )
        etPrvi =  findViewById( R.id.etFirst )
        etDrugi = findViewById( R.id.etSecond )
        bPuta =   findViewById( R.id.bMnozenje )
        bKroz =   findViewById( R.id.bDijeljenje )
        bPlus =   findViewById( R.id.bZbrajanje )
        bMinus =  findViewById( R.id.bOduzimanje )
    }
}