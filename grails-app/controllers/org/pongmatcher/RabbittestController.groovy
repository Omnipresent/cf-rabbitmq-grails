package org.pongmatcher

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import org.pongmatcher.Result


class RabbittestController {
    def sendMessage = {
        rabbitSend 'queue1', 'someMessage'
        render "sent message"
    }
}