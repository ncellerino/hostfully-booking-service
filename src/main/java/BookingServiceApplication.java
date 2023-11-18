package com.hostfully;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hostfully")
public class BookingServiceApplication {
  public static void main(String[] args) {

    SpringApplication.run(BookingServiceApplication.class, args);
  }
}
