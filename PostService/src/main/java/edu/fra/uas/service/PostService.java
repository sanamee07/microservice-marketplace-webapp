package edu.fra.uas.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import edu.fra.uas.model.Post;
import edu.fra.uas.repository.PostRepository;

@Service
public class PostService {

    // Logger zur Debugging-Unterstützung
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PostService.class);

    // Repository zur Verwaltung von Posts
    @Autowired
    PostRepository postRepository;

    private long nextPostId = 1;


    // Erstellt einen neuen Post für einen bestimmten Benutzer und eine Anzeige.
    public Post createPost(long userId, long advertisementId, Post post) {
        log.debug("create Post: " + post.getPostId() + " for User: " + userId + "  and for Avertisement"
                + advertisementId);
        post.setUserId(userId);
        post.setPostId(nextPostId++);
        postRepository.put(post.getPostId(), post);
        return postRepository.get(post.getPostId());
    }
    
    // Ruft alle Posts eines Benutzers für eine bestimmte Anzeige ab.
    public Iterable<Post> getAllPostsByUserId(long userId, long advertisementId) {
        log.debug("getAllBookmarksByUserId" + userId);
        Iterable<Post> postIter = postRepository.values();
        ArrayList<Post> posts = new ArrayList<>();
        for (Post post : postIter) {
            if (post.getUserId() == userId && post.getAdvertisementId() == advertisementId) {
                posts.add(post);
            }
        }

        return posts;
    }
}