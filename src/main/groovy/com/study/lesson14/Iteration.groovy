package com.study.lesson14

import com.study.lesson8.Person

class Iteration {
    static void main(String[] args) {
        assert [1, 4, 7, 9].any { it % 2 == 0 }
        assert [1, 4, 7, 9].find { it % 2 == 0 } == 4
        assert [1, 4, 7, 9].findAll { it % 2 != 0 } == [1, 7, 9]

        assert (2..4).collect() == [2, 3, 4]
        assert (2..4).contains(3)
        assert !(2..4).contains(9)


        def person = new Person(15)
        person.each { println it }  // com.study.lesson8.Person@3c46e67a

        assert ["asd", "fghj", "12", "345sdf", "78"].grep(~/\d+/) == ["12", "78"]  // isCase   switch, in, grep
        assert ["asd", "fghj", "12", "345sdf", "78"].grep { it.length() > 4 } == ["345sdf"] // isCase   switch, in, grep

    }
}
