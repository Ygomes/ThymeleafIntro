package com.example.demo.Controller;

import com.example.demo.Entity.Fornecedor;
import com.example.demo.Entity.Representante;
import com.example.demo.Repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FornecedorController {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @GetMapping({"/", "/list"})
    public ModelAndView getAllFornecedor() {
        ModelAndView mav = new ModelAndView("list-fornecedor");
        List<Fornecedor> list = fornecedorRepository.findAll();
        mav.addObject("fornecedor", list);
        return mav;
    }

    @GetMapping("/addFornecedorForm")
    public ModelAndView addFornecedor() {
        ModelAndView mav = new ModelAndView("add-fornecedor-form");
        Fornecedor newFornecedor = new Fornecedor();
        Representante newRepresentante = new Representante();
        mav.addObject("representante", newRepresentante);
        mav.addObject("fornecedor", newFornecedor);
        return mav;
    }

    @PostMapping("/saveFornecedor")
    private String saveFornecedor(@ModelAttribute Fornecedor fornecedor) {
        fornecedorRepository.save(fornecedor);
        return "redirect:/list";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long fornecedorId) {
        ModelAndView mav = new ModelAndView("add-fornecedor-form");
        Fornecedor fornecedor = fornecedorRepository.findById(fornecedorId).get();
        mav.addObject("fornecedor", fornecedor);
        return mav;
    }

    @GetMapping("/deleteFornecedor")
    public String deleteFornecedor(@RequestParam Long fornecedorId) {
        fornecedorRepository.deleteById(fornecedorId);
        return "redirect:/list";
    }


}
