package com.prod.nets

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class RestController(@Autowired private val emailService: EmailService, @Value("\${send.to}") private val sendTo: String) {
    @PostMapping("/send")
    fun send(@RequestBody request: SendRequest) {
        val subject = if (request.isUpdate) {
            "Note updated"
        } else {
            "Note created"
        }
        val content = StringBuilder()
        if (request.oldTitle == null || request.oldTitle == request.title) {
            content.append("Title: ${request.title}\n\n")
        } else {
            content.append("Old title: ${request.oldTitle}\nNew title: ${request.title}\n\n")
        }
        if (request.oldContent == null || request.oldContent == request.content) {
            content.append("Content: ${request.content}")
        } else {
            content.append("Old content: ${request.oldContent}\nNew content: ${request.content}")
        }
        emailService.sendSimpleMessage(sendTo, subject, content.toString())
    }
}