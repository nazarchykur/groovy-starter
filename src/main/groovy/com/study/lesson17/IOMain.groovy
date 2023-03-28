package com.study.lesson17

import groovy.io.FileType

class IOMain {
    static void main(String[] args) {
        // remember about best practices to use unchecked exceptions
        
        // the same rules as in Java
        // use try catch / try-with-resource 

        // ---------------------------------
        // ---------    read   ------------
        // ---------------------------------
        
        def file = new File(".gitignore")
        
        // read the whole file 
//        println file.text  
        
        // read by line
//        file.each { line -> println line }
        
        // using InputStream
//        file.withInputStream {
//            def allText = new String(it.readAllBytes())
//            println allText
//        }
        
        
        
        // ---------------------------------
        // ---------    write   ------------
        // ---------------------------------
        
        def file2 = new File("text.txt")
        file2.text = "some text"
        file2 << " new line" << System.lineSeparator()
        
//        file2.withOutputStream {}
//        file2.newOutputStream()   // here need to work with try-with-resources

        def srcDir = new File("src")
        srcDir.eachDir { println it }
        /*
            src/main
            src/test
         */
        
//        srcDir.eachDirRecurse { println it }  // every folder and subfolder

        srcDir.eachFile(FileType.FILES) { println it }
        
    }
}
