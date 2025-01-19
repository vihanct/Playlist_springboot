package com.spotify.application.configuration;

import com.spotify.application.CsvReader;
import com.spotify.application.Playlist;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfiguration {

    @Bean
    public CsvReader getcsvReader(){
        return new CsvReader();
    }
    @Bean
    @Primary
    public Playlist getplaylist(){
        return new Playlist();
    }
}
