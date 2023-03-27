package com.study.lesson5

def  value = "groovy"
def someSelect3 = """
        select * 
        from table
        where name = ${getWithPrefix(value)}
        """
println(someSelect3)
/*
        select * 
        from table
        where name = prefix-groovy
 */




def getWithPrefix(String name) { 
        "prefix-" + name
}
