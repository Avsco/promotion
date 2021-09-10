package com.spring.email;

import com.spring.email.model.Birthday;
import com.spring.email.model.Client;
import com.spring.email.repository.ClientRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevelopmentBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private ClientRepository repository;

    public DevelopmentBootstrap(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        persistClient("Alan", 1 , 1);
        persistClient("Perez", 10 , 9);
    }

    private void persistClient(String name, int day, int month) {
        Client client = new Client();
        client.setFullName(name);
        Birthday birthday = new Birthday();
        birthday.setDay(day);
        birthday.setMonth(month);
        client.setBirthday(birthday);
        repository.save(client);
    }
}
