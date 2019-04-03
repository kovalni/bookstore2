package com.example.BookStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BookStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("books on shelf");
			repository.save(new Book("The Hobbit", "J.R.R. Tolkien", "1937", "987654", "12,95"));
			repository.save(new Book("Se Wsi Testamenti", "Mikael Agricola", "1548", "000000", "1990,95"));
			repository.save(new Book("The Life and Times of Scrooge McDuck", "Don Rosa", "1981", "165748-0", "89,90"));
			
			log.info("fetch books!");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
