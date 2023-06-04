package com.felipefaggian.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipefaggian.workshopmongo.domain.Post;
import com.felipefaggian.workshopmongo.repository.PostRepository;
import com.felipefaggian.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);

		Post newPost = new Post();

		newPost.setId(post.get().getId());
		newPost.setDate(post.get().getDate());
		newPost.setTitle(post.get().getTitle());
		newPost.setBody(post.get().getBody());
		newPost.setAuthor(post.get().getAuthor());
		newPost.setComments(post.get().getComments());
		
		if (post == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}

		return newPost;
	}
	
	public List<Post> finByTitle(String text) {
		return repo.findByTitleContainingIgnoreCase(text);
	}
}
