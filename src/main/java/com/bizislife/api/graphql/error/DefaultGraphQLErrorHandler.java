package com.bizislife.api.graphql.error;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class DefaultGraphQLErrorHandler implements GraphQLErrorHandler {
    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> list) {
        Predicate<GraphQLError> isClientError = error -> isClientError(error);
        List<GraphQLError> clientErrors = list.stream().filter(isClientError).collect(Collectors.toList());
        List<GraphQLError> serverErrors = list.stream().filter(error -> !isClientError(error))
                .map(GraphQLErrorAdapter::new).collect(Collectors.toList());
        List<GraphQLError> e = new ArrayList<>();
        e.addAll(clientErrors);
        e.addAll(serverErrors);
        return e;
    }

    protected boolean isClientError(GraphQLError error) {
        return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
    }

}
