package model;

import jakarta.persistence.*;

@Entity
@Table(name = "house_points")
@NamedQueries({
        // Obtener todos los registros de puntos recibidos por una persona (ID)
        @NamedQuery(
                name = "HousePoints.byReceiver",
                query = "FROM HousePoints hp WHERE hp.receiver.id = :idPersona"
        ),
        // Obtener todos los puntos otorgados por un profesor/mago (ID)
        @NamedQuery(
                name = "HousePoints.byGiver",
                query = "FROM HousePoints hp WHERE hp.giver.id = :idPersona"
        )
})
public class HousePoints {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "giver")
    private Person giver;

    @ManyToOne
    @JoinColumn(name = "receiver")
    private Person receiver;

    @Column(name = "points")
    private int points;

    public HousePoints() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getGiver() {
        return giver;
    }

    public void setGiver(Person giver) {
        this.giver = giver;
    }

    public Person getReceiver() {
        return receiver;
    }

    public void setReceiver(Person receiver) {
        this.receiver = receiver;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
