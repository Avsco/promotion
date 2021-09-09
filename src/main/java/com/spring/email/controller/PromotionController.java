package com.spring.email.controller;

import com.spring.email.model.Client;
import com.spring.email.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/promotion")
public class PromotionController {
    private PromotionService service;

    public PromotionController(PromotionService service) {
        this.service = service;
    }

    @GetMapping("/$birthdate")
    public List<String> getById() {
        Collection<Client> clients = this.service.sendDiscountEmail();
        return clients.stream().map(Client::getFullName).collect(Collectors.toList());
    }
}
