package com.tsc.joblisting.repository;

import java.util.List;

import com.tsc.joblisting.model.JobPost;

public interface SearchJobPostRepository {
	
	List<JobPost> findByText(String text);

}
