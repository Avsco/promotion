/**
 * @author: Alan Benavides
 */

package com.spring.email.model;

import javax.persistence.*;

@Entity
public class Client extends ModelBase {
    private String fullName;
//  Con esta implementacion quise probar como funcinan los Embedded y tener mas experiencia con estos
//  Es comodo para separar la logica de las entidades y acortar un poco mas los nombres
    @Embedded
    private Birthday birthday;

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
}
