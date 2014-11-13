package com.freeAppListing.platform

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Secured(['ROLE_SUPERADMIN'])
class PlatformsController {

    static allowedMethods = [list: "POST", save: "POST"]

    @Transactional
    def save() {

        def newPlatform = new Platforms(
                name: params.name,
                web: params.web,
                market: params.market,
                description: params.description,
                dateCreate: new Date(),
                dateUpdate: new Date()
        ).save(failOnError: true)

        println(newPlatform.errors.allErrors)

        def respuesta = [status:1, message:"Hola mundo", dataPlataform: newPlatform]
        render respuesta as JSON
    }
}