package com.study.lesson15

class OopMain {
    static void main(String[] args) {
        def student = new Student()

        student.firstName = "Leo"   // setFirstName
        println student.firstName   // getFirstName

        println student['firstName']
        println student.'firstName'
        println student.@firstName   // get directly field without using getters ot setters   (!!!  better to avoid it)

        
        // we don't define any constructor but we can initialize all fields using map with key: value pairs 
        def student2 = new Student(firstName: "Donnie", lastName: "Turtles", age: 25)
        println(student2) // com.study.lesson15.Student(Donnie, Turtles, 25)
        
        // now lets add needed constructor to our class and use it like this
        Student student3 = ["Mickey", "Turtles", 22]
        println student3  // com.study.lesson15.Student(Mickey, Turtles, 22)

        Student student4 = new Student(firstName: "Raphael", lastName: "Turtles", age: 24)
        println student4  // com.study.lesson15.Student(Raphael, Turtles, 24)

        Student student5 = new Student("San", "Rat", 80)
        println student5  // com.study.lesson15.Student(San, Rat, 80)


        def names = [student2, student3, student4]*.firstName
        println names
        
        assert [student2, student3, student4].collect {it.firstName} == ["Donnie", "Mickey", "Raphael"]
        assert [student2, student3, student4]*.firstName == ["Donnie", "Mickey", "Raphael"]

    }
}
