package com.study.lesson22

class CategoryRunner {
    static void main(String[] args) {
        def student = new Student(firstName: "Leo", lastName: "Turtles", age: 30)
        
        // student.testStr()     // does not work because this class does not have this method
        
        
        // по факту в method "use" додають всі методи з Category класу в metaClass всіх об'єктів всередині блоку Closure 
        // після виходу з блоку Closure - видаляються з metaClass
        
        use(DefaultStudentMethods.class){
            student.testStr()                     // Leo, 30
        }
        
    }
}
