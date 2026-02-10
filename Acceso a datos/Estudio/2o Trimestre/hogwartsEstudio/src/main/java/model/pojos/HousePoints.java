package model.pojos;

import jakarta.persistence.*;

@Entity
@Table(name = "house_points")
@NamedQueries({
        // Obtener todos los registros de puntos recibidos por una persona (ID)
        @NamedQuery(
                name = "getPointsByReceiver",
                query = "select hp.points FROM HousePoints hp WHERE hp.receiver.id = :idReceiver"
        ),
        // Obtener todos los puntos otorgados por un profesor/mago (ID)
        @NamedQuery(
                name = "getPointsByGiver",
                query = "FROM HousePoints hp WHERE hp.giver.id = :idGiver"
        ),
        @NamedQuery(
                name = "personIsGiver",
                query = "SELECT COUNT(hp) from HousePoints hp WHERE hp.giver.id = :idGiver"
        ),
         @NamedQuery(
                name = "personIsReceiver",
                query = "SELECT COUNT(hp) from HousePoints hp WHERE hp.giver.id = :idReceiver"
        ),
        @NamedQuery(
                name = "findReceiverOfByLastname",
                query = "SELECT hp.receiver from HousePoints hp where hp.receiver.lastName = :apellido"
        ),
        @NamedQuery(
                name = "findMorePointsPerson",
                query = "select hp.receiver from HousePoints hp having sum(hp.points) = (" +
                        "select sum(hp2.points) from HousePoints hp2 group by hp2.receiver" +
                        " order by sum(hp2.points) desc limit 1)"
        ),
        @NamedQuery(
                name = "getHousesTotalPoints",
                query = "SELECT hp.receiver.house.name, SUM(hp.points) FROM HousePoints hp" +
                        " GROUP BY hp.receiver.house.name"
        )
})

public class HousePoints {
    @Id
    private int housePointsId;

    @ManyToOne
    @JoinColumn(name = "giver")
    private Person giver;

    @ManyToOne
    @JoinColumn(name = "receiver")
    private Person receiver;

    @Column(name = "points")
    private int points;

    public int getHousePointsId() {
        return housePointsId;
    }

    public void setHousePointsId(int housePointsId) {
        this.housePointsId = housePointsId;
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
