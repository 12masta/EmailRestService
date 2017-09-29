package com.ms.emailrestservice.test.unit

import com.ms.emailrestservice.email.EmailService
import com.ms.emailrestservice.test.EmailServiceSpecification
import spock.lang.Specification

class EmailServiceUnitSpec extends EmailServiceSpecification {
    def "Call sendSimpleMessage method in EmailService with valid arguments"() {
        given: "a stub EmailService returning given givenTemperature"
        EmailService emailService = Mock(EmailService)

        when: "sendSimpleMessage was executed"
        emailService.sendSimpleMessage(to, subject, text)

        then: "no exception was throwed"
        noExceptionThrown()
        and: "method sendSimpleMessage was called once"
        1 * emailService.sendSimpleMessage(_, _, _)
        where:
        to                         | subject             | text
        "stanek.marcinp@gmail.com" | "test_subject_mail" | "test text"
    }
}