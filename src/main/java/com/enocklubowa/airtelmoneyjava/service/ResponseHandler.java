package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.exception.AirtelException;
import com.enocklubowa.airtelmoneyjava.model.AirtelErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

public class ResponseHandler {

    public static Mono<ClientResponse> responseProcessor(ClientResponse response) {
        HttpStatus status = response.statusCode();
        String message;
        switch (status) {
            case BAD_REQUEST:
                //Your request is invalid.
                return response.bodyToMono(AirtelErrorResponse.class)
                        .flatMap(body -> Mono.error(new AirtelException(body.getError()+": "+body.getError_description())));

            case UNAUTHORIZED:
                message = "Your API key or bearer token is wrong.";
                return throwExceptionWithMessage(response, message);

            case FORBIDDEN:
                message = "The requested item is hidden for administrators only.";
                return throwExceptionWithMessage(response, message);

            case NOT_FOUND:
                message = "The specified path could not be found.";
                return throwExceptionWithMessage(response, message);

            case METHOD_NOT_ALLOWED:
                message = "You tried to access a path with an invalid method.";
                return throwExceptionWithMessage(response, message);

            case TOO_MANY_REQUESTS:
                message = "You're requesting too many requests! Slow down!";
                return throwExceptionWithMessage(response, message);

            case SERVICE_UNAVAILABLE:
                message = "We're temporarily offline for maintenance. Please try again later.";
                return throwExceptionWithMessage(response, message);

            case INTERNAL_SERVER_ERROR:
                message = "We had a problem with our server. Try again later.";
                return throwExceptionWithMessage(response, message);
        }

        return Mono.just(response);
    }

    private static Mono<ClientResponse> throwExceptionWithMessage(ClientResponse response, String message){
        return response.bodyToMono(String.class)
                .flatMap(body -> Mono.error(new AirtelException(message)));
    }

}
