package tr.com.soagen.utility;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
@ComponentScan(basePackages="tr.com.soagen")
public class ApplicationConfiguration {
	
	@Bean
	public MongoDbFactory mongoDbFactory () throws UnknownHostException {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		return new SimpleMongoDbFactory(mongoClient, "libDb");
	}
	
	@Bean
	public MongoTemplate mongoTemplate () throws UnknownHostException {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		return mongoTemplate;
	}
	
}
