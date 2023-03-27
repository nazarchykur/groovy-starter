package com.study.lesson4

class UnaryOperators {
    static void main(String[] args) {
        /*
            Unary operators
            
            In groovy, Unary operators require only one operator to perform the operation. Unary operators are used to 
            perform the operations such as increment/decrement, negating, and inverting the values of a Boolean.
         */
        int x = 10
        int y
        y = +x
        println "Unary plus = " + y

        y = -x
        println "Unary minus = " + y


        assert +3 == 3
        assert -4 == 0 - 4

        assert -(-1) == 1
        
        
        println("\n---------------------------------")
        println("  Post/Pre  Increment/decrement")
        println("---------------------------------\n")
        
        int a2 = 10
        int b2 = 10
        int c2

        c2 = a2++
        println "Post Increment = " + c2                      // Post Increment = 10
        println "Value of a after Post Increment = " + a2     // Value of a after Post Increment = 11

        c2 = ++a2
        println "Pre Increment = " + c2                       // Pre Increment = 12
        println "Value of a after Pre Increment = " + a2      // Value of a after Pre Increment = 12

        c2 = b2--
        println "Post decrement = " + c2                      // Post decrement = 10
        println "Value of a after Post decrement = " + b2     // Value of a after Post decrement = 9

        c2 = --b2
        println "Pre decrement = " + c2                       // Pre decrement = 8
        println "Value of a after Pre decrement = " + b2      // Value of a after Pre decrement = 8


        /*
            (1) The postfix increment will increment a after the expression has been evaluated and assigned into b
            (2) The postfix decrement will decrement c after the expression has been evaluated and assigned into d
            (3) The prefix increment will increment e before the expression is evaluated and assigned into f
            (4) The prefix decrement will decrement g before the expression is evaluated and assigned into h
        */

        def a = 2
        def b = a++ * 3

        assert a == 3 && b == 6

        def c = 3
        def d = c-- * 2

        assert c == 2 && d == 6

        def e = 1
        def f = ++e + 3

        assert e == 2 && f == 5

        def g = 4
        def h = --g + 1

        assert g == 3 && h == 4
    }
}
