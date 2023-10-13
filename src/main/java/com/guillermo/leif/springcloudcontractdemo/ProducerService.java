package com.guillermo.leif.springcloudcontractdemo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

public class ProducerService {
    @RestController
    public class ProducerController {
        @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Map<String, String>> getJsonMessage() {
            Map<String, String> response = Collections.singletonMap("message", "Hello JSON");
            return ResponseEntity.ok(response);
        }

        @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
        public ResponseEntity<Message> getXmlMessage() {
            Message response = new Message("Hello XML");
            return ResponseEntity.ok(response);
        }
    }

    @JacksonXmlRootElement
    class Message {
        private String message;

        public Message() { }  // JAXB needs a no-arg constructor

        public Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}
