package com.study.lesson21

class MissingMethodOrPropertyRunner {
    static void main(String[] args) {
        
        def student = new Student()

        // if we call some method or property on class that does not have this method we will get an Exception

        // Exception in thread "main" groovy.lang.MissingMethodException: No signature of method: com.study.lesson18.Student.test()
        // student.test()

        // Exception in thread "main" groovy.lang.MissingPropertyException: No such property: abc
        // println student.abc
        
        
        /*
            let's add methods to our class Student
                    def missingMethod(String name, Object arguments) {
                        println "missing method $name is invoked with args: $arguments"
                    }
                
                    def propertyMissing(String name) {
                        println "missing property $name"
                    }
         */

        student.test()         // missing method test is invoked with args: []
        println student.abc    // missing property abc
    }
}
