package org.example.algolia_microservice.indexer.model;

public abstract class AbstractIndexableObject {

    private String objectID;

    public AbstractIndexableObject(String objectID) {
        this.objectID = objectID;
    }

    public String getObjectID() {
        return objectID;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }
}
