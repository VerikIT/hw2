package com.example.hw2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {
  @GetMapping ("/view")
   public String test(){
       return "index.html";
    }
}
