import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTest {

    @Test
    @DisplayName("Listar todos os usuários com sucesso e validar o status code como 200")
    public void listarUsuarios(){
        RestAssured.baseURI = "https://serverest.dev/";
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .get("usuarios")
                .then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    @DisplayName("Realizar cadastro usuário")
    public void realizarCadastroUsuario(){
        RestAssured.baseURI = "https://serverest.dev/";
        UsuarioDTO usuarioDTO = new UsuarioDTO("David Celani", "davidcelani@mail.com", "senhateste117", "true");
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(usuarioDTO)
                .when().post("usuarios")
                .then().statusCode(201);
    }

}
