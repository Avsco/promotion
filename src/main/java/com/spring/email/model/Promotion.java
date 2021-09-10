/**discount
 * @author: Alan Benavides
 */

package com.spring.email.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Promotion extends ModelBase {
//  Puse como static el message por si el usuario desea cambiar su cumpleanios
//  y vea mayor facilidad al hacerlo ya que se sigue teniendo el template del message
    private static final String message = "<name> Hoy es su cumpleaños y usted es importante para nosotros, queremos celebralo ofreciendo un <discount> % de descuento y delivery gratuito. Valido por 24 hrs";
    @Column(nullable = false)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String name, double discount) {
        this.description = this.message.replace("<name>", name).replace("<discount>", String.valueOf(discount));
    }
}
