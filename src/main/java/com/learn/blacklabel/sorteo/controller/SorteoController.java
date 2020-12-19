package com.learn.blacklabel.sorteo.controller;

import com.learn.blacklabel.sorteo.model.Sorteo;
import com.learn.blacklabel.sorteo.repo.SorteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/sorteo")
public class SorteoController {

  @Autowired
  SorteoRepository sorteoRepository;

  @GetMapping("/crear")
  public String getSorteo(HttpServletRequest request, Model model) {
    model.addAttribute("sorteo", new Sorteo());
    return "sorteo";
  }

  @PostMapping("/crear")
  public String crearSorteo(Sorteo sorteo, Model model) {
    sorteoRepository.save(sorteo);
    return "redirect:/";
  }
}
