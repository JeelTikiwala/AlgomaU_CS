package TableItem;
//main file for printing the table
public class Main {
    public static void main(String[] args) {
        CityTableBST cityTable = new CityTableBST();

        // insering cities in the table
        cityTable.insert(new City("Athens", "Greece", 2389571));
        cityTable.insert(new City("Barcelona", "Spain", 38759984));
        cityTable.insert(new City("Cairo", "Egypt", 3774790));
        cityTable.insert(new City("London", "England", 6739991));
        cityTable.insert(new City("New York", "U.S.A", 9400000));
        cityTable.insert(new City("Paris", "France", 22000000));
        cityTable.insert(new City("Rome", "Italy", 2800000));
        cityTable.insert(new City("Toronto", "Canada", 2731571));
        cityTable.insert(new City("Venice", "Itlay", 300000));


        System.out.println("The table after insertion:");
        cityTable.printInOrder();

        // deleting "Toronto" from table
        cityTable.delete("Toronto");
        System.out.println("\nCities after deleting 'Toronto':");
        cityTable.printInOrder();

        // retriving "toronto" from the table
        City retrievedCity = cityTable.retrieve("Toronto");
        System.out.println("\nRetrieved City:");
        System.out.println(retrievedCity != null ? retrievedCity : "City not found in the table.");
        
        City retrievedCity2 = cityTable.retrieve("Venice");
        System.out.println("\nRetrieved City:");
        System.out.println(retrievedCity2 != null ? retrievedCity2 : "City not found in the table.");
    }
}
