package expedientesx.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*
<beans>
	<mvc:annotation-driven/>
	<context:component-scan base-package="com.curso.controlador"/>
	
	<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	  <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"></property>
	  <property name="prefix" value="/WEB-INF/paginas/"></property>
	  <property name="suffix" value=".jsp"></property>        
	</bean>
</beans>
*/

@EnableWebMvc
@Configuration
@ComponentScan(basePackages={ "expedientesx.controlador" })
public class ConfiguracionMVC extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }	
	
}
