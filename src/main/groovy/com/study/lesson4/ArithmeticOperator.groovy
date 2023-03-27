package com.study.lesson4

class ArithmeticOperator {
    static void main(String[] args) {
        /*
            Arithmetic operator
            
            Arithmetic operators are the basic mathematical operators, which are used to perform addition, subtraction, 
            multiplication, division, Remainder and Power.
         */
        
        int x = 10
        int y = 5
        int z
        z = x + y
        println "Addition = " + z           // Addition = 15
        
        z = x - y
        println "Subtraction = " + z        // Subtraction = 5
        
        z = x * y
        println "Multiplication = " + z     // Multiplication = 50
        
        z = x / y
        println "Division = " + z           // Division = 2
        
        z = x % y
        println "Remainder  = " + z         // Remainder  = 0
        
        z = x**y
        println "Power = " + z              // Power = 100000


        assert  1  + 2 == 3
        assert  4  - 3 == 1
        assert  3  * 5 == 15
        assert  3  / 2 == 1.5      // return correct double result (not the same result as in java )
        assert 5.intdiv(2) == 2    // this func return int of division
        assert 10  % 3 == 1
        assert  2 ** 3 == 8

        def res1 = (int) (3 / 2)        // 1     casting also works
        def res2 = (3 / 2) as Integer   // 1     style that we can use in Groovy
    }
}

/*
 1.1. Normal arithmetic operators
    The following binary arithmetic operators are available in Groovy:
    
    +----------+----------------+-----------------------------------------------------------------------------------------------------+
    | Operator | Purpose        | Remarks                                                                                             |
    +----------+----------------+-----------------------------------------------------------------------------------------------------+
    |    +     | addition       |                                                                                                     |
    +----------+----------------+-----------------------------------------------------------------------------------------------------+
    |    -     | subtraction    |                                                                                                     |
    +----------+----------------+-----------------------------------------------------------------------------------------------------+
    |    *     | multiplication |                                                                                                     |
    +----------+----------------+-----------------------------------------------------------------------------------------------------+
    |    /     | division       | Use intdiv() for integer division, and see the section about integer division for more              |                      
    |          |                | information on the return type of the division.                                                     | 
    +----------+----------------+-----------------------------------------------------------------------------------------------------+
    |    %     | remainder      |                                                                                                     |
    +----------+----------------+-----------------------------------------------------------------------------------------------------+
    |    **    | power          | See the section about the power operation for more information on the return type of the operation. |
    +----------+----------------+-----------------------------------------------------------------------------------------------------+
    
 */