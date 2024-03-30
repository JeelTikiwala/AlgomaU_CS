package TableItem;
/**
Name: Jeel Tikiwala
Student ID: 239659420
Assignment 3
Any and all work in this file is my own.*/
import java.util.Arrays;

public class CityTableArray {
    private City[] table;
    private int size;

    public CityTableArray() {
        table = new City[10]; // Initial capacity, if we want we can increase as well
        size = 0;
    }

    public void insert(City city) {
        if (size == table.length) {
            table = Arrays.copyOf(table, size * 2);
        }
        table[size++] = city;
    }

    public void delete(String name) {
        for (int i = 0; i < size; i++) {
            if (table[i].getName().equals(name)) {
                table[i] = table[size - 1];
                table[size - 1] = null;
                size--;
                break;
            }
        }
    }

    public City retrieve(String name) {
        for (int i = 0; i < size; i++) {
            if (table[i].getName().equals(name)) {
                return table[i];
            }
        }
        return null;
    }

    // Utility method to print all cities
    public void printCities() {
        for (int i = 0; i < size; i++) {
            System.out.println(table[i]);
        }
    }
}
