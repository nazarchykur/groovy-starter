package com.study.lesson6

import java.util.regex.Matcher
import java.util.regex.Pattern

class Regex {
    static void main(String[] args) {
        String value = "one 1 two 22 three 333"
//        String regex = "\\w+ \\d+"      // in java we must use double back slash 
        String regex = /\w+ \d+/
        
        String regex2 = /(\w+) (\d+)/     // by group

        Pattern pattern = ~regex2               // Pattern pattern = Pattern.compile(regex)
        Matcher matcher = value =~ regex2       // Matcher matcher = pattern.matcher(value)

//        boolean result = matcher.matches()
        boolean result = value ==~regex
        println("result = " + result)    // result = false
        println("===========")


        println("""
        --------------------------------------------------
        --------     working with group 1     ------------
        --------------------------------------------------
        """)
        while (matcher.find()) {
            println matcher.group()
            println matcher.group(1)
            println matcher.group(2)
            println("--------")
        }

        /*
            one 1
            one
            1
            --------
            two 22
            two
            22
            --------
            three 333
            three
            333
            --------
         */
        println("""
        --------------------------------------------------
        --------     working with group 2     ------------
        --------------------------------------------------
        """)
        matcher.each(group -> println group)
        /*
            [one 1, one, 1]
            [two 22, two, 22]
            [three 333, three, 333]
         */

        println("""
        --------------------------------------------------
        --------     working with group 2     ------------
        --------------------------------------------------
        """)
        matcher.each((group, group1, group2) -> {
            println group
            println group1
            println group2
        })
        /*
            one 1
            one
            1
            two 22
            two
            22
            three 333
            three
            333
         */

        println("""
        --------------------------------------------------
        --------     working with group 3     ------------
        --------------------------------------------------
        """)
        matcher.each((group, group1, group2) -> {
            println group1
        })
        /*
            one
            two
            three
         */
    }
}

/*
https://groovy-lang.org/operators.html#_regular_expression_operators

7. Regular expression operators
    
    7.1. Pattern operator
        The pattern operator (~) provides a simple way to create a java.util.regex.Pattern instance:
        
        def p = ~/foo/
        assert p instanceof Pattern
        while in general, you find the pattern operator with an expression in a slashy-string, it can be used with any 
        kind of String in Groovy:
        
        p = ~'foo'                                          (1)              
        p = ~"foo"                                          (2)            
        p = ~$/dollar/slashy $ string/$                     (3)              
        p = ~"${pattern}"                                   (4)              
        
        (1) using single quote strings
        (2) using double quotes strings
        (3) the dollar-slashy string lets you use slashes and the dollar sign without having to escape them
        (4) you can also use a GString!
        
    
    
    7.2. Find operator
        Alternatively to building a pattern, you can use the find operator =~ to directly create a java.util.regex.Matcher instance:
        
            def text = "some text to match"
            def m = text =~ /match/                                           (1)
            assert m instanceof Matcher                                       (2)
            if (!m) {                                                         (3)
                throw new RuntimeException("Oops, text not found!")
            }
         
         	(1) =~ creates a matcher against the text variable, using the pattern on the right hand side
            (2) the return type of =~ is a Matcher
            (3) equivalent to calling if (!m.find(0))   
            
            Since a Matcher coerces to a boolean by calling its find method, the =~ operator is consistent with the simple 
            use of Perl’s =~ operator, when it appears as a predicate (in if, ?:, etc.). When the intent is to iterate over 
            matches of the specified pattern (in while, etc.) call find() directly on the matcher or use the iterator DGM.
     
     
     
     7.3. Match operator
        The match operator (==~) is a slight variation of the find operator, that does not return a Matcher but a boolean 
        and requires a strict match of the input string:
        
            m = text ==~ /match/                                              (1)
            assert m instanceof Boolean                                       (2)
            if (m) {                                                          (3)
                throw new RuntimeException("Should not reach that point!")
            }
        
        (1) ==~ matches the subject with the regular expression, but match must be strict
        (2) the return type of ==~ is therefore a boolean
        (3) equivalent to calling if (text ==~ /match/)
       
       
       
    ...
       
 */