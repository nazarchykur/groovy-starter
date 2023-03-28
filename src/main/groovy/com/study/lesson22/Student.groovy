package com.study.lesson22


import groovy.transform.Canonical
import groovy.transform.builder.Builder

// all methods by default are public
// all fields by default are private

// The @TupleConstructor annotation instructs the compiler to execute an AST transformation which adds the necessary 
// constructor method to your class.
// A tuple constructor is created with a parameter for each property

@Canonical
// ToString, TupleConstructor, EqualsAndHashCode
@Builder
class Student {
    String firstName
    String lastName
    Integer age
}
