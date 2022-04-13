package library.wslibrarycheckout.library.swagger;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact(
            "Library Checkout Proj group", "http://google.com", "ourgroupproj.gmail.com");

    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "Library Checkout Group Project",
            "APIs to create, update, delete, and list Books on the library",
            "1.0",
            "urn:tos", DEFAULT_CONTACT,
            "Group", "http//google.com");

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<String>(Arrays.asList("application/json"));

    @Bean
    public Docket demoApi() {
        return new Docket(DocumentationType.SWAGGER_2)// <3>
                .select()// <4>
                .apis(RequestHandlerSelectors.any())// <5>
                .paths(Predicates.not(PathSelectors.regex("/error.*")))// <6>, regex must be in double quotes.
                .build().apiInfo(DEFAULT_API_INFO).produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }

}
