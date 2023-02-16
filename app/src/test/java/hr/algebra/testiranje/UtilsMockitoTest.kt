package hr.algebra.testiranje

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test

class UtilsMockitoTest {

    private lateinit var bookService: BookService

    @Before
    fun setup( ) {
        bookService = mock( )
    }

    @Test
    fun bookIsSuccessfulyLent( ) {
        whenever( bookService.inStoct( any( ) ) ).thenReturn( true )

        val manager = BookManager( bookService )
        manager.checkout( 100, 1 )
        verify( bookService ).lend( 100, 1 )
    }

    @Test( expected = IllegalStateException::class )
    fun exceptionWhenBookNotAvailable( ) {
        whenever( bookService.inStoct( any( ) ) ).thenReturn( false )

        val manager = BookManager( bookService )
        manager.checkout( 100, 1 )
    }
}