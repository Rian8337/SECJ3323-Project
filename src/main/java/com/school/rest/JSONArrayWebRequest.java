package com.school.rest;

import org.json.JSONArray;

import okhttp3.HttpUrl;
import okhttp3.Response;

/**
 * A {@link WebRequest} that expects a {@link JSONArray} response.
 */
public class JSONArrayWebRequest extends WebRequest<JSONArray> {
    public JSONArrayWebRequest(final String url) {
        super(url);
    }

    public JSONArrayWebRequest(final HttpUrl url) {
        super(url);
    }

    @Override
    protected JSONArray createResponseObject(final Response response) throws Exception {
        return new JSONArray(response);
    }
}
