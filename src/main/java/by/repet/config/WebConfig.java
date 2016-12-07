package by.repet.config;//Created by vladr on 27.11.2016.

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan({ "by.repet.config", "by.repet.controllers" })
//@Import({ AppSecurityConfig.class })
public class WebConfig {
}
