package com.study.lesson7

import java.util.function.Function
import java.util.stream.Stream

class ClosureEx {
    static void main(String[] args) {
        // in Java we have functional interfaces (Predicate, Consumer, Supplier, Function, ..Bi-..)
        Function<Integer, Integer> func = value -> value + value
        def result = func.apply(5)
        println result   // 10

        // in Groovy we have Closure (one for all needs)
        Closure closure = value -> value + value
        def result2 = closure.call(5)
//        def result2 = closure(5)
        
        println result2  // 10


        println '''
           -----------------------------------------
           ------  using with stream  --------------
           -----------------------------------------
        '''
        Stream.of(1, 2, 3, 4)
//                .map(func)    // instead of using java functional interfaces we can use groovy closure
                .map(closure)   // also work with groovy closure
                .map(String::valueOf)
                .forEach(System.out::println)

        /*
            2
            4
            6
            8
         */

        println '''
           -----------------------------------------
           --  using closure in different ways  ----
           -----------------------------------------
        '''
//        Closure closure2 = value -> value + value             (1)      

//        Closure closure2 = { value -> value + value }         (2)  

//        Closure closure2 = { value ->                         (3)
//            println value
//            value + value                   // last row is returned
//        }

        // if there is only one parameter we can use   it                     
        Closure closure3 = { it ->                           // (4)                            
            println it
            it + it                            // last row is returned
        }

//        def result3 = closure3.call(5)
        def result3 = closure3(5)
        println "result3 = " + result3  // 10

        println '''
           -----------------------------------------
           --  closure without parameters  ----
           -----------------------------------------
        '''
//        Closure closure4 = { -> "hello" }
        Closure closure4 = { "hello" }
        println closure4                     // com.study.lesson7.ClosureEx$_main_closure4@24aed80c


        println '''
           -----------------------------------------
           - closure as a parameter in the methods -
           -----------------------------------------
        '''
        int x = 10
//        check(x > 0, { println x })      // 10
        
        // if we pass the closure as last parameter to our function than we can use it like this
        check(x > 0) {
            println x
        }


    }

    static def check(boolean condition, Closure closure) {
        if (condition) {
            closure()
        }
    }
}

/*
   https://groovy-lang.org/closures.html#_syntax

   
   1. What Is a Closure?
       A closure is an anonymous block of code. In Groovy, it is an instance of the Closure class. Closures can take 0 
       or more parameters and always return a value.
       
       Furthermore, we can assign a closure to a variable or pass it as a parameter to a method. Therefore, a closure 
       provides functionality for delayed execution.
       
       
       
   2. Closure Declaration
       A Groovy Closure contains parameters, the arrow ->, and the code to execute. Parameters are optional and, when 
       provided, are comma-separated.
       
       2.1. Basic Declaration
               def printWelcome = {
                   println "Welcome to Closures!"
               }
       
           Now, let's write a quick example of a unary closure:
               def print = { name ->
                   println name 
               }
           Here, the closure print takes one parameter — name — and prints it when invoked.



           Since the definition of a closure looks similar to a method, let's compare them:
               def formatToLowerCase(name) {
                   return name.toLowerCase()
               }
               def formatToLowerCaseClosure = { name ->
                   return name.toLowerCase()
               }
           
       
       
       2.2 Execution
               We can execute a closure in two ways — we can invoke it like it were any other method, or we can use the 
               call method.    
                   print("Hello! Closure")
                   formatToLowerCaseClosure("Hello! Closure")
               
               And executing with the call method:
                   print.call("Hello! Closure") 
                   formatToLowerCaseClosure.call("Hello! Closure")
               
   
   
   3. Parameters
       The parameters of Groovy closures are similar to those of regular methods.       
       
       
       3.1 Implicit Parameter
              We can define a unary closure without a parameter because when parameters are not defined, Groovy assumes an implicit parameter named “it”:
           
                   def greet = {
                       return "Hello! ${it}"
                   }
                   assert greet("Alex") == "Hello! Alex"
                   
       3.2. Multiple Parameters
           Here's a closure that takes two parameters and returns the result of multiplying them:

               def multiply = { x, y -> 
                   return x*y 
               }
               assert multiply(2, 4) == 8
       
       3.3. Parameter Types
           In the examples so far, there has been no type provided with our parameters. We can also set the type of closure parameters. For instance, let's rewrite the multiply method to consider other operations:
           
               def calculate = {int x, int y, String operation ->
                   def result = 0    
                   switch(operation) {
                       case "ADD":
                           result = x+y
                           break
                       case "SUB":
                           result = x-y
                           break
                       case "MUL":
                           result = x*y
                           break
                       case "DIV":
                           result = x/y
                           break
                   }
                   return result
               }
               assert calculate(12, 4, "ADD") == 16
               assert calculate(43, 8, "DIV") == 5.375
               

       3.4. Varargs
           We can declare a variable number of arguments in closures, similar to regular methods. For example:
               
               def addAll = { int... args ->
                   return args.sum()
               }
               assert addAll(12, 10, 14) == 36
               

       4. A Closure as an Argument
           We can pass a Closure as an argument to a regular Groovy method. This allows the method to call our closure 
           to complete its task, allowing us to customize its behavior.
                       
       
       5. Nested Closures
           We can declare and invoke closures inside a closure.
       
       
       6. Lazy Evaluation of Strings
           Groovy Strings are usually evaluated and interpolated at the time of creation. For instance:
           
               def name = "Samwell"
               def welcomeMsg = "Welcome! $name"
                       
               assert welcomeMsg == "Welcome! Samwell"
               
           Even if we modify the value of the name variable, the welcomeMsg is not going to change:
           
               name = "Tarly"
               assert welcomeMsg != "Welcome! Tarly"
               
           Closure interpolation allows us to provide lazy evaluation of Strings, recalculated from the current values 
           around them. For example:
           
               def fullName = "Tarly Samson"
               def greetStr = "Hello! ${-> fullName}"
                       
               assert greetStr == "Hello! Tarly Samson"
               
           Only this time, changing the variable affects the interpolated string's value as well:
           
               fullName = "Jon Smith"
               assert greetStr == "Hello! Jon Smith"     
               
               
       7. Closures in Collections
           Groovy Collections use closures in many of their APIs. For example, let's define a list of items and print 
           them using the unary closure each, which has an implicit parameter:                  
               def list = [10, 11, 12, 13, 14, true, false, "BUNTHER"]
               
               list.each {
                   println it
               }
               
               assert [13, 14] == list.findAll{ it instanceof Integer && it >= 13 }
               
               
               
       8. Closures vs Methods
           So far, we've seen the syntax, execution, and parameters of closures, which are fairly similar to methods. 
           Let's now compare closures with methods.
           
           Unlike a regular Groovy method:
           
               > We can pass a Closure as an argument to a method
               > Unary closures can use the implicit it parameter
               > We can assign a Closure to a variable and execute it later, either as a method or with call
               > Groovy determines the return type of the closures at runtime
               > We can declare and invoke closures inside a closure
               > Closures always return a value
               
           Hence, closures have benefits over regular methods and are a powerful feature of Groovy.
       
*/