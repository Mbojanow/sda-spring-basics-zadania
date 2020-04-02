package pl.sdacademy.springtasks;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class HelloWorldControllerTest {

  private MockMvc mockMvc;

  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    objectMapper = new ObjectMapper();
  }

  @Test
  void shouldInsertTwoHellosAndGetAll() throws Exception {
    saveHelloAndAssertIsCreated("hi");
    saveHelloAndAssertIsCreated("hello");

    final MvcResult mvcResult = mockMvc.perform(get("/api/hellos").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
        .andReturn();

    final byte[] hellos = mvcResult.getResponse().getContentAsByteArray();
    final Hellos actualHellos = objectMapper.readValue(hellos, Hellos.class);
    assertThat(actualHellos.getHellos())
        .hasSize(2)
        .anyMatch(hello -> hello.getMessage().equals("hi"))
        .anyMatch(hello -> hello.getMessage().equals("hello"));
  }

  private void saveHelloAndAssertIsCreated(final String helloMessage) throws Exception {
    final MvcResult mvcResult = mockMvc.perform(post("/api/hellos")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(new Hello(helloMessage)))
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
        .andReturn();

    final byte[] contentA = mvcResult.getResponse().getContentAsByteArray();
    final Hello hello = objectMapper.readValue(contentA, Hello.class);
    assertThat(hello.getMessage()).isEqualTo(helloMessage);
  }

  @Test
  void shouldGetInsertedHelloMessageByIndex() throws Exception {
    saveHelloAndAssertIsCreated("hi");

    assertHello(0, "hi");
  }

  private void assertHello(final int index, final String expectedMessage) throws Exception {
    mockMvc.perform(get("/api/hellos/" + index).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.message").value(expectedMessage));
  }

  @Test
  void shouldUpdateMessageByIndex() throws Exception {
    saveHelloAndAssertIsCreated("hi");
    saveHelloAndAssertIsCreated("hello");

    mockMvc.perform(put("/api/hellos/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(new Hello("newHello")))
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent());

    assertHello(1, "newHello");
  }

  @Test
  void shouldDeleteMessageByIndex() throws Exception {
    saveHelloAndAssertIsCreated("hi");
    saveHelloAndAssertIsCreated("hello");

    mockMvc.perform(delete("/api/hellos/1"))
        .andExpect(status().isNoContent());

    final MvcResult mvcResult = mockMvc.perform(get("/api/hellos").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
        .andReturn();
    final byte[] hellos = mvcResult.getResponse().getContentAsByteArray();
    final Hellos actualHellos = objectMapper.readValue(hellos, Hellos.class);
    assertThat(actualHellos.getHellos()).hasSize(1).anyMatch(hello -> hello.getMessage().equals("hi"));
  }

  @Test
  void shouldNotUserRestController() {
    final Controller annotation = HelloWorldController.class.getDeclaredAnnotation(Controller.class);

    assertThat(annotation).isNotNull();
  }
}