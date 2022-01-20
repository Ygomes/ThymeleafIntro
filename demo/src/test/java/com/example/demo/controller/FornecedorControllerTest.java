package com.example.demo.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@SpringBootTest
@AutoConfigureMockMvc
public class FornecedorControllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testAddFornecedorForm() throws Exception {
        mockMvc.perform(get("/addFornecedorForm"))
                .andExpect(status().isOk())
                .andExpect(xpath("//form").exists())
                .andExpect(xpath("//input[@name='razaoSocial']").exists())
                .andExpect(xpath("//input[@name='cnpj']").exists())
                .andExpect(xpath("//input[@name='cep']").exists())
                .andExpect(xpath("//input[@name='logradouro']").exists())
                .andExpect(xpath("//input[@name='estado']").exists())
                .andExpect(xpath("//input[@name='cidade']").exists())
                .andExpect(xpath("//input[@name='bairro']").exists())
                .andExpect(xpath("//select[@name='tipo']").exists())
                .andExpect(xpath("//input[@name='numero']").exists())
                .andExpect(xpath("//textarea[@name='atividades']").exists())
                .andExpect(xpath("//input[@name='email']").exists())
                .andExpect(xpath("//input[@name='telefone']").exists());
    }
}
