import groovy.transform.TailRecursive

@TailRecursive
def fact( BigInteger n, accu = 1G) {
   if ( n < 2 ) accu
   else fact( n - 1, n * accu )
}

println fact( 10000 )
assert fact(1000) > 10e2566
