package ramon.course.kafka.spring.producer.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Value("${topic.meutopico}")
    private static String topicoBoraPraticar;

    @Autowired
    private KafkaTemplate<String, String> KafkaTemplate;

    public void sendMessage(String message) {
        logger.info("Menssage -> {}", message);
        logger.info("topicoBoraPraticar -> {}", topicoBoraPraticar);
        this.KafkaTemplate.send("topic_bora_praticar_kafka", message);
    }

    public static String getTopicoBoraPraticar() {
        return topicoBoraPraticar;
    }

    public static void setTopicoBoraPraticar(String topicoBoraPraticar) {
        MessageService.topicoBoraPraticar = topicoBoraPraticar;
    }
}
