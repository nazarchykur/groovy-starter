package com.study.lesson10

class Loops {
    static void main(String[] args) {
        // while / for

        def list = [1, 2, 3, 4]
        println "use java for from 0 to list.size()  ==> [)"
        for (int i = 0; i < list.size(); i++) {
            println i
        }

        println "use groovy for from 0 to list.size()  ==> [)"
        for (i in 0..<list.size()) {
            println i
        }

        println "use java for from 0 to list.size()  ==> []"
        for (int i = 0; i <= list.size(); i++) {
            println i
        }
        println "use groovy for from 0 to list.size()  ==> []"
        for (i in 0..list.size()) {
            println i
        }

        println """
            --------------------------------------------------
            -------------      forEach      -----------------
            --------------------------------------------------
        """


        // like in java
//        for (Integer value : list) {
//            println value
//        }

        // but better to use groovy example
        for (value in list) {
            println value
        }

        println """
          --------------------------------------------------
          ----------      using closure      ---------------
          --------------------------------------------------
        """
        println "using upto() from 0 to list.size()  ==> []"
        // 0.upto(list.size()) { println it }                        // the     
        // 0.upto(list.size()) { it -> println it }                  // same  
        0.upto(list.size()) { value -> println value }       // result

        println "using downto() from list.size() to 0  ==> []"
        list.size().downto(0){println it}

        println "using times() from 0 to list.size() ==> [)"
        list.size().times(){println it}

        println "using step() to iterate to some value and with some step "
        0.step(5 , 2) { println it }  
    }
}
