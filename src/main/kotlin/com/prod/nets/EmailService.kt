package com.prod.nets

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Component

@Component
class EmailService(private val emailSender: JavaMailSender) {
    fun sendSimpleMessage(to: String, subject: String, text: String) {
        val message = SimpleMailMessage()
        message.from = "noreply@example.com"
        message.setTo(to)
        message.subject = subject
        message.text = text
        emailSender.send(message)
    }
}
