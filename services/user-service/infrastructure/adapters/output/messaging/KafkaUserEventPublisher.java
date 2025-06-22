
@Component
public class KafkaUserEventPublisher implements EventPublisherPort {

    private final KafkaTemplate<String, Object> kafka;

    public KafkaUserEventPublisher(KafkaTemplate<String, Object> kafka) {
        this.kafka = kafka;
    }

    @Override public void publish(String topic, Object payload) {
        kafka.send(topic, payload);
    }
}