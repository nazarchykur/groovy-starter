package com.study.lesson23

import groovy.transform.ToString

class ClosureDelegate {
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
        https://groovy-lang.org/closures.html#_delegate_of_a_closure
        
        The delegate of a closure can be accessed by using the delegate property or calling the getDelegate method. 
        It is a powerful concept for building domain specific languages in Groovy. While this and owner refer to the 
        lexical scope of a closure, the delegate is a user defined object that a closure will use. 
        By default, the delegate is set to owner
        
     */
}

class Enclosing3 {
    void run() {
        // you can get the delegate of a closure calling the getDelegate method or using the delegate property
        // both return the same object which is the enclosing class or closure
        def cl = { getDelegate() }
        def cl2 = { delegate }
        assert cl() == cl2()
        assert cl() == this

        // in particular in case of nested closures
        // delegate will correspond to the owner
        def enclosed = {
            { -> delegate }.call()
        }
        assert enclosed() == enclosed
    }

    static void main(String[] args) {
        new Enclosing3().run()
    }
}

@ToString
class Person3 {
    String firstName

    static void main(String[] args) {
        def p = new Person3(firstName: 'Raphael')
        println p

        def cl = { firstName.toUpperCase() }
        cl.delegate = p
        println p

        def result = cl()
        
        assert result == 'RAPHAEL'
    }
}