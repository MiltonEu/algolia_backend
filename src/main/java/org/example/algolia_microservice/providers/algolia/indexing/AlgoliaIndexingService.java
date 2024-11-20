package org.example.algolia_microservice.providers.algolia.indexing;

import com.algolia.api.SearchClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlgoliaIndexingService {

    SearchClient searchClient;

    public AlgoliaIndexingService(SearchClient searchClient) {
        this.searchClient = searchClient;
    }

    public <T> void updateObjects(String indexName, List<T> objects) {
        if(objects == null ||  objects.isEmpty()) {
            return;
        }
        searchClient.saveObjects(indexName, objects);
    }
}
