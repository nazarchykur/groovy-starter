package com.study.lesson18

class AST {
    static void main(String[] args) {
        def student = new Student("Leo", "Turtles", 30)
        println student.toString() // com.study.lesson18.Student(Leo, Turtles, 30)
        println student.hashCode() // -1396255186


        def student2 = new Student("Leo", "Turtles")
        println  student2.equals(student)  // false

        def student3 = Student.builder()
                .firstName("leo")
                .lastName("Turtles")
                .age(30)
                .build()
        
        println student3 == student // false 

        def student4 = Student.builder()
                .firstName("leo")
                .lastName("Turtles")
                .age(30)
                .build()

        println student4 == student4 // true 

        def student5 = Student.builder()
                .firstName("leo")
                .build()

        println student5   // com.study.lesson18.Student(leo, null, null)
    }
}

/*
    import groovy.transform.Canonical
    import groovy.transform.TupleConstructor
    
    @Canonical
    @TupleConstructor
    class Person {
        int id
        String firstName
        String lastName
        Date birthdate
    }
    
    Компілюємо, і в байткоді отримуємо аналог ось цього:
    Пекельний бойлерплейт на Джаві на 100 з лишком рядків
    
    
    Отже, чому AST transformations, а не Lombok?

        Почнемо з того, щоб користуватися AST transformations вам не потрібно ні знати Groovy, ні писати на Groovy, ні 
        запускати Groovy в рантаймі. Трансформація відбувається під час компіляції сорців і Groovy додається одним jar-ом 
        до списку залежностей. Всьо.
        
        Таким чином, AST transformations є чудовим способом «протягнути» Groovy у ваш проект: «Дивися, бос, це нічого 
        страшного, це просто ще одна бібліотека для боротьби з бойлерплетом!». 
        А потім, вже, крок за кроком:
            > тести на Споку
            > білд на Грейдлі, 
        
        у вашому коді з'явиться справжній Groovy - динамічний, функціональний та елегантний. AST transformations це лише перший крок.
        
        Крім того, AST transformations набагато більш розширювані, потужні та універсальні, ніж Ломбок.
        Останнє, але не менш важливе - AST transformations чудово підтримуються в будь-якому IDE за допомогою Groovy
        
        
        
    Вступ до AST transformations

        Одна з найголовніших плюшок у Groovy, це, звичайно метапрограмування . Воно буває двох типів - під час компіляції 
        та під час виконання.    
        
        Почнемо ми з трансформації, яка прошита прямо в самому Groovy, без жодних анотацій та інших добавок.
            class Person {
                String name
            }
        
        На виході отримуємо байткод, в якому всі поля - private(в даному випадку - name), і прописані всі getters і 
        setters (ну, в даному випадку тільки getName()і setName(String name), але ідея зрозуміла).
        
        Ця чудова дрібниця є повноцінним прикладом метапрограмування під час компіляції.
        
        AST transformations це набір анотацій, що змінюють Анотація синтаксичне дерево (abstract syntax tree, AST) 
        нальоту під час компіляції Groovy. Можна сказати, що додавання getters та setters це вбудована трансформація AST, 
        яка працює завжди, без додавання анотацій. Інші ж включаються тільки на вимогу.
        
        > @Immutable робить клас незмінним, саме:
            - сеттери кидають ReadOnlyPropertyException
            - клас стає final
            - поля стають private і final
            - з'являються конструктори з усіма полями: як у параметрах, і у карті (як у першому прикладі)
            - з'являється код, який створює резервні копії для компонентів, що змінюються
            - з'являються equals, hashcode іtoString
            
        > @TupleConstructor додає конструктор map, в якому ключі – назви полів, а значення – значення
        
        > @Canonical робить «правильний Джава» клас» - з конструктором без параметрів, конструкторами, які приймають 
            всі параметри (як всі зараз, так і мапою), + equals, hashCode,  toString
        
        > Ще один модний термін! @Lazy створить ліниво-ініціалізоване поле (на першу вимогу), опціонально, обгорнуте в 
            soft-reference
        
        > @Memoized, яка запам'ятовує результат роботи методу, і якщо він викликається ще раз, віддає результат негайно 
        
        > Є ще архі-важливий @CompileStatic, @Field, і цілий набір анотацій для усунення страждань по concurrency
        
        > @Builder ...
        
        ...     
 */