package com.study.lesson16

import groovy.transform.ToString
import groovy.transform.TupleConstructor

// all methods by default are public
// all fields by default are private

// The @TupleConstructor annotation instructs the compiler to execute an AST transformation which adds the necessary 
// constructor method to your class.
// A tuple constructor is created with a parameter for each property

@ToString           // similar to lombok
@TupleConstructor   // create all necessary constructors
class Student implements WithId {
    String firstName
    String lastName
    Integer age
}
