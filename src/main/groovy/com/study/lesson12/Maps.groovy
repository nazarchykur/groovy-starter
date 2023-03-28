package com.study.lesson12

class Maps {
    static void main(String[] args) {
        // Maps
        // 
        // Maps associate keys to values, separating keys and values with colons, and each key/value pairs with commas, 
        // and the whole keys and values surrounded by square brackets.

        // We define a map of string color names, associated with their hexadecimal-coded html colors
        def colors = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']

        assert colors['red'] == '#FF0000'  // We use the subscript notation to check the content associated with the red key
        assert colors.green  == '#00FF00'  // We can also use the property notation to assert the color green’s hexadecimal representation

        colors['pink'] = '#FF00FF'        // Similarly, we can use the subscript notation to add a new key/value pair
        colors.yellow  = '#FFFF00'        // Or the property notation, to add the yellow color

        assert colors.pink == '#FF00FF'
        assert colors['yellow'] == '#FFFF00'

        assert colors instanceof LinkedHashMap


        // If you try to access a key which is not present in the map:
        assert colors.unknown == null

        def emptyMap = [:]
        assert emptyMap.anyKey == null                  // You will retrieve a null result.


        def numbers = [1: 'one', 2: 'two']
        assert numbers[1] == 'one'



        def key = 'name'
        def person = [key: 'Guillaume']

        assert !person.containsKey('name')
        assert person.containsKey('key')
        // The key associated with the 'Guillaume' name will actually be the "key" string, not the value associated with 
        // the key variable
        // 
        // The map doesn’t contain the 'name' key
        // Instead, the map contains a 'key' key

        
        // When you need to pass variable values as keys in your map definitions, you must surround the variable or 
        // expression with parentheses:
        person = [(key): 'Guillaume']

        assert person.containsKey('name')
        assert !person.containsKey('key')
        // This time, we surround the key variable with parentheses, to instruct the parser we are passing a variable 
        // rather than defining a string key
        //
        // The map does contain the name key
        // But the map doesn’t contain the key key as before
        
        
        
        // def map = [:]   // empty LinkedHashMap<Object, Object>
        def map = ["one": 1, "two": 2]
        
//        assert(map.getClass() == LinkedHashMap)
        assert map.getClass() == LinkedHashMap
        
        
        // ----------------------------------------------
        // ------------    read      -------------------
        // ----------------------------------------------
        assert map.get("one") == 1
        assert map["one"] == 1
        assert map."one" == 1
        assert map.one == 1              // if our key is String we can omit quotes
//        assert map.three == 3          // error because of the assert     but ander the hood called method propertyMissing
        assert map.get('ten', 10) == 10  // if not found than get this data by default


        // ----------------------------------------------
        // ------------    write      -------------------
        // ----------------------------------------------
        def map2 = [one: 1, two: 2]
        map2.one = 111
        map2.three = 3

        assert map2.subMap("one", "two") == [one: 111, two: 2]

        def newMap = ["q": 44, "z": 100, *: map2]
        assert newMap == ["q": 44, "z": 100, one: 111, two: 2, three: 3]
    }
}
