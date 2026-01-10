package model;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
@NamedQueries({
        // Buscar personas por su apellido
        @NamedQuery(
                name = "Person.findByLastName",
                query = "FROM Person p WHERE p.lastName = :apellido"
        ),
        // Obtener todos los alumnos de una casa específica
        @NamedQuery(
                name = "Person.findInHouse",
                query = "FROM Person p WHERE p.house.id = :idCasa"
        )
})
public class Person {

    @Id
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
