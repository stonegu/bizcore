package com.bizislife.api.graphql.demo2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<TestAuthor, Long> {
}
