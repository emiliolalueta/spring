import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public class Pruebas {

	public static void main(String[] args) {

		ApplicationContext appCtx = new ClassPathXmlApplicationContext(
				"beans.xml");
		System.out.println("=======================================");

		
		MessageChannel channel = appCtx.getBean("messageChannel",
				MessageChannel.class);
		Message<String> message1 = MessageBuilder.withPayload(
				"Hello world - one!").build();
		Message<String> message2 = MessageBuilder.withPayload(
				"Hello world - two!").build();
		Message<String> message3 = MessageBuilder.withPayload(
				"Hello world - three!").build();
		System.out.println("sending message1");
		channel.send(message1);
		System.out.println("sending message2");
		channel.send(message2);
		System.out.println("sending message3");
		channel.send(message3);
		System.out.println("done sending messages");
		

	}

}
