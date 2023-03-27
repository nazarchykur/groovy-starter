package com.study.lesson4

import groovy.transform.EqualsAndHashCode

class RelationalOperators {
    static void main(String[] args) {
        /*
            Relational operators
            
            In groovy, relational operators are used to compare two objects to check whether they are the same or different 
            or if one is greater than, less than, or equal to another object.         
        
            +----------+------------------------------------+
            | Operator | Purpose                            |
            +----------+------------------------------------+
            | ==       | equal                              |
            +----------+------------------------------------+
            | !=       | different                          |
            +----------+------------------------------------+
            | <        | less than                          |
            +----------+------------------------------------+
            | <=       | less than or equal                 |
            +----------+------------------------------------+
            | >        | greater than                       |
            +----------+------------------------------------+
            | >=       | greater than or equal              |
            +----------+------------------------------------+
            | ===      | identical (Since Groovy 3.0.0)     |
            +----------+------------------------------------+
            | !==      | not identical (Since Groovy 3.0.0) |
            +----------+------------------------------------+
        
        */

        assert 1 + 2 == 3
        assert 3 != 4

        assert -2 < 3
        assert 2 <= 2
        assert 3 <= 4

        assert 5 > 1
        assert 5 >= -2
        
        
        
        /*
            Both === and !== are supported which are the same as calling the is() method, and negating a call to the 
            is() method respectively.
         */
        
        def cat = new Creature(type: 'cat')
        def copyCat = cat
        def lion = new Creature(type: 'cat')

        assert cat.equals(lion) // Java logical equality
        assert cat == lion      // Groovy shorthand operator

        assert cat.is(copyCat)  // Groovy identity
        assert cat === copyCat  // operator shorthand
        assert cat !== lion     // negated operator shorthand
        
    }
}

@EqualsAndHashCode
class Creature { String type }
