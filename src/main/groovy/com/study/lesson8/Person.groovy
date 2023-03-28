package com.study.lesson8

class Person {
    Integer id

    Person(Integer id) {
        this.id = id
    }
    
    boolean asBoolean() {
        this.id > 10
    }

    Integer getId() {
        return id
    }
}
