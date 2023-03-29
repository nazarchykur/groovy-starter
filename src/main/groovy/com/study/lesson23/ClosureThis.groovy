package com.study.lesson23

class ClosureThis {
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
}

class Enclosing {
    static void main(String[] args) {
        // a closure is defined inside the Enclosing class, and returns getThisObject
        // calling the closure will return the instance of Enclosing where the closure is defined
//        def whatIsThisObject = { getThisObject() }           
        def whatIsThisObject = { thisObject }

        println whatIsThisObject()  // class com.study.lesson23.Enclosing
        println this                // class com.study.lesson23.Enclosing

        assert whatIsThisObject() == this

        // in general, you will just want to use the shortcut this notation and it returns exactly the same object
        def whatIsThis = { this }
        assert whatIsThis() == this
    }
}

class EnclosedInInnerClass {
    class Inner {
        Closure cl = { this }    // if the closure is defined in a inner class
    }

    void run() {
        def inner = new Inner()
        assert inner.cl() == inner  // this in the closure will return the inner class, not the top-level one
    }

    static void main(String[] args) {
        new EnclosedInInnerClass().run()
    }
}

class NestedClosures {
    // in case of nested closures, like here cl being defined inside the scope of nestedClosures
    // then this corresponds to the closest outer class, not the enclosing closure!
    void run() {
        def nestedClosures = {
            def cl = { this }
            cl()
        }
        assert nestedClosures() == this
    }

    static void main(String[] args) {
        new NestedClosures().run()
    }
}

class Person {
    String name
    int age

    String toString() { "$name is $age years old" }

    String dump() {
        def cl = {
            String msg = this.toString()
            println msg
            msg
        }
        cl()
    }
}

class PersonMain {
    static void main(String[] args) {
        // the closure calls toString on this, which will actually call the toString method on the enclosing object, 
        // that is to say the Person instance
        
        def p = new Person(name: 'Mickey', age: 25)
        assert p.dump() == 'Mickey is 25 years old'
    }
}
