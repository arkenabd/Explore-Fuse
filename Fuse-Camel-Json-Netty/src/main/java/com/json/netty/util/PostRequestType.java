package com.json.netty.util;

/**
 * This is a POJO which defines a response format.
 * This allows Camel to serialise the response into JSON, using the Jackson library.
 */
public class PostRequestType {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
