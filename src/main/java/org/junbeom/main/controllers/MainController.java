package org.junbeom.main.controllers;

import org.junbeom.global.exceptions.ExceptionProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController implements ExceptionProcessor {

    @GetMapping
      public String index() {

         return "front/main/index"; // 템플릿 경로
     }
}
