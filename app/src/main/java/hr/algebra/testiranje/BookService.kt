package hr.algebra.testiranje

interface BookService {

    fun inStoct( bookId: Int ) : Boolean
    fun updateStock( bookId: Int )
    fun lend( bookId: Int, memberId: Int )
    fun returnBook( bookId: Int, memberId: Int ) : Boolean

}

class BookManager( val bookService: BookService ) {
    fun checkout( bookId: Int, memberId: Int ) {
        if( bookService.inStoct( bookId ) )
            bookService.lend( bookId, memberId )
        else
            throw IllegalStateException( "Book is not available" )
    }
    fun receive( bookId: Int, memberId: Int ) {
        if( bookService.returnBook( bookId, memberId ) )
            bookService.updateStock( bookId )
        else
            throw IllegalStateException( "Book or member unknown" )
    }
}