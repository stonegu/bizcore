package com.bizislife.api.graphql.demo;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver{

    @Autowired
    private UserService userService;

    public TestUser createUser(String login, String name) {
        return this.userService.newUser(login, name);
    }

}
