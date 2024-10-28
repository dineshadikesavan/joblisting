package com.tsc.joblisting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tsc.joblisting.model.JobPost;
import com.tsc.joblisting.repository.JobListingRepository;
import com.tsc.joblisting.repository.SearchJobPostRepository;

@RestController
public class JobListingController {

	@Autowired
	JobListingRepository jobListingRepository;
	
	@Autowired
	SearchJobPostRepository srchJobPostRepository;

	@GetMapping("/posts")
	public List<JobPost> getAllPosts() {
		System.out.println("in the beginning of getAllPosts");
		return jobListingRepository.findAll();
	}

	@PostMapping("/post")
	public JobPost addPost(@RequestBody JobPost post) {
		return jobListingRepository.save(post);
	}

	@GetMapping("/post/{id}")
	public Optional<JobPost> getPost(@PathVariable(name = "id") String id) {
		System.out.println("Id :::::::::::: " + id);
		return jobListingRepository.findById(id);
	}
	
	@GetMapping("/posts/{text}")
	public List<JobPost> searchJobPost(@PathVariable(name = "text") String text){
		return srchJobPostRepository.findByText(text);
	}

}
