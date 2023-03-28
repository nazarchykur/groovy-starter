package com.study.lesson16

trait WithId {
    Integer id
    
    boolean validate() {
        id > 0
    }
    
    // похоже на інтерфейс але має свої особливості

}

/*
    Traits
        Traits are a structural construct of the language which allows:
            > composition of behaviors
            > runtime implementation of interfaces
            > behavior overriding
            > compatibility with static type checking/compilation
        
        They can be seen as interfaces carrying both default implementations and state. A trait is defined using the trait keyword:
            trait FlyingAbility {                       // declaration of a trait
                    String fly() { "I'm flying!" }      // 	declaration of a method inside a trait        
            }
        
        
        Then it can be used like a normal interface using the implements keyword:
            class Bird implements FlyingAbility {}   // Adds the trait FlyingAbility to the Bird class capabilities
            def b = new Bird()                       // instantiate a new Bird
            assert b.fly() == "I'm flying!"          // the Bird class automatically gets the behavior of the FlyingAbility trait
     
 */