package com.klu.microservice22;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms2")
public class controler3 {
@GetMapping("/mul")
public String m(@RequestParam("a") int a,@RequestParam("b") int b) {
	int r= a*b;
	return "multiplication "+r;
}
}  
