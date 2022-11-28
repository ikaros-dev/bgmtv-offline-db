package run.ikaros.offlinedb.bgmtv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket openApiDocket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .groupName("bgmtv-offline-db-openApi")
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("run.ikaros.offline.db.bgmtv.controller"))
                .build();
    }


    private ApiInfo apiInfo() {
        Contact contact = new Contact("li-guohao", "https://github.com/li-guohao",
                "git@liguohao.cn");
        return new ApiInfoBuilder()
                .title("BgmTv Offline DB Open API Documentation")
                .description("Documentation for BgmTv Offline DB Open API")
                .version("V1")
                .termsOfServiceUrl("https://github.com/ikaros-dev")
                .contact(contact)
                .license("GNU AFFERO GENERAL PUBLIC LICENSE V3.0")
                .licenseUrl("https://github.com/ikaros-dev/bgmtv-offline-db/blob/master/LICENSE")
                .build();
    }
}
