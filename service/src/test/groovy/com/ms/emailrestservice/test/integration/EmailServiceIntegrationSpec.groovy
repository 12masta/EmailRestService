package com.ms.emailrestservice.test.integration

import com.ms.emailrestservice.Application
import com.ms.emailrestservice.controllers.GreetingController
import com.ms.emailrestservice.test.EmailServiceSpecification
import okhttp3.Request
import okhttp3.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration
@SpringBootTest(classes = Application.class)
class EmailServiceIntegrationSpec extends EmailServiceSpecification {

    @Autowired
    GreetingController controller

    def "Call sendSimpleMessage method in EmailService with valid arguments"() {
        given: "request has been build"
        def request = new Request.Builder()
                .url("http://localhost:8080/greeting")
                .get()
                .build()

        when: "request has been executed"
        Response response = client.newCall(request).execute()

        then: "no exception was throwed"
        response.body().toString().contains("Hello")
        where:
        to                         | subject             | text
        "stanek.marcinp@gmail.com" | "test_subject_mail" | "test text"
    }
}