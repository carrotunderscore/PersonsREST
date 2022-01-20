package com.example.personsrest.remote;

import com.example.personsrest.KeyCloakToken;
import org.apache.catalina.Group;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.Objects;

public class GroupRemoteImpl implements GroupRemote {

    WebClient webClient = WebClient.create("https://groups.edu.sensera.se/");
    KeyCloakToken token = KeyCloakToken.acquire("https://iam.sensera.se/", "test", "group-api", "user", "djnJnPf7VCQvp3Fc")
            .block(Duration.ofSeconds(20));
    @Override
    public String getNameById(String groupName) {
        return Objects.requireNonNull(webClient
                .get().uri("api/groups/" + groupName)
                .header("Authorization", "Bearer " + token.getAccessToken())
                .retrieve()
                .bodyToMono(Group.class)
                .block()).getName();
    }

    @Override
    public String createGroup(String name) {
        return Objects.requireNonNull(
                webClient.post()
                        .uri("api/groups")
                        .header("Authorization", "Bearer " + token.getAccessToken())
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .body(BodyInserters.fromValue(new CreateGroup(name)))
                        .retrieve()
                        .bodyToMono(Group.class)
                        .block()).getName();
    }

    @Override
    public String removeGroup(String name) {
        return null;
    }
}
