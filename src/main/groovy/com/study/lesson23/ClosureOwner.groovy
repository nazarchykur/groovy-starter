package com.study.lesson23

class ClosureOwner {
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
    
    /*
        https://groovy-lang.org/closures.html#_owner_of_a_closure
            
            The owner of a closure is very similar to the definition of this in a closure with a subtle difference: it 
            will return the direct enclosing object, be it a closure or a class:
     */
}

class Enclosing2 {
    void run() {
        // a closure is defined inside the Enclosing class, and returns getOwner
        // calling the closure will return the instance of Enclosing where the closure is defined
        def whatIsOwnerMethod = { getOwner() }
        assert whatIsOwnerMethod() == this
        println whatIsOwnerMethod()
        
        //in general, you will just want to use the shortcut owner notation
        // and it returns exactly the same object
        def whatIsOwner = { owner }
        assert whatIsOwner() == this
    }

    static void main(String[] args) {
        new Enclosing2().run()
    }
}

class EnclosedInInnerClass2 {
    //	if the closure is defined in a inner class
    // owner in the closure will return the inner class, not the top-level one
    
    class Inner2 {
        Closure cl = { owner }
    }
    void run() {
        def inner = new Inner2()
        assert inner.cl() == inner
    }

    static void main(String[] args) {
        new EnclosedInInnerClass2().run()
    }
}

class NestedClosures2 {
    // but in case of nested closures, like here cl being defined inside the scope of nestedClosures
    // then owner corresponds to the enclosing closure, hence a different object from this!
    
    void run() {
        def nestedClosures = {
            def cl = { owner }
            cl()
        }
        assert nestedClosures() == nestedClosures
    }
}