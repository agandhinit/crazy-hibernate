package com.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private OneRepository or;
    @Autowired
    private ManyRepository mr;
    
    private One one = new One();
    
    private MockMvc mockMvc;
    
    @Autowired
    private WebApplicationContext wac;

    
    @Before
    public void setUp() {
        
        one = or.save(one);
        
        Many many1 = new Many();
        many1.setManyKey(1L);
        many1.setOneKey(one.getOneKey());
        many1.setStatus("NEW");
        
        Many many2 = new Many();
        many2.setManyKey(2L);
        many2.setOneKey(one.getOneKey());
        many2.setStatus("NEW");
        
        mr.save(new HashSet<Many>(Arrays.asList(many1, many2)));
        
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        
    }
    
    @After
    public void tearDown() throws Exception {
        mr.deleteAll();
        or.deleteAll();
    }
    
    @Test
    public void test1(){
        System.out.println("Test1");
        System.out.println(or.findQuery1(one.getOneKey(), 1L));
        One one1 = or.findQuery2(one.getOneKey());
        for(Many many : one1.getMany()){
            System.out.println(many);
        }
    }
    
    @Test
    public void test2() throws Exception{
        System.out.println("Test2");
        MvcResult result = mockMvc.perform(get("/api/one?oneKey="+one.getOneKey()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();
    }

}
