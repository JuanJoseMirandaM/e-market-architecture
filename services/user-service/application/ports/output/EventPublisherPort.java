public interface EventPublisherPort {
    void publish(String topic, Object payload);
}