package com.study.lesson2

import com.sun.jdi.Bootstrap
import jdk.internal.loader.ClassLoaders

import java.sql.DriverManager

class AboutClassAndClassLoader {
    static void main(String[] args) {
        String value = "Hello"
//        def clazz = value.getClass()
        Class<String> clazz = value.getClass()
        assert clazz == String.class
        
        /*
            Так як код потім в байтокод щоб ДЖАВА його зупустила, то щоб знати який це саме клас і коли його потрібно
            завантажувати у ГРУВІ є клас лоадери, які і визначають, що перше загружаються найважливіші і так далі до низу.
            
                 .getClass()       - Returns the runtime class of this Object.     "Hello" це String.class
            clazz.getClassLoader() - Returns the class loader for the class.
            
                    BootstrapClassLoader   (Parent)
                            |
                            V
                    PlatfromClassLoader
                            |
                            V
                    App ClassLoader (System)
         */
        
        println clazz.getClassLoader() // null (BootstrapClassLoader (Parent) )
        println DriverManager.getClassLoader() // jdk.internal.loader.ClassLoaders$PlatformClassLoader@6b69a7a5
        println AboutClassAndClassLoader.getClassLoader() // jdk.internal.loader.ClassLoaders$AppClassLoader@46fbb2c1
        
    }
}
 