package org.drapkin.ui;

import org.drapkin.domain.Airplane;
import org.drapkin.domain.Flight;
import org.drapkin.domain.Place;
import org.drapkin.logic.AirportControl;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private AirportControl airportControl;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.airportControl = new AirportControl();
    }

    public void initiateAirplaneControl() {
        boolean isValidState = true;

        while(isValidState) {
            System.out.print("Choose an action:\n" +
                    "[1] Add an airplane\n" +
                    "[2] Add a flight\n" +
                    "[x] Exit Airport Asset Control\n" +
                    "> ");

            String input = scanner.nextLine();

            switch(input) {
                case "1":
                    System.out.print("Give the airplane id: ");
                    String id = scanner.nextLine();
                    System.out.print("Give the airplane capacity: ");
                    int capacity = Integer.parseInt(scanner.nextLine());
                    airportControl.addAirplane(id, capacity);
                    break;

                case "2":
                    System.out.print("Give the airplane id: ");
                    String id2 = scanner.nextLine();
                    System.out.print("Give the departure airport id: ");
                    String departureId = scanner.nextLine();
                    System.out.print("Give the target airport id: ");
                    String targetId = scanner.nextLine();
                    airportControl.addFlight(new Airplane(id2, airportControl.getSpecifiedCapacity(id2)),
                            new Place(departureId), new Place(targetId));
                    break;

                case "x":
                    isValidState = false;
                    break;

                default:
                    System.out.println("Invalid command.");
                    break;
            }

        }
    }

    public void initiateFlightControl() {
        boolean isValidState = true;

        while(isValidState) {
            System.out.print("Choose an action:\n" +
                    "[1] Print airplanes\n" +
                    "[2] Print flights\n" +
                    "[3] Print airplane details\n" +
                    "[x] Quit\n" +
                    "> ");

            String input = scanner.nextLine();

            switch(input) {
                case "1":
                    for(Airplane airplane : airportControl.getAirplanes()) {
                        System.out.println(airplane);
                    }
                        break;
                case "2":
                    for(Flight flight : airportControl.getFlights()) {
                        System.out.println(flight.getAirplane() + " (" + airportControl.getFlight(flight.getAirplane()).getDepartureId() +
                                "-" + airportControl.getFlight(flight.getAirplane()).getTargetId() + ")");
                    }
                        break;

                case "3":
                    System.out.print("Give the airplane id: ");
                    String id3 = scanner.nextLine();
                    System.out.println(airportControl.getSpecificAirplane(id3));
                    break;

                case "x":
                    isValidState = false;
                    break;

                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }

    public void start() {
        System.out.println("AIRPORT ASSET CONTROL");
        System.out.println("---------------------");
        initiateAirplaneControl();
        System.out.println("FLIGHT CONTROL");
        System.out.println("--------------");
        initiateFlightControl();
    }

}
