package com.json.netty;


import org.springframework.stereotype.Component;

import com.json.netty.util.PostRequestType;
import com.json.netty.util.ResponseType;
import com.json.netty.util.UserPojo;

@Component
public class PostBean {

    public UserPojo setValue(int id,String name) {
        // We create a new object of the ResponseType
        // Camel will be able to serialise this automatically to JSON
    	
    	System.out.println("INSIDE POST METHOD");
    	UserPojo user= new UserPojo();
    	user.setId(id);
    	user.setName(name);
        return user;
    }
}
