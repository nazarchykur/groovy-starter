package com.study.lesson3

/*
Program structure
    1. Package names
    2. Imports
        2.1. Default imports
        2.2. Simple import
        ...
        
    https://groovy-lang.org/structure.html
    
    
    так як Груві - це динамічна МП, то тут можна використовувати    
    def (подібне на var from Java10+), щоб не зазначати тип даних 
        (для полів, методів, аргументів, всередині методу для всіх змінних)
        
    тобто можемо вибирати стиль:  ДИНАМІЧНУ або  СТАТИЧНУ ТИПІЗАЦІЮ    
    
    ! ВАРТО цим не користувати тепер для всього, бо все ж потрібно памятати стиль ДЖАВА і для чого ми зазначаємо цей 
        тип даних, який покращує читабельність коду і є більш зрозумілий
 */

class Variables2 {

    def field1
    def field2
    /*
        byte, short, int, long, BigInteger
        float, double, BigDecimal
        char
        boolean
     */

    static def main(def args) {
        def value = 5
        def value2 = 5
        def l = 10L

        def value3 = 12G
        def value4 = 1.3G

        
    }
}
