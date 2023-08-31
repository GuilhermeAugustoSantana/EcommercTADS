package com.tads4.tads4.constrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(valeu = "/products")
public class ProductController {
    public String teste(){
        return "Minha primeira rota";
    }
}
