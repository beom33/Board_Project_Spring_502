package org.junbeom.main.controllers;

import org.junbeom.global.exceptions.ExceptionProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController implements ExceptionProcessor {

    @GetMapping
      public String index(Model model) {

        model.addAttribute("addCommonScript",  List.of("fileManger"));
        model.addAttribute("addScript", List.of("test/form"));

         return "front/main/index"; // 템플릿 경로
     }
}
