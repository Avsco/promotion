/**
 * @author: Alan Benavides
 */

package com.spring.email.repository;

import com.spring.email.model.Client;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface ClientRepository extends GenericRepository<Client> {
//    Quise probar esta manera de hacer consultas con JPQL, algo que me gusto de esto es el autocompletado
//    Que te ayuda a estar seguro de lo que haces
    @Query("SELECT c FROM Client c WHERE c.birthday.day = ?2 and c.birthday.month = ?1")
    Collection<Client> findByBirthday(int month, int day);
}