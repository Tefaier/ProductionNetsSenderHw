package com.prod.nets

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProductionNetsSenderApplication

fun main(args: Array<String>) {
	runApplication<ProductionNetsSenderApplication>(*args)
}
