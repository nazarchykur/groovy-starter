package com.study.lesson13

class Range {
    static void main(String[] args) {
        // https://groovy-lang.org/operators.html#_range_operator
        // Range operator

        def range = 0..5                       // a simple range of integers, stored into a local variable
        assert range.getClass() == IntRange
        assert range.collect() == [0, 1, 2, 3, 4, 5]    // an IntRange, with inclusive bounds
        assert (0..5).collect() == [0, 1, 2, 3, 4, 5]   // an IntRange, with inclusive bounds
        assert (0..<5).collect() == [0, 1, 2, 3, 4]     // an IntRange, with exclusive upper bound
        assert (0<..5).collect() == [1, 2, 3, 4, 5]     // an IntRange, with exclusive lower bound
        assert (0<..<5).collect() == [1, 2, 3, 4]       // an IntRange, with exclusive lower and upper bounds
        
        assert (0..5) instanceof List                   // a groovy.lang.Range implements the List interface
        assert (0..5).size() == 6                       // meaning that you can call the size method on it


        
        // Ranges implementation is lightweight, meaning that only the lower and upper bounds are stored. You can create 
        // a range from any Comparable object that has next() and previous() methods to determine the next / previous 
        // item in the range. For example, you can create a range of characters this way:

        assert ('a'..'d').collect() == ['a','b','c','d']



        def rang2 = 1..5
        assert rang2.get(2) == 3
        assert !rang2.contains(8)
        
        rang2.each { println it }
        /*
            1
            2
            3
            4
            5
         */
        
        println """
        ----------------------------------------------
        --------  working with enum in range  --------
        ----------------------------------------------
        """
        (WeekDay.MO..WeekDay.FR).each {println it}
        /*
            MO
            TU
            WE
            TH
            FR
         */
        
        println "iterate in backward"
        (WeekDay.WE..WeekDay.MO).each {println it}
        /*
            WE
            TU
            MO
         */
        
    }
}
