package com.study.lesson4

class ArithmeticOperationsWithFunctions {
    static void main(String[] args) {
        /*
            In groovy, we also have some functions which are used to perform Arithmetic operations like plus, minus, 
            intdiv and power. The use of these functions are shown in the example which is given below.
         */
        
        int a = 10
        int b = 5
        int c
        
        c = a.plus(b)
        println "plus = " + c      // plus = 15
        
        c = a.minus(b)
        println "minus = " + c     // minus = 5
        
        c = a.intdiv(b)
        println "intdiv = " + c    // intdiv = 2
        
        c = a.power(b)
        println "Power = " + c     // Power = 100000
        
    }
}
