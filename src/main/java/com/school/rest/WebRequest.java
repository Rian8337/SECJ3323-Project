package com.school.rest;

import java.io.IOException;
import java.util.function.Consumer;

import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Represents a web request.
 * 
 * @param <TResponse> The type of the response object.
 */
public abstract class WebRequest<TResponse> implements AutoCloseable {
    protected static final OkHttpClient globalClient = new OkHttpClient();
    protected static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");

    /**
     * The {@link OkHttpClient} to use for this {@link WebRequest}.
     * 
     * By default, {@link #globalClient} is used with default settings. To override,
     * it is better to build a new one upon it by calling
     * {@link OkHttpClient#newBuilder()}.
     */
    protected OkHttpClient client = globalClient;

    private Call call;
    private Request request;

    public WebRequest(final String url) {
        this(HttpUrl.Companion.get(url));
    }

    public WebRequest(final HttpUrl url) {
        request = new Request.Builder().url(url).build();
    }

    /**
     * Builds a new {@link Request} upon the current one.
     * 
     * @param builder The consumer to build the {@link Request}.
     */
    public void buildRequest(final Consumer<Request.Builder> builder) {
        var requestBuilder = request.newBuilder();
        builder.accept(requestBuilder);

        request = requestBuilder.build();
    }

    /**
     * Builds the {@link RequestBody} for the {@link Request} of this
     * {@link WebRequest}.
     * 
     * @param builder The consumer to build the {@link RequestBody}.
     */
    public void buildRequestBody(final Consumer<JSONObject> builder) {
        var body = new JSONObject();
        builder.accept(body);

        buildRequest(
                requestBuilder -> requestBuilder.post(RequestBody.Companion.create(body.toString(), JSON_MEDIA_TYPE)));
    }

    /**
     * Builds a URL upon the current {@link Request}.
     * 
     * @param builder The consumer to build the {@link HttpUrl.Builder}.
     */
    public void buildUrl(final Consumer<HttpUrl.Builder> builder) {
        var urlBuilder = request.url().newBuilder();
        builder.accept(urlBuilder);

        buildRequest(requestBuilder -> requestBuilder.url(urlBuilder.build()));
    }

    /**
     * Executes this {@link WebRequest}.
     * 
     * If this {@link WebRequest} is already executing, the underlying {@link Call}
     * will be cancelled first before a new {@link Call} is executed.
     * 
     * @return The {@link TResponse} object.
     * @throws Exception If an error occurs while executing the request or the
     *                   targeted response object creation.
     */
    public TResponse execute() throws Exception {
        if (call != null) {
            cancel();
        }

        call = client.newCall(request);

        try (var response = call.execute()) {
            if (response.isSuccessful()) {
                return createResponseObject(response);
            } else {
                throw new UnsuccessfulResponseException(response);
            }
        }
    }

    @Override
    public void close() throws Exception {
        if (call != null) {
            call.cancel();
        }
    }

    /**
     * Attempts to cancel the underlying {@link Call} of this {@link WebRequest}.
     */
    public void cancel() {
        if (call != null) {
            call.cancel();
        }
    }

    /**
     * Creates the targeted response object.
     *
     * @param response The {@link Response} from the executed request.
     * @return The targeted response object.
     * @throws Exception If an error occurs while creating the response object.
     */
    protected abstract TResponse createResponseObject(final Response response) throws Exception;

    /**
     * Represents an exception thrown when the response is unsuccessful.
     */
    public static class UnsuccessfulResponseException extends IOException {
        public final Response response;

        public UnsuccessfulResponseException(final Response response) {
            super(response.message());

            this.response = response;
        }

        /**
         * Gets the response code.
         */
        public int getCode() {
            return response.code();
        }
    }
}
