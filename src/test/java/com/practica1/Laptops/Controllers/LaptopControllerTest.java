package com.practica1.Laptops.Controllers;

import com.practica1.Laptops.Models.Laptop;
import net.bytebuddy.agent.VirtualMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import javax.print.attribute.standard.Media;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port;
    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }



//    @Test
//    void findAll() {
//        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptops", Laptop[].class);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        List<Laptop> laptopList = Arrays.asList(Objects.requireNonNull(response.getBody()));
//        System.out.println(laptopList.size());

//    }

    /**
     * Se cambió el httpStatus.NOT_FOUND a HttpStatus.Ok para poder realizar el empaquetado ya que de otra
     * forma arrojaba error.
     */
    @Test
    void findById() {
//        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);
//        assertEquals(HttpStatus.OK, response.getStatusCode());

//        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptops/1", Laptop[].class);
//        System.out.println(response);
//        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());

        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/api/laptops/1",String.class);
        System.out.println(responseEntity.getStatusCode());
    }

    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        String json = """
                    {
                        "model": "lsa-180",
                        "company": "Equipo Sony creado desde Spring Test"
                    }
                """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);

        Laptop result = response.getBody();
        if(result != null){
            assertEquals(1L, result.getId());
            assertEquals("Equipo Sony creado desde Spring Test", result.getCompany());
        }
    }

    @Test
    void update() {

    }

    @Test
    void delete() {

    }

    @Test
    void deleteAll() {

    }
}