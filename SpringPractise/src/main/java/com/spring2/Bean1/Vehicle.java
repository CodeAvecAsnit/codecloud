package com.spring2.Bean1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Vehicle {

@Value("#{FriendList}")
private List<String> friends;

public Vehicle() {}

public Vehicle(List<String> friends) {
    System.out.println("vehicle constructor");

    this.friends = friends;
}

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "[friends=" + friends + "]";
    }
}
