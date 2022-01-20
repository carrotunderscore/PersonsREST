package com.example.personsrest.remote;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class CreateGroup {
    String name;

    @JsonCreator
    public CreateGroup(@JsonProperty("name") String name) {
        this.name = name;
    }
}
