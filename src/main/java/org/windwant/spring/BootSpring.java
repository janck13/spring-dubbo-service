package org.windwant.spring;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Slf4jReporter;
import org.joda.time.LocalTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 * @RestController = @Controller + @ResponseBody
 * @SpringBootApplication = @Configration +  @EnableAutoConfiguration + @ComponentScan
 * @ServletComponentScan scan servlet filter interceptor listener
 */
@SpringBootApplication
@ServletComponentScan
@PropertySource({"classpath:config.properties"})
//@EnableScheduling //定时任务
public class BootSpring
{
    public static void main( String[] args )
    {
        LocalTime localTime = new LocalTime();
        System.out.println( "Hello World!" + localTime.toString());
        localTime = localTime.plusHours(1);
        System.out.println("Hello agin World!" + localTime.toString());
        SpringApplication sa = new SpringApplication(BootSpring.class);
//        sa.addListeners(new DevAppListener());//注册Listener
        ApplicationContext ctx = sa.run(args);

//        启用console metric 输出
//        ConsoleReporter reporter = ctx.getBean(ConsoleReporter.class);
//        reporter.start(1, TimeUnit.SECONDS);

        //slf4jReporter metric 输出
//        Slf4jReporter reporterSJ = ctx.getBean(Slf4jReporter.class);
//        reporterSJ.start(1, TimeUnit.SECONDS);
    }
}
