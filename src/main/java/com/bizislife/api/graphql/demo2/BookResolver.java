package com.bizislife.api.graphql.demo2;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Service;

@Service
public class BookResolver implements GraphQLResolver<Book>{
    private AuthorRepository authorRepository;
    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getId()).get();
    }

}
