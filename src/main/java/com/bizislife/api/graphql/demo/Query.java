package com.bizislife.api.graphql.demo;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver{
    @Autowired
    private UserService userService;

    public List<TestUser> getUsers(int first, int last) {
        System.out.println("Query: [" + first + "] to [" + last + "]");
        if (first == 0 && last == 0) {
            return this.userService.getAllUsers();
        } else {
            return this.userService.getUsers(first, last);
        }
    }

    public Optional<TestUser> getUser(int id) {
        return this.userService.getUser(id);
    }

}
