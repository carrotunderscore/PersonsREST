package com.example.personsrest.domain;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class PersonImpl implements Person {

    String id;
    String name;
    int age;
    String city;
    List<String> groups;

    public PersonImpl(String name, int age, String city, List<String> groups) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.city = city;
        this.groups = groups;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void setActive(boolean active) {

    }

    @Override
    public List<String> getGroups() {
        return groups;
    }

    @Override
    public void addGroup(String groupId) {
        this.groups.add(groupId);
    }

    @Override
    public void removeGroup(String groupId) {
        groups.removeIf(group -> group.equalsIgnoreCase(groupId));
    }
}
