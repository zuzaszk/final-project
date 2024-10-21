package com.backend.zpi.service;

import org.springframework.stereotype.Service;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;

@Service
public class UsosAuthService {

    private static final String USOS_BASE_URL = "https://usosapi.pwt.wroc.pl/";
    private static final String REQUEST_TOKEN_URL = USOS_BASE_URL + "services/oauth/request_token";
    private static final String ACCESS_TOKEN_URL = USOS_BASE_URL + "services/oauth/access_token";
    private static final String AUTHORIZATION_URL = USOS_BASE_URL + "services/oauth/authorize";
    private static final String CALLBACK_URL = "http://localhost:8080/usos/callback";  

    private static final String CONSUMER_KEY = "wQCq3wEsQpVahyzd8U6J";
    private static final String CONSUMER_SECRET = "gkW7e7b55AwXy6nfKbmNsGjnY8V9ygm8y6s4g6MN";

     private OAuth10aService service;

    public UsosAuthService() {
        service = new ServiceBuilder(CONSUMER_KEY)
                .apiSecret(CONSUMER_SECRET)
                .callback(CALLBACK_URL)
                .build(new UsosApi());
    }

    public OAuth1RequestToken getRequestToken() throws Exception {
        return service.getRequestToken();
    }

    public String getAuthorizationUrl(OAuth1RequestToken requestToken) {
        return service.getAuthorizationUrl(requestToken);
    }

    public OAuth1AccessToken getAccessToken(OAuth1RequestToken requestToken, String oauthVerifier) throws Exception {
        return service.getAccessToken(requestToken, oauthVerifier);
    }
}
