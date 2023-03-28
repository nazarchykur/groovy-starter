package com.study.lesson11

class Lists {
    static void main(String[] args) {

        // We define a list numbers delimited by commas and surrounded by square brackets, and we assign that list into 
        // a variable
        def numbers = [1, 2, 3]

        assert numbers instanceof List    // The list is an instance of Java’s java.util.List interface
        assert numbers.size() == 3

        
        // In the above example, we used a homogeneous list, but you can also create lists containing values of 
        // heterogeneous types:
        def heterogeneous = [1, "a", true]
        // Our list here contains a number, a string and a boolean value


        // We mentioned that by default, list literals are actually instances of java.util.ArrayList, but it is possible 
        // to use a different backing type for our lists, thanks to using type coercion with the as operator, or with 
        // explicit type declaration for your variables:
        def arrayList = [1, 2, 3]
        assert arrayList instanceof java.util.ArrayList

        def linkedList = [2, 3, 4] as LinkedList
        assert linkedList instanceof java.util.LinkedList

        LinkedList otherLinked = [3, 4, 5]
        assert otherLinked instanceof java.util.LinkedList
        // We use coercion with the as operator to explicitly request a java.util.LinkedList implementation
        // We can say that the variable holding the list literal is of type java.util.LinkedList



        // Arrays
        // 
        // Groovy reuses the list notation for arrays, but to make such literals arrays, you need to explicitely define 
        // the type of the array through coercion or type declaration.

        String[] arrStr = ['Ananas', 'Banana', 'Kiwi']  // Define an array of strings using explicit variable type declaration

        assert arrStr instanceof String[]               // Assert that we created an array of strings
        assert !(arrStr instanceof List)

        def numArr = [1, 2, 3] as int[]                 // Create an array of ints with the as operator

        assert numArr instanceof int[]                  // Assert that we created an array of primitive ints
        assert numArr.size() == 3
        
        
        
//        Integer[] list = [1, 2, 3, 4]
        def list = [1, 2, 3, 4]

//        assert list.getClass() == ArrayList.class
        assert list.getClass() == ArrayList

        // read
        assert list[2] == 3
        assert list.get(2) == 3
        assert list[-1] == 4     // list.get(list.size() -1)

        assert list[1..3] == [2, 3, 4]   // using range to get sublist

        // in Java if we get index out of list we will get an error
        assert list[10] == null


        // write
        list += 5
        assert list == [1, 2, 3, 4, 5]

        list << 6 << 7
        assert list == [1, 2, 3, 4, 5, 6, 7]

        def list2 = [2, 5, 5, 1, 5, 3, 8]
        list2 -= 5   // remove all 5
        assert list2 == [2, 1, 3, 8]

        list2 -= [3, 8]
        assert list2 == [2, 1]

        list2 *= 3
        assert list2 == [2, 1, 2, 1, 2, 1]


        // methods from queue
        def list3 = [1, 2, 3]
        list3.push(10)                    // add element 
        assert list3.pop() == 10          // remove and return this element
        assert list3.head() == 1          // return first element
        assert list3.last() == 3          // return last element
        assert list3.tail() == [2, 3]     // return all except for first element


        // flatten, reverse, intersect, disjoint
        assert [1, 2, [3, 4, 5], 6].flatten() == [1, 2, 3, 4, 5, 6]
        assert [1, 2, 3].reverse() == [3, 2, 1]
        assert [1, 2, 3].intersect([2, 5, 3]) == [2, 3]      // return the same el from both lists
        assert [1, 2, 3].disjoint([5, 6, 7])                 // true if list1 does not contain elements form list2
        
        
        // new operators
        // multiply assign
        def (a, b, c) = [1, 2, 3, 4, 5]
        assert a == 1
        assert b == 2
        assert c == 3

        func(*[5, 9]) // we add list but to separate into to elements we prefix it with *
        // and this func works fine where first el is a=5, and second b=9 and print it to console
        
    }

    static def func(def a, def b) {
        println a
        println b
    }
}
