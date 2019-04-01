package com.bizislife.api.graphql.demo2;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Service;

@Service
public class BookResolver implements GraphQLResolver<TestBook>{
    private AuthorRepository authorRepository;
    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public TestAuthor getAuthor(TestBook book) {
        return authorRepository.findById(book.getAuthor().getId()).get();
    }

}
