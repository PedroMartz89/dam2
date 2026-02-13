package model.pojos;

import jakarta.persistence.*;

@Entity
@Table(name = "house")

@NamedQueries({
        @NamedQuery(
                name = "findHouseByName",
                query = "FROM House h WHERE h.name = :houseName"
        ),
        @NamedQuery(
                name = "findAllHousesOrderByName",
                query = "FROM House h ORDER BY h.name ASC"
        ),
        @NamedQuery(
                name = "getHeadTeacher",
                query = "select h.headTeacher from House h WHERE h.houseId = :idHouse"
        ),
})

public class House {

    @Id
    @Column(name = "id")
    private int houseId;

    @Column(name = "name", length = 50)
    private String name;

    @OneToOne
    @JoinColumn(name = "head_teacher")
    Person headTeacher;

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
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
