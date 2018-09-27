package io.pivotal.demos.bus;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringCloudBusDemoApplicationTests {
    public static final String NEW_CMD_KEY = "new-cmd";
    public static final String NEW_COMMAND = "New Command";
    public static final String ACTUATOR_NEW_COMMAND_URL = "/actuator/new-command";

    @Value("${spring.rabbitmq.addresses: localhost}")
    private String rabbitHost;

    @Value("${spring.rabbitmq.username: guest}")
    private String rabbitUser;

    @Value("${spring.rabbitmq.password: guest}")
    private String rabbitPassword;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void verifyRmq() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory(rabbitHost);
        connectionFactory.setUsername(rabbitUser);
        connectionFactory.setPassword(rabbitPassword);

        Assert.assertTrue(connectionFactory.createConnection().isOpen());

        connectionFactory.destroy();
    }

    @Test
    public void testBusBroadcast() {
        Map<String,String> actuatorPostRequestMap = new HashMap<>();
        actuatorPostRequestMap.put("name", NEW_CMD_KEY);
        actuatorPostRequestMap.put("value", NEW_COMMAND);

        RequestEntity<Map<String,String>> requestEntity =
                RequestEntity.post(URI.create(ACTUATOR_NEW_COMMAND_URL))
                        .body(actuatorPostRequestMap);

        Assert.assertEquals(
                HttpStatus.NO_CONTENT,
                restTemplate.exchange(requestEntity,Object.class)
                    .getStatusCode());
    }


    @Test
    public void testBusBroadcastHandled() {
        ResponseEntity<Map> responseEntity =
                restTemplate.getForEntity(ACTUATOR_NEW_COMMAND_URL,
                        Map.class);

        Assert.assertEquals(
                HttpStatus.OK,
                responseEntity.getStatusCode()
        );

        Assert.assertEquals(
                NEW_COMMAND,
                (String)responseEntity.getBody().get(NEW_CMD_KEY)
        );
    }
}
