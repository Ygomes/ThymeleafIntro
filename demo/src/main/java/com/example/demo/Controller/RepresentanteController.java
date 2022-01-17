package com.example.demo.Controller;

import com.example.demo.Entity.Representante;
import com.example.demo.Repository.RepresentanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RepresentanteController {

    @Autowired
    private RepresentanteRepository representanteRepository;

    @GetMapping({"/representantes"})
    public ModelAndView getAllFornecedor() {
        ModelAndView mav = new ModelAndView("list-representante");
        List<Representante> list = representanteRepository.findAll();
        mav.addObject("representante", list);
        return mav;
    }

    @GetMapping("/addRepresentanteForm")
    public ModelAndView addRepresentante() {
        ModelAndView mav = new ModelAndView("add-fornecedor-form");
        Representante newRepresentante = new Representante();
        mav.addObject("representante", newRepresentante);
        return mav;
    }

    @PostMapping("/saveRepresentante")
    private String saveRepresentante(@ModelAttribute Representante representante) {
        representanteRepository.save(representante);
        return "redirect:/representantes";
    }

    @GetMapping("/updateRepresentante")
    public ModelAndView updateRepresentante(@RequestParam Long representanteId) {
        ModelAndView mav = new ModelAndView("add-fornecedor-form");
        Representante representante = representanteRepository.findById(representanteId).get();
        mav.addObject("representante", representante);
        return mav;
    }

    @GetMapping("/deleteRepresentante")
    public String deleteRepresentante(@RequestParam Long representanteId) {
        representanteRepository.deleteById(representanteId);
        return "redirect:/representantes";
    }
}
