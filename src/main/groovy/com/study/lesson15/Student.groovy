package com.study.lesson15

import groovy.transform.ToString
import groovy.transform.TupleConstructor

// all methods by default are public
// all fields by default are private

// The @TupleConstructor annotation instructs the compiler to execute an AST transformation which adds the necessary 
// constructor method to your class.
// A tuple constructor is created with a parameter for each property

@ToString           // similar to lombok
@TupleConstructor   // create all necessary constructors
class Student {
    String firstName
    String lastName
    Integer age
}
