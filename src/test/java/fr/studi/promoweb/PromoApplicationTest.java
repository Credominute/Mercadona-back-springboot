package fr.studi.promoweb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.studi.promoweb.controller.ModelController;
import fr.studi.promoweb.model.Model;
import fr.studi.promoweb.repository.ModelRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static fr.studi.promoweb.PromoApplication.dureePromotion;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;


//@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PromoApplicationTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
    @Test
    public void dureePromotionTest() {
        assertEquals(3, dureePromotion(4, 1));
    }
   /* @InjectMocks
    private final ModelController modelController = new ModelController();
    @Mock
    private ModelRepository modelRepository;
    @Test
    public void testGetModelById() {
        when(modelRepository.findModelById(2))
                .thenReturn(new Model(2, "Yaourt", 7));
        assertThat(modelController.getModelById(2).getMarque(),
                is("Yaourt"));
    }*/
    /*@InjectMocks
    private final TestRestTemplate restTemplate = new TestRestTemplate();*/
    @Autowired private TestRestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAll() throws JsonProcessingException {
        ResponseEntity<String> reponse = this.restTemplate
                .getForEntity("http://localhost:8080/get/1", String.class);

        assertThat(reponse.getStatusCode(), equalTo(HttpStatus.OK));

        JsonNode reponseENJson = objectMapper.readTree(reponse.getBody());

        assertThat(reponseENJson.isMissingNode(), is(false));
        assertThat(reponseENJson.toString(),
                equalTo("{\"modelId\":1,\"marque\":\"Tiramisu\",\"prix\":7}"));
    }
}
