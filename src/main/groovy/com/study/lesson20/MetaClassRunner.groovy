package com.study.lesson20

import com.study.lesson18.Student
import org.codehaus.groovy.runtime.DefaultGroovyMethods

import java.lang.reflect.Method

class MetaClassRunner {
    static void main(String[] args) {
        def customMetaClass = new CustomMetaClass()

        def method = DefaultGroovyMethods.class.getMethod("println", Object.class, Object.class)
        customMetaClass.methods.put("println", method)
        def printlnMethod = customMetaClass.methods.get("println")
        
        def student = new Student()
        
        printlnMethod.invoke(student, student, "test")  // test


        println """
            -----------------------------
            -----   MetaClassImpl   -----
            -----------------------------
        """
//        println student.getMetaClass()      // org.codehaus.groovy.runtime.HandleMetaClass@42a48628[groovy.lang.MetaClassImpl@42a48628[class com.study.lesson18.Student]]
        println student.metaClass             // org.codehaus.groovy.runtime.HandleMetaClass@42a48628[groovy.lang.MetaClassImpl@42a48628[class com.study.lesson18.Student]]
//        println student.metaClass.methods   // all methods include inherited from java.lang.Object ...
        
        
        
        println """
            -----------------------------
            ----  ExpandoMetaClass   ---
            -----------------------------
        """
        // allow to add methods ans properties in runtime => DYNAMIC
        
        student.metaClass.abc = "test property"
        student.metaClass.test = {
            println "It's a new method"
        }
        
        student.test()              // It's a new method
        println student.abc         // test property
        println student.metaClass   // org.codehaus.groovy.runtime.HandleMetaClass@4c402120[groovy.lang.ExpandoMetaClass@4c402120[class com.study.lesson18.Student]]
    }
}
