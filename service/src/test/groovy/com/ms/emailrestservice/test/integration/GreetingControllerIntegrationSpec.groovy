package com.ms.emailrestservice.test.integration

import com.ms.emailrestservice.Application
import com.ms.emailrestservice.test.EmailServiceSpecification
import okhttp3.Request
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = Application.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class GreetingControllerIntegrationSpec extends EmailServiceSpecification {

    def "Call sendSimpleMessage method in EmailService with valid arguments"() {
        given: "request has been build"
        def request = new Request.Builder()
                .url("http://localhost:8080/greeting")
                .get()
                .header("Content-Type", "application/json")
                .build()

        when: "request has been executed"
        def response = client.newCall(request).execute()

        then: "no exception was throwed"
        response.body().string().contains("Hello, World")
    }
}