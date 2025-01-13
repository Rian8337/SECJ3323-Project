package com.school.rest;

import org.json.JSONObject;

import okhttp3.HttpUrl;
import okhttp3.Response;

/**
 * A {@link WebRequest} that expects a {@link JSONObject} response.
 */
public class JSONObjectWebRequest extends WebRequest<JSONObject> {
    public JSONObjectWebRequest(final String url) {
        super(url);
    }

    public JSONObjectWebRequest(final HttpUrl url) {
        super(url);
    }

    @Override
    protected JSONObject createResponseObject(final Response response) throws Exception {
        return new JSONObject(response.body().string());
    }
}
