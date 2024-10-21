package com.backend.zpi.service;

import com.github.scribejava.core.builder.api.DefaultApi10a;


public class UsosApi extends DefaultApi10a {

    private static final String REQUEST_TOKEN_URL = "https://usosapi.pwt.wroc.pl/services/oauth/request_token";
    private static final String ACCESS_TOKEN_URL = "https://usosapi.pwt.wroc.pl/services/oauth/access_token";
    private static final String AUTHORIZE_URL = "https://usosapi.pwt.wroc.pl/services/oauth/authorize";

    @Override
    public String getRequestTokenEndpoint() {
        return REQUEST_TOKEN_URL;
    }

    @Override
    public String getAccessTokenEndpoint() {
        return ACCESS_TOKEN_URL;
    }

    @Override
    protected String getAuthorizationBaseUrl() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAuthorizationBaseUrl'");
    }

}