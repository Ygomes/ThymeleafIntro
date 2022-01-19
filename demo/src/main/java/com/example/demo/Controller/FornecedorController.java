package com.example.demo.Controller;

import com.example.demo.Entity.Fornecedor;
import com.example.demo.Entity.Representante;
import com.example.demo.Repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
        mav.addObject("fornecedor", newFornecedor);
        return mav;
    }

    @PostMapping(value = "/addFornecedorForm", params = {"save"})
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

    @RequestMapping(value = "/addFornecedorForm", params = {"addRepresentante"})
    public ModelAndView addRepresentante(Fornecedor fornecedor, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView("add-fornecedor-form");
        fornecedor.getRepresentanteList().add(new Representante());
        mav.addObject(fornecedor);
        return mav;
    }

    @RequestMapping(value = "/addFornecedorForm", params = {"removeRepresentante"})
    public ModelAndView removeRepresentante(Fornecedor fornecedor, final BindingResult bindingResult, final HttpServletRequest req) {
        final Integer representanteID = Integer.valueOf(req.getParameter("removeRepresentante"));
        fornecedor.getRepresentanteList().remove(representanteID.intValue());
        ModelAndView mav = new ModelAndView("add-fornecedor-form");
        mav.addObject(fornecedor);
        return mav;
    }

}
