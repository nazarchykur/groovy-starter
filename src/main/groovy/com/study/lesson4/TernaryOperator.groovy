package com.study.lesson4

class TernaryOperator {
    static void main(String[] args) {
        /*
            Ternary operator
            
            In groovy, Ternary Operator is the shortcut of if/else
         */

        String answer
        String s = 'javatpoint'
        answer = (s != null && s.length() > 0) ? 'Found' : 'Not found'

        println(answer)  // Found


        /*
            Elvis operator
            
            In groovy, Elvis operator is a shorthand property of the ternary operator. It only returns when a value is true.
         */

        String s2 = 'javatpoint'
        println s2 ? s2 : 'Not Found'     // javatpoint
        println s2 ?: 'Not Found'         // javatpoint
    }
}
