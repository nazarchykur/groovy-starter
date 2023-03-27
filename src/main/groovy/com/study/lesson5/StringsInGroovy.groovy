package com.study.lesson5

class StringsInGroovy {
    static void main(String[] args) {
        /*
            " "
            ' '
            """ """
            ''' '''
            / / 
            $/ /$ 
         */

        def name = "Groovy"
        def name2 = "Groovy 'in Java'"
        def name3 = 'Groovy \'in Java\''

        println(name)   // Groovy
        println(name2)  // Groovy 'in Java'
        println(name3)  // Groovy 'in Java'


        def name4 = "Java and $name" // with double quotes we can use string interpolation => get some var with $
        println(name4)        // Java and Groovy


        def someSelect = """
        select * 
        from table
        where name = ?
        """

        println(someSelect)
        /*
            select * 
            from table
            where name = ?
         */

        def someSelect2 = """
        select * 
        from table
        where name = $name
        """
        println(someSelect2)
        /*
            select * 
            from table
            where name = Groovy
         */


        String value = "groovy"
        def someSelect3 = """
        select * 
        from table
        where name = ${getWithPrefix(value)}
        """
        println(someSelect3)


        def value2 = /hello $name/
        println(value2)                            // hello Groovy

        def value3 = $/hello $name/$
        println(value3)                            // hello Groovy


        println '''
        --------------------------------------------------------------------
        ---------  working with string as an array  ------------------------
        --------------------------------------------------------------------
        '''
        def name5 = "Groovy"
        println name5[1]       // r
        println name5[-1]      // y
        println name5[0]       // G

        println name5[1..3]    // roo
        println name5 * 2      // GroovyGroovy
        println name5 - "vy"   // Groo
    }

    static def getWithPrefix(String name) {
        "prefix-" + name
    }
}
