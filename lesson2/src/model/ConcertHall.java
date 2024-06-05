package model;

public class ConcertHall {

    private String name;
    private double maxAllowedBackpackWeight; // in kg

    public ConcertHall() {
    }

    public ConcertHall(String name, double maxAllowedBackpackWeight) {
        this.name = name;
        this.maxAllowedBackpackWeight = maxAllowedBackpackWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxAllowedBackpackWeight() {
        return maxAllowedBackpackWeight;
    }

    public void setMaxAllowedBackpackWeight(double maxAllowedBackpackWeight) {
        this.maxAllowedBackpackWeight = maxAllowedBackpackWeight;
    }

    @Override
    public String toString() {
        return "ConcertHall{" +
               "name='" + name + '\'' +
               ", maxAllowedBackpackWeight=" + maxAllowedBackpackWeight +
               '}';
    }
}
