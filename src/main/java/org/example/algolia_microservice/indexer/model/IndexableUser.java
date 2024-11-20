package org.example.algolia_microservice.indexer.model;

public class IndexableUser extends AbstractIndexableObject {

    private String firstName;
    private String lastName;
    private String email;

    public IndexableUser(String objectId, String firstName, String lastName, String email) {
        super(objectId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}