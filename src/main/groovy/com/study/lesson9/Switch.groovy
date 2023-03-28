package com.study.lesson9

class Switch {
    static void main(String[] args) {
        int x = 21
        // byte, short, int, char, String, enum  (the same as in Java), but in Groovy we can hae even more
        switch (x) {
            case String:            // isInstance
                println 0
                break
            case 8:                 // equals  ==  ===
                println 1
                break
            case ~/\d+/:            // pattern.matcher(21.toSting()).matches()
                println 2
                break
            case { it % 5 == 0 }:   // Closure
                println 3
                break
            case [1, 3, 9, 15]:     // list.isCase(21)  use array to check if x is match one of the field in this array
                println 4
                break
            default:
                println "none"
                break
        }

        // also work method  list.isCase(21) 
        if (x in [3, 8, 15, 21]) {
            println x              
        }
    }
}
