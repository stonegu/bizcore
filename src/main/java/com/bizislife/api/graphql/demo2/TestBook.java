package com.bizislife.api.graphql.demo2;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class TestBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;
    private int pageCount;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false, updatable = false)
    private TestAuthor author;

    public TestBook(String title, String isbn, int pageCount, TestAuthor author) {
        this.title = title;
        this.isbn = isbn;
        this.pageCount = pageCount;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestBook)) return false;

        TestBook book = (TestBook) o;

        return id != null ? id.equals(book.id) : book.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
