package org.example.algolia_microservice.providers.algolia.search;

import com.algolia.api.SearchClient;
import org.springframework.stereotype.Service;

@Service
public class AlgoliaSearchService {

    SearchClient searchClient;

    public AlgoliaSearchService(SearchClient searchClient) {
        this.searchClient = searchClient;
    }

//    public <T> SearchResponse<T> search(String indexName, String query) {
//        SearchResponses<Hit> responses = searchClient.search( new SearchMethodParams()
//                .setRequests(List.of(new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setHitsPerPage(50))),
//        Hit.class
//        );
//
//        return responses;
//    }
}
