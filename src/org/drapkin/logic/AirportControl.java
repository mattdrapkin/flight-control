package org.drapkin.logic;

import org.drapkin.domain.Airplane;
import org.drapkin.domain.Flight;
import org.drapkin.domain.Place;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirportControl {
    private Map<String, Airplane> airplanes;
    private Map<Airplane, Flight> flights;
    private Map<String, Place> places;

    public AirportControl() {
        this.airplanes = new HashMap<>();
        this.flights = new HashMap<>();
        this.places = new HashMap<>();
    }

    public void addAirplane(String id, int capacity) {
        airplanes.putIfAbsent(id, new Airplane(id, capacity));
    }

    public void addFlight(Airplane airplane, Place departureId, Place targetId) {
        flights.put(airplane, new Flight(airplane, departureId, targetId));
    }

    public Collection<Airplane> getAirplanes() {
        return this.airplanes.values();
    }

    public Airplane getSpecificAirplane(String id) {
        return this.airplanes.get(id);
    }

    public int getSpecifiedCapacity(String id) {
        return getSpecificAirplane(id).getCapacity();
    }

    public Flight getFlight(Airplane airplane) {
        return this.flights.get(airplane);
    }

    public Collection<Flight> getFlights() {
        return this.flights.values();
    }
}
