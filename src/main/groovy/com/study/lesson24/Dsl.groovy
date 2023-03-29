package com.study.lesson24

import static com.study.lesson24.DslBuilder.*

//def email = new Email()
//email.setFrom("from@gmail.com")
//email.setTo("to@gmail.com")
//email.setTitle("Title")
//
//def body = new MailBody()
//body.setText("some text")
//body.setImages(List.of("image1.png"))
//
//email.setBody(body)


email {
    from "from@gmail.com"
    to "to@gmail.com"
    title "Title"
    body {
        text "some text"
        images(["image1.png"])
    }
}