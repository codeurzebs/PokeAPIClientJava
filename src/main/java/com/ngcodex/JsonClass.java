package com.ngcodex;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

    public class JsonClass {
        private static final ObjectMapper objectMapper = new ObjectMapper();

        public static List<Map<String, Object>> parseJsonList(String json) {
            try {
                Map<String, Object> responseAsMap = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {});
                return Collections.singletonList(responseAsMap);
            } catch (IOException e) {
                e.printStackTrace();
                return Collections.emptyList();
            }
        }
        public static Map<String, Object> parseJsonObject(String json) throws IOException {
            return objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {});
        }
    }

