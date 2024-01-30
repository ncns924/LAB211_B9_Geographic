
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import model.EastAsiaCountries;
import view.ManageEastAsiaCountriesView;

public class ManageEastAsiaCountriesController {
    private List<EastAsiaCountries> countries;
    private ManageEastAsiaCountriesView view;

    public ManageEastAsiaCountriesController() {
        countries = new ArrayList<>();
        view = new ManageEastAsiaCountriesView();
    }

    public void addCountryInformation(EastAsiaCountries country) {
        countries.add(country);
    }

    public void displayAllCountryInformation() throws Exception {
        if (countries.isEmpty()) {
            throw new Exception("No countries have been entered.");
        }
        view.displayCountryInformation(countries);
    }

    public List<EastAsiaCountries> searchInformationByName(String name) {
        List<EastAsiaCountries> searchResults = new ArrayList<>();
        for (EastAsiaCountries country : countries) {
            if (country.getCountryName().equalsIgnoreCase(name)) {
                searchResults.add(country);
            }
        }
        return searchResults;
    }

    public List<EastAsiaCountries> sortInformationByAscendingOrder() throws Exception {
        if (countries.isEmpty()) {
            throw new Exception("No countries have been entered.");
        }
        List<EastAsiaCountries> sortedCountries = new ArrayList<>(countries);
        Collections.sort(sortedCountries, Comparator.comparing(EastAsiaCountries::getCountryName));
        return sortedCountries;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean continueAdding = true;

        while (true) {
            view.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Enter the information of countries in East Asia:");

                        while (continueAdding) {
                            System.out.print("Enter code of country: ");
                            String code = scanner.nextLine();
                            System.out.print("Enter name of country: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter total area: ");
                            float area = scanner.nextFloat();
                            scanner.nextLine(); // Consume the newline character
                            System.out.print("Enter terrain of country: ");
                            String terrain = scanner.nextLine();
                            EastAsiaCountries country = new EastAsiaCountries(code, name, area, terrain);
                            addCountryInformation(country);
                            System.out.println("Country information added successfully.");

                            System.out.print("Do you want to enter information for another country? (Y/N) ");
                            String continueChoice = scanner.nextLine();
                            if (!continueChoice.equalsIgnoreCase("Y")) {
                                continueAdding = false;
                            }
                        }
                        continueAdding = true;
                        break;
                    case 2:
                        displayAllCountryInformation();
                        break;
                    case 3:
                        System.out.print("Enter the name you want to search for: ");
                        String searchName = scanner.nextLine();
                        List<EastAsiaCountries> searchResults = searchInformationByName(searchName);
                        view.displaySearchResults(searchResults);
                        break;
                    case 4:
                        List<EastAsiaCountries> sortedCountries = sortInformationByAscendingOrder();
                        view.displayCountryInformation(sortedCountries);
                        break;
                    case 5:
                        view.displayExitMessage();
                        return;
                    default:
                        view.displayError("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                view.displayError(e.getMessage());
            }

            System.out.println();
        }
    }
}