package com.spotify.application;

import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class CsvReader {
    public List<List<String>> readCSV(String filename) {
        try (InputStream inputstream = getClass().getClassLoader().getResourceAsStream(filename);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream))) {
            
            if (inputstream == null) {
                throw new IOException("File not found: " + filename);
            }
            
            return reader.lines()
                    .map(line -> Arrays.asList(line.split(",")))
                    .collect(Collectors.toList());
                    
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
