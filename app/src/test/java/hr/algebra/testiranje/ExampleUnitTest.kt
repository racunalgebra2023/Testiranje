package hr.algebra.testiranje

import hr.algebra.testiranje.utils.*
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val result = add( 3, 17 )
        //assertEquals( result, 20 )
        assertTrue( result==20 )
    }

    @Test
    fun subtraction_isCorrect() {
        val result = subtract( 20, 17 )
        assertTrue( result==3 )
    }

    @Test
    fun division_isCorrect() {
        val result = divide( 20, 10 )
        assertTrue( result==2 )
    }

    @Test
    fun multiplication_isCorrect() {
        val result = multiply( 20, 10 )
        assertTrue( result==200 )
    }

    @Test
    fun gettingCorrectNumber1( ) {
        val result = getNumber( "10" )
        assertTrue( result==10 )
    }

    @Test
    fun gettingCorrectNumber2( ) {
        val result = getNumber( "15" )
        assertTrue( result==15 )
    }

    @Test
    fun gettingCorrectNumber3( ) {
        val result = getNumber( "56" )
        assertTrue( result==56 )
    }

    @Test
    fun gettingNullForEmptyString( ) {
        val result = getNumber( "" )
        assertNull( result )
    }

    @Test
    fun gettingNullForNonNumberText( ) {
        val result = getNumber( "Danas je cetvrtak" )
        assertNull( result )
    }
}