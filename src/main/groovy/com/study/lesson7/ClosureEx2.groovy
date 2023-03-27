package com.study.lesson7

class ClosureEx2 {
    static void main(String[] args) {
        def clos = { println "Hello World" };
        clos.call(); // Hello World

        def clos2 = { param -> println "Hello ${param}" };
        clos2.call("World"); // Hello World

        println """
            ---------------------------------
            Formal parameters in closures
        """

        def clos3 = { println "Hello ${it}" };
//        clos3.call("Mr.Groovy"); // Hello Mr.Groovy
//        clos3() // Hello null
        clos3("Mr.Groovy") // Hello Mr.Groovy

        println """
            ---------------------------------
            Closure with zero arguments
        """
        // Interestingly, if you want to define a closure that doesn't accept any arguments, use -> after the open brace { as follows.
        def greeting = { ->
            println "Hello"
        }
        greeting() // Hello

        println """
            ---------------------------------
            Closures and Variables
        """
        def str1 = "Hello";
        def clos4 = { param -> println "${str1} ${param}" }
        clos4("World"); // Hello World

        // We are now changing the value of the String str1 which is referenced in the closure
        str1 = "Welcome";
        clos4("World"); // Welcome World

        def greet = { friend ->
            println "Hello $friend"
        }

        greet('Kumar') // Hello Kumar
        greet() // Hello null

        println """
            ---------------------------------
            Closures in Collections and String
        """
        def lst = [11, 12, 13, 14];
        lst.each { println it }
        /*
             11
             12
             13
             14
         */

        println """
            ---------------------------------
            Using Closures with Maps
        """
        def mp = ["TopicName": "Maps", "TopicDescription": "Methods in Maps"]
        mp.each { println it }
        println "----"
        mp.each { println "${it.key} maps to: ${it.value}" }

        /*
            TopicName=Maps
            TopicDescription=Methods in Maps
            ----
            TopicName maps to: Maps
            TopicDescription maps to: Methods in Maps
         */

        println "====="
        def list2 = [1, 2, 3, 4];
        list2.each { println it }
        println("The list will only display those numbers which are divisible by 2")
        lst.each { num -> if (num % 2 == 0) println num }
        /*
            1
            2
            3
            4
            The list will only display those numbers which are divisible by 2
            12
            14
         */
    }
}
