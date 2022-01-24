package org.drapkin.domain;

public class Flight {
    private Airplane airplane;
    private Place departureId;
    private Place targetId;

    public Flight(Airplane airplane, Place departureId, Place targetId) {
        this.airplane = airplane;
        this.departureId = departureId;
        this.targetId = targetId;
    }

    public Airplane getAirplane() {
        return this.airplane;
    }

    public Place getDepartureId() {
        return this.departureId;
    }

    public Place getTargetId() {
        return this.targetId;
    }

    public String toString() {
        return this.airplane.toString() + "(" + this.getDepartureId() + "-" +
                this.getTargetId() + ")";
    }

}
