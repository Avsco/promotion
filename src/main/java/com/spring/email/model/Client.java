/**
 * @author: Alan Benavides
 */

package com.spring.email.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Client extends ModelBase {
    private String fullName;
    //  Con esta implementacion quise probar como funcinan los Embedded y tener mas experiencia con estos
//  Es comodo para separar la logica de las entidades y acortar un poco mas los nombres
    @Embedded
    private Birthday birthday;
    @OneToMany
    private Collection<Promotion> promotions;


    public void setBirthday(Birthday birthday) {
        this.birthday = birthday;
    }

    public Birthday getBirthday() {
        return birthday;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Collection<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Collection<Promotion> promotions) {
        this.promotions = promotions;
    }
}
