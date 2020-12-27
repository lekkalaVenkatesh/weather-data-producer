package com.weather.weatherdataproducer.rabbitmq;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.weather.weatherdataproducer.config.ProjectDetails;
import com.weather.weatherdataproducer.dto.WeatherDataDto;
import com.weather.weatherdataproducer.enums.ObservatoryEnum;

@Service
public class WeatherDataMessageSender {

	private static final Logger log = LoggerFactory.getLogger(WeatherDataMessageSender.class);

	private final RabbitTemplate rabbitTemplate;
	
	private final ProjectDetails projectDetails;

	public WeatherDataMessageSender(final RabbitTemplate rabbitTemplate, ProjectDetails projectDetails) {
		this.rabbitTemplate = rabbitTemplate;
		this.projectDetails = projectDetails;
	}

	@Scheduled(fixedDelay = 30L)
	public void sendMessage() {
		final var message = getMockedMessage().getFormattedMessage();
		log.info("Sending message..." + message);
		rabbitTemplate.convertAndSend(projectDetails.getExachangeName(),
				projectDetails.getRoutingKey(), message);
	}

	/*
	 * This method is written in a most generic way to generate the Mock data
	 */
	
	WeatherDataDto getMockedMessage() {
		int xCoordinate = ThreadLocalRandom.current().nextInt(0, 1000);
		int yCoordinate = ThreadLocalRandom.current().nextInt(0, 1000);
		String location = xCoordinate+","+yCoordinate;
		int temperature = ThreadLocalRandom.current().nextInt(0, 373);
		ObservatoryEnum observatoryEnum = ObservatoryEnum.values()[(int)(Math.random()*ObservatoryEnum.values().length)];
		WeatherDataDto weatherData = new WeatherDataDto(LocalDateTime.now(), location, temperature,observatoryEnum.name());
		return weatherData;
	}
}
