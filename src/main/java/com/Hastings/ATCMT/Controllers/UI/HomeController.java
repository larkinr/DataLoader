package com.Hastings.ATCMT.Controllers.UI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/ATCMT/SearchSuites")
    public String index() { return "index"; }
}
