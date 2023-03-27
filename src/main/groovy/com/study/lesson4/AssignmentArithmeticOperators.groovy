package com.study.lesson4

class AssignmentArithmeticOperators {
    static void main(String[] args) {
        /*
            Assignment arithmetic operators
            In groovy, assignment arithmetic operators are used to assign a new value to the variable.
            
            The binary arithmetic operators we have seen above are also available in an assignment form:

                +=
                -=
                *=
                /=
                %=
                **=
         */
        
        int a = 10
        a+=3
        println "a+=3 ------> " + a    // a+=3 ------> 13

        int b = 10
        b-=3
        println "b-=3 ------> " + b    // b-=3 ------> 7

        int c = 10
        c*=3
        println "c*=3 ------> " + c    // c*=3 ------> 30

        int d = 10
        d/=3
        println "d/=3 ------> " + d    // d/=3 ------> 3

        int e = 10
        e%=3
        println "e%=3 ------> " + e    // e%=3 ------> 1

        int f = 3
        f**=3
        println "f**=3 -----> " + f    // f**=3 -----> 27
        
    }
}
