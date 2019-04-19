package com.bizislife.rest.utils;

import javax.persistence.NoResultException;

public class RestPreconditions {
	public static <T> T checkFound(T source) {
		if (source == null) {
			throw new NoResultException("No result found");
		}
		return source;
	}

}
