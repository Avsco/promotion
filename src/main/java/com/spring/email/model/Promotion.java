/**discount
 * @author: Alan Benavides
 */

package com.spring.email.model;

import javax.persistence.Entity;

@Entity
public class Promotion extends ModelBase {
//  Puse como static el message por si el usuario desea cambiar su cumpleanios
//  y vea mayor facilidad al hacerlo ya que se sigue teniendo el template del mensage
    private static final String message = "%s Hoy es su cumpleaños y usted es importante para nosotros, queremos celebralo ofreciendo un %f \\% de descuento y delivery gratuito. Valido por 24 hrs";
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String name, double discount) {
        this.description = this.message.format(name, discount);
    }
}
