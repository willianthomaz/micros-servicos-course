package com.willian.thomaz.hroauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*Auxiliar que traduz entre valores de token codificados por JWT
     * e informações de autenticação OAuth (em ambas as direções).
     * Também atua como um TokenEnhancer
     * quando os tokens são concedidos.*/
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey("MY-SECRET-KEY");
        return tokenConverter;
    }

    /*Responsável por ler as informações do Token
    * Uma TokenStore implementação que apenas lê dados dos próprios tokens.
    * Não é realmente uma loja, já que nunca persiste nada, e métodos como
    * getAccessToken(OAuth2Authentication)sempre retornam nulo. No entanto,
    * é uma ferramenta útil, uma vez que traduz tokens de acesso de e para autenticações.
    * Use-o sempre que um TokenStorefor necessário, mas lembre-se de usar a
    * mesma JwtAccessTokenConverter instância (ou uma com o mesmo verificador)
    * que foi usada quando os tokens foram cunhados.*/
    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }
}
