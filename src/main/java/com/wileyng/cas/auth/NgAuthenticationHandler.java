package com.wileyng.cas.auth;


import org.apereo.cas.authentication.HandlerResult;
import org.apereo.cas.authentication.UsernamePasswordCredential;
import org.apereo.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.apereo.cas.authentication.principal.PrincipalFactory;
import org.apereo.cas.services.ServicesManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.FailedLoginException;
import java.security.GeneralSecurityException;

public class NgAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(NgAuthenticationHandler.class);


    public NgAuthenticationHandler(String name, ServicesManager servicesManager, PrincipalFactory principalFactory, Integer order) {
        super(name, servicesManager, principalFactory, order);
    }

    protected HandlerResult authenticateUsernamePasswordInternal(final UsernamePasswordCredential credential,
                                                                 final String originalPassword) throws GeneralSecurityException {
        LOGGER.info("user={}, password={}", credential.getUsername(), credential.getPassword()); //TODO delete this

        if ("parker".equalsIgnoreCase(credential.getUsername()) && "password".equalsIgnoreCase(credential.getPassword())) {
            return createHandlerResult(credential,
                    this.principalFactory.createPrincipal(credential.getUsername()), null);
        } else {
           throw new FailedLoginException("Sorry, you are a failure!");

        }


    }

}
