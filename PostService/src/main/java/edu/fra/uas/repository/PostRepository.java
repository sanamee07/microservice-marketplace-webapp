package edu.fra.uas.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import edu.fra.uas.model.Post;

@Repository
public class PostRepository extends HashMap<Long, Post>{

}