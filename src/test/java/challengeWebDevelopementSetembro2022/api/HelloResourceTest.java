package challengeWebDevelopementSetembro2022.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloResource.class)
class HelloResourceTest
{
    private final static String NAME = "Ada";

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test getHello Without Parameter and get String")
    public void testGetHello() throws Exception
    {
        this.mockMvc.perform(
                get("/test/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }

    @Test
    @DisplayName("Test getHelloWithNameParam, name = Ada and get String")
    public void testGetHelloWithNameParam() throws Exception
    {
        this.mockMvc.perform(
                get("/test/hello/" + NAME))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World and " + NAME));
    }

    @Test
    @DisplayName("Test postBodyWithName, name = Ada and get Json Obj")
    public void testPostBodyWithName() throws Exception
    {
       this.mockMvc.perform(
               post("/test/hello/body").content("{\n\"name\":\""+ NAME +"\"}")
                       .contentType(MediaType.APPLICATION_JSON))
               .andDo(print())
               .andExpect(status().isAccepted())
               .andExpect(content().string(containsString("{\"message\":\"Hello, Ada\",\"processedAt\":")));
    }
}