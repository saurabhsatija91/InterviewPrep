package Multithreading;

public class ProducerConsumer1 {
	public static void main(String[] args) {
		BufferClass1 buffer = new BufferClass1();
		ProduceInteger1 producer = new ProduceInteger1(buffer);
		ConsumeInteger1 consumer = new ConsumeInteger1(buffer);
		producer.start();
		consumer.start();
	}
}
