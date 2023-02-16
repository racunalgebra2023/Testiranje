package hr.algebra.testiranje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import hr.algebra.testiranje.utils.*

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

        initViews( )
        setupListeners( )
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

    private fun setupListeners( ) {

        bPlus.setOnClickListener { doTheJob( ::add,       (it as Button).text.toString( ) ) }
        bMinus.setOnClickListener { doTheJob( ::subtract, (it as Button).text.toString( ) ) }
        bPuta.setOnClickListener { doTheJob( ::multiply,  (it as Button).text.toString( ) ) }
        bKroz.setOnClickListener { doTheJob( ::divide,    (it as Button).text.toString( ) ) }
/*
        bPlus.setOnClickListener {
            val prviBroj  = getNumber( etPrvi.text.toString( ) )
            val drugiBroj = getNumber( etDrugi.text.toString( ) )

            if( validateInput( prviBroj, drugiBroj ) ) {
                val rezultat = add( prviBroj!!, drugiBroj!! )
                tvRez.text = "$prviBroj + $drugiBroj = $rezultat"
                clearFields( )
            }
        }
        bMinus.setOnClickListener {
            val prviBroj  = getNumber( etPrvi.text.toString( ) )
            val drugiBroj = getNumber( etDrugi.text.toString( ) )

            if( validateInput( prviBroj, drugiBroj ) ) {
                val rezultat = subtract( prviBroj!!, drugiBroj!! )
                tvRez.text = "$prviBroj - $drugiBroj = $rezultat"
                clearFields( )
            }
        }
        bPuta.setOnClickListener {
            val prviBroj  = getNumber( etPrvi.text.toString( ) )
            val drugiBroj = getNumber( etDrugi.text.toString( ) )

            if( validateInput( prviBroj, drugiBroj ) ) {
                val rezultat = multiply( prviBroj!!, drugiBroj!! )
                tvRez.text = "$prviBroj * $drugiBroj = $rezultat"
                clearFields( )
            }
        }
        bKroz.setOnClickListener {
            val prviBroj  = getNumber( etPrvi.text.toString( ) )
            val drugiBroj = getNumber( etDrugi.text.toString( ) )

            if( validateInput( prviBroj, drugiBroj ) ) {
                val rezultat = divide( prviBroj!!, drugiBroj!! )
                tvRez.text = "$prviBroj / $drugiBroj = $rezultat"
                clearFields( )
            }
        }
*/
    }

    private fun validateInput( br1 : Int?, br2 : Int? ) : Boolean {
        if( br1==null )
            etPrvi.error = "Missing first number"
        if( br2==null )
            etDrugi.error = "Missing second number"
        if( br1==null||br2==null ) {
            tvRez.text = ""
            return false
        }
        return true
    }

    private fun clearFields( ) {
        etPrvi.setText( "" )
        etDrugi.setText( "" )
    }


    private fun doTheJob( f : (Int,Int)->Int, operacija : String ) {
        val prviBroj  = getNumber( etPrvi.text.toString( ) )
        val drugiBroj = getNumber( etDrugi.text.toString( ) )

        if( validateInput( prviBroj, drugiBroj ) ) {
            val rezultat = f( prviBroj!!, drugiBroj!! )
            tvRez.text = "$prviBroj $operacija $drugiBroj = $rezultat"
            clearFields( )
        }
    }

}