package com.migrations.flyway

import com.migrations.flyway.model.Book
import com.migrations.flyway.repository.BookRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@SpringBootApplication
class FlywayApplication

fun main(args: Array<String>) {
    runApplication<FlywayApplication>(*args)
}


@Configuration
class DataLoader() {

    @Bean
    fun runAfterContextStarts(
        bookRepository: BookRepository
    ) = CommandLineRunner {
        print("hello")
        val bookList = mutableListOf(
            Book(name = "book_1"),
            Book(name = "book_2")
        )
        bookRepository.saveAll(bookList)
        print(bookRepository.findAll().toString())
    }
}