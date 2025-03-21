package com.stocky.models.entities.personas;

import com.stocky.models.entities.Entidad;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "persona")
public abstract class Persona extends Entidad<Persona> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    @Column(name = "contacto_principal")
    private String contactoPrincipal;
    private Boolean activo;

    public Persona() {}

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", contactoPrincipal='" + contactoPrincipal + '\'' +
                ", activo=" + activo +
                '}';
    }

    @Override
    public int compareTo(Persona o) {
        //2 personas son iguales si tienen el mismo telefono, no puede haber 2 personas con el mismo
        return this.getTelefono().compareTo(o.getTelefono());
    }

    public Integer getIdPersona(){
        return this.id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactoPrincipal() {
        return contactoPrincipal;
    }

    public void setContactoPrincipal(String contactoPrincipal) {
        this.contactoPrincipal = contactoPrincipal;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
