package TableItem;
//common for all implementations
/**
Name: Jeel Tikiwala
Student ID: 239659420
Assignment 3
Any and all work in this file is my own.*/
public class City {
    String name;
    String country;
    int population;

    public City(String name, String country, int population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return name + ", " + country + ", " + population;
    }
}
