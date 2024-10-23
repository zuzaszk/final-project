//package edu.pwr.zpi.oauth;
//
//
//import org.apereo.cas.client.validation.Cas20ServiceTicketValidator;
//import org.apereo.cas.client.validation.TicketValidator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.cas.ServiceProperties;
//import org.springframework.security.cas.authentication.CasAuthenticationProvider;
//import org.springframework.security.cas.web.CasAuthenticationEntryPoint;
//import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
//import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//
//@Configuration
//public class CasConfig {
//
//    // Specifies the URL that the CasAuthenticationFilter will listen to.
//    @Bean
//    public ServiceProperties serviceProperties() {
//        ServiceProperties serviceProperties = new ServiceProperties();
//        serviceProperties.setService("https://localhost:8080/login/cas");
//        serviceProperties.setSendRenew(false);
//        return serviceProperties;
//    }
//
//    // CAS authentication entry point
//    @Bean
//    public CasAuthenticationEntryPoint casAuthenticationEntryPoint(ServiceProperties serviceProperties) {
//        CasAuthenticationEntryPoint entryPoint = new CasAuthenticationEntryPoint();
//        entryPoint.setLoginUrl("https://login.pwr.edu.pl/auth/realms/pwr.edu.pl/protocol/cas/login?service=https%3A%2F%2Fweb.usos.pwr.edu.pl%2Fkontroler.php%3F_action%3Dlogowaniecas%2Findex&locale=pl");
//        entryPoint.setServiceProperties(serviceProperties);
//        return entryPoint;
//    }
//
//    // CAS Authentication Provider
//    @Bean
//    public CasAuthenticationProvider casAuthenticationProvider(ServiceProperties serviceProperties, TicketValidator ticketValidator) {
//        CasAuthenticationProvider provider = new CasAuthenticationProvider();
//        provider.setServiceProperties(serviceProperties);
//        provider.setTicketValidator(ticketValidator);  // TicketValidator to validate tickets
//        provider.setAuthenticationUserDetailsService(printCasTokenUserDetailsService());  // Use custom UserDetails logic
//        provider.setKey("CAS_PROVIDER_KEY");
//        return provider;
//    }
//
//    // Ticket Validator for CAS
//    @Bean
//    public TicketValidator ticketValidator() {
//        return new Cas20ServiceTicketValidator("https://login.pwr.edu.pl/auth/realms/pwr.edu.pl/protocol/cas/login?service=https%3A%2F%2Fweb.usos.pwr.edu.pl%2Fkontroler.php%3F_action%3Dlogowaniecas%2Findex&locale=pl");
//    }
//
//    // Custom UserDetailsService implementation to print CAS token attributes
//    @Bean
//    public AuthenticationUserDetailsService<CasAssertionAuthenticationToken> printCasTokenUserDetailsService() {
//        return new AuthenticationUserDetailsService<CasAssertionAuthenticationToken>() {
//            @Override
//            public UserDetails loadUserDetails(CasAssertionAuthenticationToken token) {
//                System.out.println("User authenticated via CAS.");
//                System.out.println("Token Principal (Username): " + token.getName());
//                System.out.println("CAS Assertion Attributes: " + token.getAssertion().getPrincipal().getAttributes());
//
//                if (token.getAssertion().getPrincipal().getAttributes() != null) {
//                    token.getAssertion().getPrincipal().getAttributes().forEach((key, value) -> {
//                        System.out.println("Attribute: " + key + " = " + value);
//                    });
//                }
//
//                // For now, just return a dummy UserDetails object
//                return User.withUsername(token.getName())
//                        .password("N/A")  // Password isn't required for CAS authentication
//                        .roles("USER")    // You can assign roles if needed
//                        .build();
//            }
//        };
//    }
//}
