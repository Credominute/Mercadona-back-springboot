package fr.studi.promoweb;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.studi.promoweb.pojo.Promotion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PromotionTests {

	// Test unitaire : test d'un composant
	// Mock : simulation d'une requête HTTP (CRUD API sur éléments)

	private MockMvc mockMvc;

	private Promotion promotion = new Promotion(LocalDate.now(),LocalDate.now().plusDays(31), 88L);

	private ObjectMapper objectMapper;
	@Test
	public void createPromotion() throws Exception {

		//Conversion de l'objet Promotion en JSON
		String requestJson = objectMapper.writeValueAsString(this.promotion);

		//envoi du JSON à l'API pour une création
		this.mockMvc.perform(
				post("/promotion")
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestJson))
				.andExpect(status().isOk());
		this.getAllPromotion();
	}

	@Test
	public void getAllPromotion() throws Exception {
		MvcResult mvcResult = (MvcResult) mockMvc.perform(MockMvcRequestBuilders
				.get("/promotion")
		);
		Promotion newPromotion = objectMapper
				.readValue(mvcResult.getResponse().getContentAsString(), Promotion.class);
		this.promotion.setPromotion_id(newPromotion.getPromotion_id());
	}
	@Test
	public void getPromotion() throws Exception {
		MvcResult mvcResult = (MvcResult) mockMvc.perform(MockMvcRequestBuilders
				.get("/promotion" + this. promotion.getPromotion_id())
		);

		objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Promotion.class);
	}
	@Test
	public void updatePromotion(){

	}
	@Test
	public void deletePromotion() throws Exception {
				this.mockMvc.perform(MockMvcRequestBuilders
						.delete("/promotion" +this.promotion.getPromotion_id())
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
