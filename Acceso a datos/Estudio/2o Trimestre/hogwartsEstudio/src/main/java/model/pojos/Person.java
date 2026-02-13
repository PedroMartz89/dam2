package model.pojos;

import jakarta.persistence.*;

@Entity
@Table(name = "person")

@NamedQueries({
        @NamedQuery(
                name = "getPersonByLastname",
                query = "FROM Person p where p.lastName = :personLastname"
        ),
        @NamedQuery(
                name = "getAllPersonByHouse",
                query = "FROM Person p WHERE p.house.id = :houseId"
        ),
        @NamedQuery(
                name = "findAllByHouse",
                query = "FROM Person p WHERE p.house.id = :houseId"
        ),
        @NamedQuery(
                name = "findAllPersonInHouse",
                query = "FROM Person p where p.house.id = :idHouse"
        )
})
public class Person {
    @Id
    @Column(name = "id")
    private int personId;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
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
