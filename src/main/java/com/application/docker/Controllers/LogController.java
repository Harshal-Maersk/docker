package com.application.docker.Controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    private static final String LOG_FILE_PATH = "/app/logs/app.log";

    @GetMapping("/logs")
    public ResponseEntity<String> getLogs() {
        try {
            // Check if the log file exists
            if (!Files.exists(Paths.get(LOG_FILE_PATH))) {
                return ResponseEntity.status(404).body("Log file not found");
            }

            // Read the log file and return its content in a HTML format
            String logs = Files.lines(Paths.get(LOG_FILE_PATH)).collect(Collectors.joining("<br/>"));
            return ResponseEntity.ok("<html><head><style>" +
                                     "body { font-family: monospace; white-space: pre; }" +
                                     ".log-entry { color: #333; }" +
                                     "</style></head><body>" +
                                     "<pre class='log-entry'>" + logs + "</pre>" +
                                     "</body></html>");
        } catch (IOException e) {
            // Return an error message if there's an issue reading the file
            return ResponseEntity.status(500).body("Unable to read log file");
        }
    }
}
