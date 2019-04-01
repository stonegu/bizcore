package com.bizislife.api.graphql.error;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class EntityExistException extends RuntimeException implements GraphQLError{
    private Map<String, Object> extensions = new HashMap<>();

	public EntityExistException(String message, Object id) {
		super(message);
		extensions.put("existingId", id);
	}

	@Override
	public List<SourceLocation> getLocations() {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
	public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
	}

}
