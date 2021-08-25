package catpet;

import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Cat {

    String url = "https://petstore.swagger.io/v2/pet";

    public String lerJson (String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void incluirCat() throws IOException {
        String bodyJson = lerJson("db/cat1.json");

        
        given() //DADO
                .contentType("application/json")
                .log().all()
                .body(bodyJson)

        .when() //QUANDO
                .post(url)

        .then() // ENTAO
                .log().all()
                .statusCode(200)
        ;
    }
}
