package com.example.demo.Controller;

import com.example.demo.Entity.Fornecedor;
import com.example.demo.Entity.Representante;
import com.example.demo.Repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class FornecedorController {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @GetMapping({"/list"})
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
        newFornecedor.getRepresentanteList().add(new Representante());
        mav.addObject("fornecedor", newFornecedor);
        return mav;
    }

    @RequestMapping(value = "/addFornecedorForm", params = {"save"})
    private void saveFornecedor(@ModelAttribute Fornecedor fornecedor, HttpServletResponse response) throws IOException {
        fornecedorRepository.save(fornecedor);
        response.sendRedirect("list");
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long fornecedorId) {
        ModelAndView mav = new ModelAndView("add-fornecedor-form");
        Fornecedor fornecedor = fornecedorRepository.findById(fornecedorId).get();
        mav.addObject("fornecedor", fornecedor);
        return mav;
    }

    @GetMapping("/deleteFornecedor")
    public void deleteFornecedor(@RequestParam Long fornecedorId, HttpServletResponse response) throws IOException {
        fornecedorRepository.deleteById(fornecedorId);
        response.sendRedirect("list");
    }

    @RequestMapping(value = "/addFornecedorForm", params = {"addRepresentante"})
    public ModelAndView addRepresentante(Fornecedor fornecedor) {
        ModelAndView mav = new ModelAndView("add-fornecedor-form");
        fornecedor.getRepresentanteList().add(new Representante());
        return mav;

    }

    @RequestMapping(value = "/addFornecedorForm", params = {"removeRepresentante"})
    public ModelAndView removeRepresentante(Fornecedor fornecedor, HttpServletRequest req) {
        final Integer representanteID = Integer.valueOf(req.getParameter("removeRepresentante"));
        fornecedor.getRepresentanteList().remove(representanteID.intValue());
        ModelAndView mav = new ModelAndView("add-fornecedor-form");
        mav.addObject(fornecedor);
        return mav;
    }
}
