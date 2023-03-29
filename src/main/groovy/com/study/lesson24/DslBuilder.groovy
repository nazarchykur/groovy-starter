package com.study.lesson24

class DslBuilder {
    static EmailSpecification email(@DelegatesTo(EmailSpecification) Closure closure) {
        def emailSpecification = new EmailSpecification()
//        closure.delegate = emailSpecification
//        closure.resolveStrategy = Closure.DELEGATE_ONLY
//        closure()
        
        // one line instead od three above
        emailSpecification.with closure

        emailSpecification
    }
}
