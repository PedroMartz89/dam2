package model;

import jakarta.persistence.*;

@Entity
@Table(name="house")
@NamedQueries({
        // Buscar una casa por su nombre exacto (ej. "Gryffindor")
        @NamedQuery(
                name = "House.findByName",
                query = "FROM House h WHERE h.name = :nombre"
        ),
        // Listar todas las casas ordenadas por nombre
        @NamedQuery(
                name = "House.findAllOrdered",
                query = "FROM House h ORDER BY h.name ASC"
        )
})
public class House {

    @Id
    private int id;

    private String name;

    @OneToOne
    @JoinColumn(name="head_teacher")
    private Person headTeacher;

    public House() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getHeadTeacher() {
        return headTeacher;
    }

    public void setHeadTeacher(Person headTeacher) {
        this.headTeacher = headTeacher;
    }
}
