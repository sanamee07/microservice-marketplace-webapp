package edu.fra.uas.service;

import edu.fra.uas.model.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.client.ClientGraphQlResponse;
import org.springframework.graphql.client.FieldAccessException;
import org.springframework.graphql.client.HttpSyncGraphQlClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private static final Logger log = LoggerFactory.getLogger(PostService.class);
    private static final String baseURI = "http://localhost:8083/graphql";
    private final HttpSyncGraphQlClient graphQlClient;

    public PostService() {
        this.graphQlClient = HttpSyncGraphQlClient.builder().url(baseURI).build();
    }

     // Protokolliert Fehler, falls die GraphQL-Antwort ungültig ist
    private void logExceptionalResponse(ClientGraphQlResponse response) {
        if (!response.isValid()) {
            log.error("Request failure ...");
        }
        response.getErrors().forEach(error -> log.error(error.getMessage()));
    }

      // Ruft alle Posts für einen bestimmten Benutzer und eine Anzeige über GraphQL ab
    public List<Post> getAllPostsByUserIdAndAdvertisementId(Long userId, Long advertisementId) {
        String query = "query { getAllPostsByUserId(userId: " + userId + ", advertisementId: "
                + advertisementId + ") { postId userId advertisementId platform link } }";

        try {
            return graphQlClient.document(query).retrieveSync("getAllPostsByUserId")
                    .toEntityList(Post.class);
        } catch (FieldAccessException ex) {
            ClientGraphQlResponse response = ex.getResponse();
            logExceptionalResponse(response);
        }
        return null;
    }

      // Erstellt einen neuen Post für einen Benutzer und eine Anzeige über GraphQL
    public Post createPost(Long userId, Long advertisementId, String platform, String link) {
        String mutation = "mutation { createPost(userId: " + userId + ", advertisementId: " + advertisementId
                + ", platform: \"" + platform.replace("\"", "\\\"") + "\", link: \"" + link.replace("\"", "\\\"")
                + "\") { postId userId advertisementId platform link } }";

        try {
            return graphQlClient.document(mutation).retrieveSync("createPost").toEntity(Post.class);
        } catch (FieldAccessException ex) {
            ClientGraphQlResponse response = ex.getResponse();
            logExceptionalResponse(response);
        }
        return null;
    }
}