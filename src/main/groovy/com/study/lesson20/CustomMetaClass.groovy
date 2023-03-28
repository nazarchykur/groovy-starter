package com.study.lesson20

import java.lang.reflect.Field
import java.lang.reflect.Method

// +- analog Class in Java

class CustomMetaClass {
    
    // just for demonstration purpose lets create Map for methods and fields like in Java with reflection API 
    
    Map<String, Method> methods = new HashMap<>()
    Map<String, Field> fields = new HashMap<>()
}
