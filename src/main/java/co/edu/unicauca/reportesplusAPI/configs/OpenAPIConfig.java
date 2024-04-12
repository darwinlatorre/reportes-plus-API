package co.edu.unicauca.reportesplusAPI.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
        contact = @Contact(
            name = "Reportes Plus API",
            email = "reportesplus@unicauca.edu.co"
        ),
        title = "Reportes Plus API documentation for developers",
        version = "1.0",
        description = "Reportes Plus Backend documentation for developers",
        license = @License(
            name = "Apache-2.0 license",
            url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
        )
    ),
    servers = {
        @Server(
            description = "Development server",
            url = "http://localhost:8080/api/v1"
        ),
    }
)

public class OpenAPIConfig {
    
}
