import TaskPlanes.experimentalPlane;
import models.MilitaryType;
import TaskPlanes.MilitaryPlane;
import TaskPlanes.PassengerPlane;
import TaskPlanes.Plane;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends Plane> planes;



    public List<PassengerPlane> getPassengerPlanes() {
        List<? extends Plane> planes = this.planes;
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (Plane plane : planes) {if (plane instanceof PassengerPlane) {passengerPlanes.add((PassengerPlane) plane);}}
        return passengerPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            } //if
            else {

            } // else
        } //for
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaximumPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaximumCapacity = passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaximumCapacity.getPassengersCapacity()) {
                planeWithMaximumCapacity = passengerPlanes.get(i);
            }
        }

        return planeWithMaximumCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
    List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
    List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
    for (int i = 0; i < militaryPlanes.size(); i++) {
    MilitaryPlane plane = militaryPlanes.get(i);
    if (plane.getType() == MilitaryType.TRANSPORT) {
    transportMilitaryPlanes.add(plane);
    }
    }
    return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            MilitaryPlane plane = militaryPlanes.get(i);
            if (plane.getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }
        return bomberMilitaryPlanes;

    }

    public List<experimentalPlane> getExperimentalPlanes() {
        List<experimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof experimentalPlane) {
                experimentalPlanes.add((experimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public Airport sortByMaximumDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane planeFirst, Plane planeSecond) {
                return planeFirst.GetMaximumFlightDistance() - planeSecond.GetMaximumFlightDistance();
            }
        });
        return this;
    }


    /**
     * Sorts by max speed
     * @return Airport
     */
    public Airport sortByMaximumSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane planeFirst, Plane planeSecond) {
                return planeFirst.getMaximumSpeed() - planeSecond.getMaximumSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaximumLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane planeFirst, Plane planeSecond) {
                return planeFirst.getMaximumLoadCapacity() - planeSecond.getMaximumLoadCapacity();
            }
        });
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private void print(Collection<? extends Plane> collection) {
        Iterator<? extends Plane> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Plane plane = iterator.next();
            System.out.println(plane);
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    //Constructor
    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

}
