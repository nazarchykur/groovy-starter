package com.study.lesson8

class Conditions {
    static void main(String[] args) {
        /*
            boolean           is true
            Collection/Map    is not empty
            Matcher           has match
            String/GString    is not empty
            Number/Char       != 0
            reference         != null
            
            
            asBoolean         we need to add some logic to this method in our class
         */
        
        int x = 10
        boolean result = x > 0
        if (result) {
            println x
        }

        if (x) {
            println x
        }

        
        
        def person1 = new Person(9)

        // так як ми зазначили метод  asBoolean id > 10, то тепер можемо передавати до  if condition
        if (person1) { 
            println person1.getId()     // отже сюди ми не зайдемо, бо id = 9
        }

        def person2 = new Person(12)
        if (person2) {
            println person2.getId()   // тепер зайдемо і виведе   12
        }

        
        
        // check if object is not null
//        if (person2 != null) {
//            person2.getId()
//        }
        
        // the same as above
        person1?.getId()


        //--------------------------------------------------------------
        //----------    if else  / ternary operator    -----------------
        //--------------------------------------------------------------
        
        // all these options are the same but the last one is the shortest and convenient

        // (1)
        if (x != null) {
            println x
        } else {
            println 1
        }

        // (2)
        if (x) {
            println x
        } else {
            println 1
        }

//        def result3 = x != null ? x : 1    // (3)
//        def result3 = x ? x : 1            // (4)
        def result3 = x ?: 1         // (5)
        println result3
        
    }
}
