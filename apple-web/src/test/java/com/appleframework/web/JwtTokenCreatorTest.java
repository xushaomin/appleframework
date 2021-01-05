package com.appleframework.web;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.auth0.jwt.interfaces.Claim;
import com.appleframework.web.jwt.JwtService;
import com.appleframework.web.jwt.impl.JwtServiceImpl;

import junit.framework.TestCase;

public class JwtTokenCreatorTest extends TestCase {

    @Test
    public void testCreate() {
        JwtService creator = new JwtServiceImpl();
        Map<String, String> data = new HashMap<>();
        data.put("id", "1");
        data.put("name", "jim");

        String token = creator.createJWT(data);

        System.out.println(token);

        Map<String, Claim> map = creator.verfiyJWT(token);
        System.out.println(map.get("name").asString());
    }
}
