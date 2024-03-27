package ApiLivro.Livro.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig {
    @Bean
    public OpenAPI customAp(){
        return new OpenAPI().info(new Info().title("LivroAPI").version("1.0.0")
                .license(new  License().name("Teste").url("www.qualquercoisa.com"))
        );
    }

}
