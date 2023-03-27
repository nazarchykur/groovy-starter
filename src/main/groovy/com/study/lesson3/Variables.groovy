package com.study.lesson3

import groovy.transform.CompileStatic

//import java.sql.Date
import java.sql.Date as SqlDate  // alias

/*
Program structure
    1. Package names
    2. Imports
        2.1. Default imports
        2.2. Simple import
        ...
        
    https://groovy-lang.org/structure.html
 */
class Variables {
    /*
        byte, short, int, long, BigInteger
        float, double, BigDecimal
        char
        boolean
     */
    
//    @CompileStatic // щоб включити CompileTime режим, щоб не отримувати прості помилки у рантаймі  
    // (насправді рідко використовується, але така можливість є і її можна ось так включити добавивши анотацію @CompileStatic)
    static void main(String[] args) {
        int value = 5
        Integer value2 = 5
        def l = 10L
        
        BigInteger value3 = 12G
        BigDecimal value4 = 1.3G
        
//        new Date()
        new SqlDate() // use alias
    }
}
