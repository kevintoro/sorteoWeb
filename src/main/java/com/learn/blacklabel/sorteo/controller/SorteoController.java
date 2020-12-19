package com.learn.blacklabel.sorteo.controller;

import com.learn.blacklabel.sorteo.model.Boleta;
import com.learn.blacklabel.sorteo.model.Numero;
import com.learn.blacklabel.sorteo.model.Persona;
import com.learn.blacklabel.sorteo.model.Sorteo;
import com.learn.blacklabel.sorteo.repo.BoletaRepository;
import com.learn.blacklabel.sorteo.repo.SorteoRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
@RequestMapping("/sorteo")
public class SorteoController {

  @Autowired
  SorteoRepository sorteoRepository;

  @Autowired
  BoletaRepository boletaRepository;

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

  @GetMapping("/generar/{id}")
  public String generar(@PathVariable Integer id, Model model) {
    Optional<Sorteo> s = sorteoRepository.findById(id);
    if(s.get() != null) {
      List<Boleta> boletas = boletaRepository.getBoletaBySorteo(id);
      if(boletas.size() == 0) {
        Random rd = new Random();
        int totalNums = s.get().getBoletas()*s.get().getNumeros();
        for(int i = 0; i < s.get().getBoletas(); i++) {
          Boleta b = new Boleta();
          b.setSorteo(0);
          LocalDateTime time = LocalDateTime.of(2020, 05, 05, 15, 00);
          b.setFecha(time);
          b.setSorteo(id);
          b.setGanadora(0);
          boletaRepository.save(b);
          for (int j = 0; j < s.get().getNumeros(); j++) {
            int num = rd.nextInt(totalNums);
            String datnum = StringUtils.leftPad(String.valueOf(num), String.valueOf(totalNums).length());
            Numero numero = new Numero();
            numero.setBoleta(b.getId());
            numero.setNumero(datnum);
          }
        }
      }
    } 
    return "redirect:/";
  }

  @GetMapping("/registrar/{id}")
  public String getRegistrar(@PathVariable Integer id, Persona persona, Model model) {

    boolean tickets = false;
    List<Boleta> boletas = boletaRepository.findAll();
    for(Boleta blt: boletas) {
      if(blt.getSorteo() == id) {
        tickets = true;
      }
    }

    String redirect = "";

    if(tickets) {
      redirect = "redirect:/persona/registrar";
      model.addAttribute("id_sorteo", id);
      model.addAttribute("persona", new Persona());
    } else {
      redirect = "redirect:/";
    }

    return redirect;
  }
}
