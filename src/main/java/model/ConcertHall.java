package model;

public class ConcertHall {

    private String name;
    private double maxAllowedBackpackWeight; // in kg

    public ConcertHall() {
    }

    public ConcertHall(String name, double maxAllowedBackpackWeight) {
        if (name.length() > 10) {
            throw new IllegalArgumentException("Concert hall name length must be less than 11 characters. Got: " + name.length());
        }
        this.name = name;
        this.maxAllowedBackpackWeight = maxAllowedBackpackWeight;
    }

    public String getName() {
        return name;
    }

    public double getMaxAllowedBackpackWeight() {
        return maxAllowedBackpackWeight;
    }

    @Override
    public String toString() {
        return "ConcertHall{" +
               "name='" + name + '\'' +
               ", maxAllowedBackpackWeight=" + maxAllowedBackpackWeight +
               '}';
    }
}
