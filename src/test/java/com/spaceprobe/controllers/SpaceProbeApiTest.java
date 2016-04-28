package com.spaceprobe.controllers;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import junit.framework.TestCase;

@Ignore
public class SpaceProbeApiTest extends TestCase {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String url = "http://localhost:8080/spaceprobe";

    @Test
    public void testCreateContactWithCustomer() throws Exception {
        restTemplate.postForLocation(url, request());
       
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);
        assertNotNull(response);

    }

    private String request() {
        return "5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM";
    }

}
