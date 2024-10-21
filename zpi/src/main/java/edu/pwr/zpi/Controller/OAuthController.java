package edu.pwr.zpi.Controller;

import edu.pwr.zpi.oauth.UsosOAuthService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
public class OAuthController {

    @Autowired
    private UsosOAuthService usosOAuthService;

    // Step 1: Start OAuth process
    @GetMapping("/login/usos")
    public void loginWithUsos(jakarta.servlet.http.HttpServletResponse response) throws IOException, ExecutionException, InterruptedException {
        usosOAuthService.redirectToAuthorization(response);
    }


    // Step 2: Handle callback after user grants access
    @GetMapping("/callback")
    public String callback(@RequestParam("oauth_verifier") String oauthVerifier) throws IOException, ExecutionException, InterruptedException {
        var accessToken = usosOAuthService.getAccessToken(oauthVerifier);
        return "Access Token: " + accessToken.getToken() + ", Secret: " + accessToken.getTokenSecret();
    }
}
