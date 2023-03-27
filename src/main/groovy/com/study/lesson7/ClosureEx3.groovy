package com.study.lesson7

class ClosureEx3 {
    static void main(String[] args) {
        // https://groovy-lang.org/closures.html#_syntax

        /* 
            1. Syntax
                1.1. Defining a closure
                    { [closureParameters -> ] statements }
                    
                    Where [closureParameters->] is an optional comma-delimited list of parameters, and statements are 0 
                    or more Groovy statements. The parameters look similar to a method parameter list, and these parameters 
                    may be typed or untyped.
                    
                    Some examples of valid closure definitions:
                    
         
                    // A closure referencing a variable named item
                        { item++ }                    
            
                    // It is possible to explicitly separate closure parameters from code by adding an arrow (->)
                        { -> item++ }                 
            
                    // A closure using an implicit parameter (it)
                        { println it }                
            
                    // An alternative version where it is an explicit parameter
                        { it -> println it }          
            
                    // In that case it is often better to use an explicit name for the parameter
                        { name -> println name }      
            
                    // A closure accepting two typed parameters
                        { String x, int y ->                         
                            println "hey ${x} the value is ${y}"
                        }
            
                    // A closure can contain multiple statements
                        { reader ->
                            def line = reader.readLine()
                            line.trim()
                        }
        
         */


        /*
            1.2. Closures as an object
                A closure is an instance of the groovy.lang.Closure class, making it assignable to a variable or a field 
                as any other variable, despite being a block of code:
         */
        // You can assign a closure to a variable, and it is an instance of groovy.lang.Closure
        def listener = { e -> println "Clicked on $e.source" }
        assert listener instanceof Closure

        // If not using def or var, use groovy.lang.Closure as the type
        Closure callback = { println 'Done!' }

        // Optionally, you can specify the return type of the closure by using the generic type of groovy.lang.Closure
        Closure<Boolean> isTextFile = {
            File it -> it.name.endsWith('.txt')
        }


        /*
            1.3. Calling a closure
                Unlike a method, a closure always returns a value when called. 
                
                A closure, as an anonymous block of code, can be called like any other method. If you define a closure 
                which takes no argument like this:
         */
        def code = { 123 }

        // Then the code inside the closure will only be executed when you call the closure, which can be done by using 
        // the variable as if it was a regular method:
        assert code() == 123

        // Alternatively, you can be explicit and use the call method:
        assert code.call() == 123

        // The principle is the same if the closure accepts arguments:

        def isOdd = { int i -> i % 2 != 0 } // define a closure which accepts an int as a parameter
        assert isOdd(3) == true                  // it can be called directly
        assert isOdd.call(2) == false            // or using the call method

        def isEven = { it % 2 == 0 }       // same goes for a closure with an implicit argument (it)
        assert isEven(3) == false                // which can be called directly using (arg)
        assert isEven.call(2) == true            // 	or using call


        /*
        2. Parameters
            2.1. Normal parameters
                Parameters of closures follow the same principle as parameters of regular methods:
                    > an optional type
                    > a name
                    > an optional default value
                
                Parameters are separated with commas:
         */
        def closureWithOneArg = { str -> str.toUpperCase() }
        assert closureWithOneArg('groovy') == 'GROOVY'

        def closureWithOneArgAndExplicitType = { String str -> str.toUpperCase() }
        assert closureWithOneArgAndExplicitType('groovy') == 'GROOVY'

        def closureWithTwoArgs = { a, b -> a + b }
        assert closureWithTwoArgs(1, 2) == 3

        def closureWithTwoArgsAndExplicitTypes = { int a, int b -> a + b }
        assert closureWithTwoArgsAndExplicitTypes(1, 2) == 3

        def closureWithTwoArgsAndOptionalTypes = { a, int b -> a + b }
        assert closureWithTwoArgsAndOptionalTypes(1, 2) == 3

        def closureWithTwoArgAndDefaultValue = { int a, int b = 2 -> a + b }
        assert closureWithTwoArgAndDefaultValue(1) == 3


        /*
            2.2. Implicit parameter
                When a closure does not explicitly define a parameter list (using ->), a closure always defines an 
                implicit parameter, named it. This means that this code:
         */
        def greeting = { "Hello, $it!" }
        assert greeting('Patrick') == 'Hello, Patrick!'

        // is strictly equivalent to this one:
        def greeting1 = { it -> "Hello, $it!" }
        assert greeting1('Patrick') == 'Hello, Patrick!'


        // If you want to declare a closure which accepts no argument and must be restricted to calls without arguments, 
        // then you must declare it with an explicit empty argument list:
        def magicNumber = { -> 42 }

        // this call will fail because the closure doesn't accept any argument
        // magicNumber(11)      <= error


        /*
            2.3. Varargs
                It is possible for a closure to declare variable arguments like any other method. Vargs methods are methods 
                that can accept a variable number of arguments if the last parameter is of variable length (or an array) like in the next examples:
         */
        // 	A closure accepting a variable number of strings as first parameter
        def concat1 = { String... args2 -> args2.join('') }
        // It may be called using any number of arguments without having to explicitly wrap them into an array
        assert concat1('abc', 'def') == 'abcdef'
        
        // 	The same behavior is directly available if the args parameter is declared as an array
        def concat2 = { String[] args2 -> args2.join('') }
        assert concat2('abc', 'def') == 'abcdef'

        // As long as the last parameter is an array or an explicit vargs type
        def multiConcat = { int n, String... args2 ->
            args2.join('') * n
        }
        assert multiConcat(2, 'abc', 'def') == 'abcdefabcdef'

        
        
        /*
            3. Delegation strategy
            
            ...
         */
    }
}
