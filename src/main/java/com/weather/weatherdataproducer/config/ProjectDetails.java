package com.weather.weatherdataproducer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ProjectDetails {

	private static final Logger log = LoggerFactory.getLogger(ProjectDetails.class);

	private final Environment environment;

	public ProjectDetails(Environment environment) {
		this.environment = environment;
	}

	public String getExachangeName() {
		return environment.getProperty("rabbitmq.exchange.name");
	}

	public String getQueueName() {
		return environment.getProperty("rabbitmq.queue.name");
	}

	public String getRoutingKey() {
		return environment.getProperty("rabbitmq.routing.key");
	}
}
