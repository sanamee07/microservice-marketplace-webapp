package edu.fra.uas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import edu.fra.uas.model.Post;
import edu.fra.uas.service.PostService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostGraphqlController {

    private static final Logger log = LoggerFactory.getLogger(PostGraphqlController.class);

    @Autowired
    private PostService postService;

    // Abfrage (Query), um alle Posts für einen bestimmten Benutzer und eine Anzeige abzurufen
    @QueryMapping(name = "getAllPostsByUserId")
    public List<Post> getAllPostsByUserId(@Argument Long userId, @Argument Long advertisementId) {
        log.debug("getAllPostsByUserId() is called with userId: {} and advertisementId: {}", userId, advertisementId);
        Iterable<Post> postsIter = postService.getAllPostsByUserId(userId, advertisementId);
        List<Post> posts = new ArrayList<>();
        for (Post post : postsIter) {
            posts.add(post);
        }
        return posts;
    }

     // Mutation, um einen neuen Post zu erstellen
    @MutationMapping(name = "createPost")
    public Post createPost(@Argument Long userId, @Argument Long advertisementId, @Argument String link,
            @Argument String platform) {
        log.debug("createPost() is called with userId: {}, advertisementId: {}", userId, advertisementId);
        Post newPost = new Post();
        newPost.setAdvertisementId(advertisementId);
        newPost.setLink(link);
        newPost.setPlatform(platform);
        return postService.createPost(userId, advertisementId, newPost);

    }

}