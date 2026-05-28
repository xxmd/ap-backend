package com.example.ad.controller;

import com.example.ad.entity.ClientRequest;
import com.example.ad.entity.Metadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/APCtrl/v1")
public class StrategyController {
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/checkPackage")
    public ResponseEntity checkPackage(@RequestBody Map<String, Object> payload) throws IOException {
        System.out.println("payload: " + objectMapper.writeValueAsString(payload));
        String responseJsonFile = "response_checkPackage.json";
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:" + responseJsonFile);
        Map<String, Object> jsonMap = objectMapper.readValue(
                resource.getInputStream(),
                new TypeReference<Map<String, Object>>() {
                }
        );
        return ResponseEntity.ok(jsonMap);
    }

    @PostMapping("/getTask")
    public ResponseEntity getTask(@RequestBody Map<String, Object> payload) throws IOException {
        System.out.println("payload: " + objectMapper.writeValueAsString(payload));
        String responseJsonFile = "response_getTask.json";
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:" + responseJsonFile);
        Map<String, Object> jsonMap = objectMapper.readValue(
                resource.getInputStream(),
                new TypeReference<Map<String, Object>>() {
                }
        );
        return ResponseEntity.ok(jsonMap);
    }

    @PostMapping("/getStrategy")
    public ResponseEntity getStrategy(@RequestBody Map<String, Object> payload) throws IOException {
        System.out.println("payload: " + objectMapper.writeValueAsString(payload));
        String responseJsonFile = "response_getStrategy.json";
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:" + responseJsonFile);
        Map<String, Object> jsonMap = objectMapper.readValue(
                resource.getInputStream(),
                new TypeReference<Map<String, Object>>() {
                }
        );
        return ResponseEntity.ok(jsonMap);
    }

    @PostMapping("/behavior")
    public ResponseEntity behavior(@RequestBody Map<String, Object> payload) throws IOException {
        System.out.println("payload: " + objectMapper.writeValueAsString(payload));
        String responseJsonFile = "response_getStrategy.json";
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:" + responseJsonFile);
        Map<String, Object> jsonMap = objectMapper.readValue(
                resource.getInputStream(),
                new TypeReference<Map<String, Object>>() {
                }
        );
        return ResponseEntity.ok(jsonMap);
    }
}
