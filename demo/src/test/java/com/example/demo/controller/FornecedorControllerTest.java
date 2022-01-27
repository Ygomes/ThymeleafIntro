package com.example.demo.controller;


import com.example.demo.Entity.Fornecedor;
import com.example.demo.Entity.Representante;
import com.example.demo.Repository.FornecedorRepository;
import com.sun.istack.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FornecedorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Test
    public void testGetAllFornecedor() throws Exception {
        mockMvc.perform(get("/list"))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddFornecedorForm() throws Exception {
        mockMvc.perform(get("/fornecedor"))
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

    @Test
    public void testUpdateDeleteFornecedor() throws Exception {
        Long id = creatFornecedor().getId();
        mockMvc.perform(get(String.format("/update?fornecedorId=%d", id)))
                .andExpect(status().isOk());
        mockMvc.perform(get(String.format("/del?fornecedorId=%d", id)))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("list"));
    }

    @Test
    public void testRepresentanteForm() throws Exception {
        MockHttpServletRequestBuilder createRepresentanteForm = post("/fornecedor")
                .param("addRepresentante", "11");
        mockMvc.perform(createRepresentanteForm)
                .andExpect(status().isOk())
                .andExpect(xpath("//input[@name='representante[0].nome']").exists())
                .andExpect(xpath("//input[@name='representante[0].cpf']").exists())
                .andExpect(xpath("//select[@name='representante[0].cargo']").exists());
    }

    @Test
    public void testSaveFornecedor() throws Exception {
        MockHttpServletRequestBuilder createFornecedor = post("/fornecedor").param("save", "1");
        mockMvc.perform(createFornecedor)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("list"));
    }

    @NotNull
    private Fornecedor creatFornecedor() {
        List<Representante> newRepresentante = new ArrayList<>();
        final Fornecedor fornecedor = new Fornecedor();
        fornecedor.setAtividades(new Random().toString());
        fornecedor.setBairro(new Random().toString());
        fornecedor.setCep(new Random().toString());
        fornecedor.setCnpj(new Random().toString());
        fornecedor.setLogradouro(new Random().toString());
        fornecedor.setEmail(new Random().toString());
        fornecedor.setEstado(new Random().toString());
        fornecedor.setCidade(new Random().toString());
        fornecedor.setTelefone(new Random().toString());
        fornecedor.setTipo(new Random().toString());
        fornecedor.setRepresentante(newRepresentante);
        fornecedorRepository.save(fornecedor);
        return fornecedor;
    }
}
