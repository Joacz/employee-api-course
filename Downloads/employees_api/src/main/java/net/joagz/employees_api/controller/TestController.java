package net.joagz.employees_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

  @GetMapping("/")
  public String home() {
    return "home";
  }

}
