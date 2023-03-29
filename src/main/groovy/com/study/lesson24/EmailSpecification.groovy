package com.study.lesson24

class EmailSpecification {
    String from
    String to
    String title
    BodySpecification body

    def from(String from) {
        this.from = from
    }

    def to(String to) {
        this.to = to
    }

    def title(String title) {
        this.title = title
    }
    
    def body(@DelegatesTo(BodySpecification) Closure closure) {
        this.body = new BodySpecification()
        this.body.with closure
    }

}
