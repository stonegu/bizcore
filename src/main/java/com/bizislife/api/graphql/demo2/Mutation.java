package com.bizislife.api.graphql.demo2;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("demo2Mutation")
@AllArgsConstructor
public class Mutation implements GraphQLMutationResolver{
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public TestAuthor newAuthor(String firstName, String lastName) {
        TestAuthor author = new TestAuthor(firstName, lastName);
        authorRepository.save(author);
        return author;
    }

    public TestBook newBook(String title, String isbn, Integer pageCount, Long authorId) {
        TestBook book = new TestBook(title, isbn, pageCount!=null ? pageCount : 0, new TestAuthor(authorId));
        bookRepository.save(book);
        return book;
    }

    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }

    public TestBook updateBookPageCount(Integer pageCount, Long id) {
        Optional<TestBook> book = bookRepository.findById(id);        
        if (book.isPresent()) {
            book.get().setPageCount(pageCount);
            bookRepository.save(book.get());
            return book.get();
        } else {
            throw new BookNotFoundException("book not found: ", id);
        }
    }
}
