import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public class PruebasFiltroXml {

	public static void main(String[] args) {

		ApplicationContext appCtx = new ClassPathXmlApplicationContext(
				"beansFiltroXPath.xml");
		System.out.println("=======================================");

		

	}

}
