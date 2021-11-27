package club.kwcoder.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableEurekaClient
//@ComponentScan("club.kwcoder")
//@MapperScan("club.kwcoder.server.mapper")
public class UserApplication {

    private static final Logger LOG = LoggerFactory.getLogger(UserApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(UserApplication.class);

        Environment env = app.run(args).getEnvironment();

        LOG.info("启动成功！！！");
        LOG.info("User地址：\thttp://127.0.0.1:{}", env.getProperty("server.port"));

    }

}
