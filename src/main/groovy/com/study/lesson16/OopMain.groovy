package com.study.lesson16

class OopMain {
    static void main(String[] args) {

        def student2 = new Student(firstName: "Donnie", lastName: "Turtles", age: 25, id: 101)
        println(student2) // com.study.lesson16.Student(Donnie, Turtles, 25, 101)

        Student student4 = new Student(firstName: "Raphael", lastName: "Turtles", age: 24, id: 102)
        println student4  // com.study.lesson16.Student(Raphael, Turtles, 24, 102)

        def ids = [student2, student4]*.id
        println ids    // [101, 102]

        println """
        -----------------------------------------------
        ---------  properties of the class  -----------
        -----------------------------------------------
        """
        student2.properties.each {println it}
        /*
            firstName=Donnie
            lastName=Turtles
            age=25
            com_study_lesson16_WithId__id=101                   <= field from trait
            class=class com.study.lesson16.Student              <= class itself
            id=101
         */
    }
}
