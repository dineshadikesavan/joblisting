package com.tsc.joblisting.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.tsc.joblisting.model.JobPost;

@Component
public class SearchJobPostRepositoryImpl implements SearchJobPostRepository {

	@Autowired
	MongoClient client;

	@Autowired
	MongoConverter converter;

	@Override
	public List<JobPost> findByText(String text) {
		List<JobPost> posts = new ArrayList<JobPost>();

		MongoDatabase database = client.getDatabase("jobsdb");
		MongoCollection<Document> collection = database.getCollection("jobpost");
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
				new Document("$search",
						new Document("index", "jobpostindex").append("text",
								new Document("query", text).append("path",
										Arrays.asList("technologies", "description", "profile")))),
				new Document("$sort", new Document("experience", 1L)), new Document("$limit", 2L)));

		result.forEach((doc) -> posts.add(converter.read(JobPost.class, doc)));
		
		return posts;
	}

}
