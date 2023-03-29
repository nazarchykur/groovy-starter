package com.study.lesson23

class Closure2 {
    static void main(String[] args) {
        
        /*
            https://groovy-lang.org/closures.html#closure-owner
            
            To understand the concept of delegate, we must first explain the meaning of this inside a closure. 
            A closure actually defines 3 distinct things:
                > this corresponds to the enclosing class where the closure is defined

                > owner corresponds to the enclosing object where the closure is defined, which may be either a class 
                    or a closure
                
                > delegate corresponds to a third party object where methods calls or properties are resolved whenever 
                    the receiver of the message is not defined
        
         */
        
        Closure closure = {
            firstName = "Donnie"
        }
        
        println closure.thisObject    // class com.study.lesson23.Closure2
        println closure.owner         // class com.study.lesson23.Closure2
        println closure.delegate      // class com.study.lesson23.Closure2

        def student = new Student("Leo", "Turtles", 30)
        println student  // com.study.lesson23.Student(Leo, Turtles, 30)
        
//        closure.delegate = student
//        closure.resolveStrategy = Closure.DELEGATE_FIRST  // OWNER_ONLY, DELEGATE_ONLY, TO_SELF ...
//        closure()
        
        // instead of using those 3 line of code above
//        student.with closure
        
        // or we can define a closure right here
        student.with {firstName = "Raphael"}
        
        
        println student  // com.study.lesson23.Student(Donnie, Turtles, 30)
                         // com.study.lesson23.Student(Raphael, Turtles, 30)
    }
}
