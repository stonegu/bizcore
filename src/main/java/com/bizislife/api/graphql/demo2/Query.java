package com.bizislife.api.graphql.demo2;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;

import java.util.Optional;

import org.springframework.stereotype.Component;

@Component("demo2Query")
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Iterable<TestBook> findAllBooks() {
        return bookRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }
    
    public TestBook findBook(long id) {
    	Optional<TestBook> bookOpt = bookRepository.findById(id);
    	if (bookOpt.isPresent()) {
    		return bookOpt.get();
    	} else {
    		throw new BookNotFoundException("no book found", id);
    	}
    }

    public Iterable<TestAuthor> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countAuthors() {
        return authorRepository.count();
    }
}
