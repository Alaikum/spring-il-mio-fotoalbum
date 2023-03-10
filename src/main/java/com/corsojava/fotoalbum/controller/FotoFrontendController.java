package com.corsojava.fotoalbum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/frontend")
public class FotoFrontendController {

	
	@GetMapping
	public String index() {
		return "/frontend/foto/index";
	}
	
	@GetMapping("/show")
	public String show()  {
		return "/frontend/foto/show";
	}
}
