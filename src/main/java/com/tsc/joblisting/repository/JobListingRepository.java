package com.tsc.joblisting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tsc.joblisting.model.JobPost;

public interface JobListingRepository extends MongoRepository<JobPost, String>{

}
