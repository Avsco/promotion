/**
 * @author: Alan Benavides
 */

package com.spring.email.service;

import com.spring.email.model.Client;
import com.spring.email.model.Promotion;
import com.spring.email.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
public class PromotionService {
    private final PromotionRepository repository;
    private final ClientService clientService;
    private final MailSender mailSender;
    @Value("${discount.value}")
    private String discount;
    @Value("${blackDays}")
    private String isBlackDays;

    public PromotionService(PromotionRepository repository, ClientService clientService, MailSender mailSender) {
        this.repository = repository;
        this.clientService = clientService;
        this.mailSender = mailSender;
    }

    public Collection<Client> sendDiscountEmail() {
        System.out.println(this.discount);
        System.out.println(this.isBlackDays);
//      Por como estoy usando las variables de entorno es incomodo ir transformando estas a su valor esperado
        Double discount = Boolean.parseBoolean(this.isBlackDays) ? 50.0 : Double.parseDouble(this.discount);
        LocalDateTime now = LocalDateTime.now();
        Collection<Client> clients= this.clientService.getClientByirthday(now.getMonthValue(), now.getDayOfMonth());
        clients.forEach((client) -> {
            Promotion promotion = new Promotion();
            promotion.setDescription(client.getFullName(), discount);
            repository.save(promotion);
            //Enviar correos
            this.mailSender.sendMessage();
        });
        return clients;
    }
}