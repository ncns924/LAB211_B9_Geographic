
package view;

import java.util.List;
import model.EastAsiaCountries;

public class ManageEastAsiaCountriesView {
    public void displayMenu() {
        System.out.println("======================= MENU ===============================================================");

        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of countries you've just input");
        System.out.println("3. Search the information of countries by name");
        System.out.println("4. Display the information of countries sorted by name in ascending order");
        System.out.println("5. Exit");
        System.out.println("============================================================================================");
    }

    public void displayError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

    public void displayCountryInformation(List<EastAsiaCountries> countries) {
    System.out.println("ID ||  Name            || Total Area ||  Terrain");
    for (EastAsiaCountries country : countries) {
        System.out.printf("%-2s || %-14s   || %-5.1f   || %-13s%n",
                country.getCountryCode(), country.getCountryName(), country.getTotalArea(), country.getCountryTerrain());
    }
}
    
    public void displaySearchResults(List<EastAsiaCountries> searchResults) {
        if (searchResults.isEmpty()) {
            System.out.println("No countries found with the given name.");
        } else {
            displayCountryInformation(searchResults);
        }
    }

    public void displayExitMessage() {
        System.out.println("Exiting program...");
    }
}
