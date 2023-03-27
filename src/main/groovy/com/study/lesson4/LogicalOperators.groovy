package com.study.lesson4

class LogicalOperators {
    static void main(String[] args) {
        /*
            Logical operators
            
            In groovy, there are 3 logical operators for Boolean expression, and these operators are 
                &&: logical "and"
                ||: logical "or"
                !:  logical "not"
                
                
            Note: In groovy, logical "not" is having a higher priority as compared to the logical "and".   
            Note: In groovy, logical "and" is having a higher priority as compared to the logical "or". 
            
            
            In groovy, "not" operator is used invert the result of the Boolean expression.
         */

        boolean c
        c = true && true
        println "Logical AND operator = " + c    // Logical AND operator = true
        c = true || false
        println "Logical OR operator = " + c     // Logical OR operator = true
        c = !false
        println "Logical NOT operator = " + c    // Logical NOT operator = true


        assert (!false && false) == false
        println("!false && false == " + (!false && false))

        assert true || true && false
        println("true || true && false == " + (true || true && false ))

    }
}
