package com.learn.blacklabel.sorteo.controller;

import com.learn.blacklabel.sorteo.model.Boleta;
import com.learn.blacklabel.sorteo.repo.BoletaRepository;
import com.learn.blacklabel.sorteo.repo.SorteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

  @Autowired
  SorteoRepository sorteoRepository;
  BoletaRepository boletaRepository;

  @GetMapping("/")
  public String getIndex(HttpServletRequest request, Model model) {
    model.addAttribute("sorteos", sorteoRepository.findAll());
    return "index";
  }
}
