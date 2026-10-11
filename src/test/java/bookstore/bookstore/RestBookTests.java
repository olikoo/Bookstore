package bookstore.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class RestBookTests {
    
    @Autowired 
    private MockMvc mockMvc;
    
    @Test 
    void getBooksNoError() throws Exception {
        mockMvc.perform(get("/books"))  // fails because no privilege from WebSecConfig
            .andExpect(status().isOk());
    }
}
