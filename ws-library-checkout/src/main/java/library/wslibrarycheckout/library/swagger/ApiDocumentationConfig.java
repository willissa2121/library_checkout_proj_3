package library.wslibrarycheckout.library.swagger;


import io.swagger.annotations.*;

@SwaggerDefinition(info = @Info(description = "Library Checkout Proj ", version = "V12.0.12", title = "Library Checkout Proj", contact = @Contact(name = "Library Checkout proj group", email = "libraryGroup@gmail.com", url = "http://google.com"), license = @License(name = "Baylor Library Group", url = "http://google.com")), consumes = {
        "application/json", "application/xml" }, produces = { "application/json", "application/xml" }, schemes = {
        SwaggerDefinition.Scheme.HTTP,
        SwaggerDefinition.Scheme.HTTPS }, externalDocs = @ExternalDocs(value = "Read This For Sure", url = "http://google.com"))
public interface ApiDocumentationConfig {
}

