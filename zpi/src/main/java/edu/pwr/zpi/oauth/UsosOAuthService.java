package edu.pwr.zpi.oauth;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Service
public class UsosOAuthService {

    private final OAuth10aService service;
    private OAuth1RequestToken requestToken;

    @Value("${usos.callback.url}")
    private String callbackUrl;

    public UsosOAuthService(@Value("${usos.consumer.key}") String consumerKey, @Value("${usos.consumer.secret}") String consumerSecret) {
        this.service = new ServiceBuilder(consumerKey)
                .apiSecret(consumerSecret)
                .callback(callbackUrl)
                .build(new UsosApi());
    }

    // Step 1: Obtain Request Token and Redirect User
    public void redirectToAuthorization(HttpServletResponse response) throws IOException, InterruptedException, ExecutionException {
        this.requestToken = service.getRequestToken();
        String authorizationUrl = service.getAuthorizationUrl(requestToken);
        response.sendRedirect(authorizationUrl);
    }

    // Step 2: After callback, obtain Access Token
    public OAuth1AccessToken getAccessToken(String oauthVerifier) throws IOException, ExecutionException, InterruptedException {
        return service.getAccessToken(requestToken, oauthVerifier);
    }
}
