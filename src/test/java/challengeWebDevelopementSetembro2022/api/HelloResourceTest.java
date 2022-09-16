package challengeWebDevelopementSetembro2022.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloResource.class)
class HelloResourceTest
{
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
        String name;

        name = "Ada";
        this.mockMvc.perform(
                get("/test/hello/" + name))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World and " + name));
    }
}