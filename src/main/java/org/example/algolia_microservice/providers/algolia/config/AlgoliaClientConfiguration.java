package org.example.algolia_microservice.providers.algolia.config;

import com.algolia.api.SearchClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlgoliaClientConfiguration {


    @Value("${algolia.api-key}")
    private String algoliaApiKey;

    @Value("${algolia.id}")
    private String algoliaAppId;


    @Bean
    public SearchClient algoliaSearchApiClient() {
        return new SearchClient(algoliaAppId, algoliaApiKey);
    }
}
