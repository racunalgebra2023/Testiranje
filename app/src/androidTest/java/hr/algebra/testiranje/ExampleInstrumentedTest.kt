package hr.algebra.testiranje

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    var activityTestRule = ActivityTestRule( MainActivity::class.java )

    @Test
    fun addNumbersCorrectlyAndDisplayResult() {
        checkOperation( "6", "3", "6 + 3 = 9", R.id.bZbrajanje )
    }

    @Test
    fun subtractNumbersCorrectlyAndDisplayResult() {
        checkOperation( "6", "3", "6 - 3 = 3", R.id.bOduzimanje )
    }

    @Test
    fun multiplyNumbersCorrectlyAndDisplayResult() {
        checkOperation( "6", "3", "6 * 3 = 18", R.id.bMnozenje )
    }

    @Test
    fun divideNumbersCorrectlyAndDisplayResult() {
        checkOperation( "6", "3", "6 / 3 = 2", R.id.bDijeljenje )
    }

    private fun checkOperation( firstNumber : String, secondNumber : String,
                                result      : String, buttonId     : Int ) {
        onView( withId( R.id.etFirst ) )
            .perform( typeText( firstNumber ), closeSoftKeyboard( ) )
        onView( withId( R.id.etSecond ) )
            .perform( typeText( secondNumber ), closeSoftKeyboard( ) )
        onView( withId( buttonId ) )
            .perform( click( ) )

        onView( withId( R.id.tvRez ) )
            .check( matches( withText( result ) ) )

        thenEditTextAreCleared( )
    }

    private fun thenEditTextAreCleared( ) {
        onView( withId( R.id.etFirst ) )
            .check( matches( withText( "" ) ) )
        onView( withId( R.id.etSecond ) )
            .check( matches( withText( "" ) ) )
    }

    @Test
    fun isErrorWhenFirstValueIsMissing( ) {
        onView( withId( R.id.etFirst ) )
            .perform( typeText( "" ), closeSoftKeyboard( ) )
        onView( withId( R.id.etSecond ) )
            .perform( typeText( "6" ), closeSoftKeyboard( ) )
        onView( withId( R.id.bZbrajanje ) )
            .perform( click( ) )

        onView( withId( R.id.etFirst ) )
            .check( matches( hasErrorText( "Missing first number" ) ) )
    }

    @Test
    fun isErrorWhenSecondValueIsMissing( ) {
        onView( withId( R.id.etFirst ) )
            .perform( typeText( "6" ), closeSoftKeyboard( ) )
        onView( withId( R.id.etSecond ) )
            .perform( typeText( "" ), closeSoftKeyboard( ) )
        onView( withId( R.id.bZbrajanje ) )
            .perform( click( ) )

        onView( withId( R.id.etSecond ) )
            .check( matches( hasErrorText( "Missing second number" ) ) )
    }

    @Test
    fun isErrorWhenBothValueAreMissing( ) {
        onView( withId( R.id.etFirst ) )
            .perform( typeText( "" ), closeSoftKeyboard( ) )
        onView( withId( R.id.etSecond ) )
            .perform( typeText( "" ), closeSoftKeyboard( ) )
        onView( withId( R.id.bZbrajanje ) )
            .perform( click( ) )

        onView( withId( R.id.etFirst ) )
            .check( matches( hasErrorText( "Missing first number" ) ) )
        onView( withId( R.id.etSecond ) )
            .check( matches( hasErrorText( "Missing second number" ) ) )
    }
}