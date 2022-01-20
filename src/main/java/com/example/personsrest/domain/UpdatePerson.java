package com.example.personsrest.domain;

import lombok.Value;

import java.util.List;

@Value
public class UpdatePerson {
        String name;
        String city;
        int age;
        List<String> groups;
}