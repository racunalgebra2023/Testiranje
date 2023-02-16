package hr.algebra.testiranje.utils

fun getNumber( value : String ) : Int? {
    return try{
         value.toInt( )
    } catch ( e : Exception ) {
        null
    }
}

fun multiply( n1 : Int, n2 : Int ) : Int {
    return n1*n2
}

fun divide( n1 : Int, n2 : Int ) : Int {
    return n1/n2
}

fun add( n1 : Int, n2 : Int ) : Int {
    return n1+n2
}

fun subtract( n1 : Int, n2 : Int ) : Int {
    return n1-n2
}