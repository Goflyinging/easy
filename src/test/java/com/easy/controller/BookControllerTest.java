package com.easy.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.easy.domain.Book;
import com.easy.service.BookService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/***
 * Created on 2017/11/3 <br>
 * Description: <br>
 * @author easy
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookControllerTest {

  private MockMvc mockMvc;//虚拟出mvc环境

  @Mock
  private BookService bookService;


  @InjectMocks
  private BookController bookController;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
  }

  @After
  public void after() throws Exception {

  }


  @Test
  public void whenCreateBookSuccess() throws Exception {

    when(bookService.insert(any(Book.class))).thenReturn(1);

    String content = "{\"bookName\":\"spring\",\"author\":\"spring\",\"price\": 50}";
    mockMvc.perform(MockMvcRequestBuilders.post("/books")
        .contentType(MediaType.APPLICATION_JSON_UTF8)//请求头
        .content(content))//请求体
        .andExpect(MockMvcResultMatchers.status().isCreated())//201
        .andExpect(MockMvcResultMatchers.jsonPath("$.bookName").value("spring"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("spring"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("50.0"));//返回json串

  }

  @Test
  public void whenCreateBookFail() throws Exception {

    when(bookService.insert(any(Book.class))).thenReturn(0);

    String content = "{\"bookName\":\"spring\",\"author\":\"spring\",\"price\": 50}";
    mockMvc.perform(MockMvcRequestBuilders.post("/books")
        .contentType(MediaType.APPLICATION_JSON_UTF8)//请求头
        .content(content))//请求体
        .andExpect(MockMvcResultMatchers.status().isInternalServerError())//201
        .andExpect(MockMvcResultMatchers.jsonPath("$.bookName").value("spring"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("spring"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("50.0"));//返回json串
  }


}