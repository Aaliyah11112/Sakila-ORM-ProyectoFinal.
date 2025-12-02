package com.aaliyah.sakila;

import java.util.Scanner;

import com.aaliyah.sakila.manager.ActorManager;
import com.aaliyah.sakila.manager.AddressManager;
import com.aaliyah.sakila.manager.CityManager;
import com.aaliyah.sakila.manager.CountryManager;
import com.aaliyah.sakila.manager.CustomerManager;
import com.aaliyah.sakila.manager.FilmActorManager;
import com.aaliyah.sakila.manager.FilmManager;
import com.aaliyah.sakila.model.Actor;
import com.aaliyah.sakila.model.Address;
import com.aaliyah.sakila.model.City;
import com.aaliyah.sakila.model.Country;
import com.aaliyah.sakila.model.Customer;
import com.aaliyah.sakila.model.Film;
import com.aaliyah.sakila.model.FilmActor;

public class App {

    public static void main(String[] args) {
        
        CountryManager countryManager = new CountryManager();
        CityManager cityManager = new CityManager();
        AddressManager addressManager = new AddressManager();
        CustomerManager customerManager = new CustomerManager();
        FilmManager filmManager = new FilmManager();
        ActorManager actorManager = new ActorManager();
        FilmActorManager filmActorManager = new FilmActorManager();

        
        Country c1 = new Country(0, "USA");
        Country c2 = new Country(0, "Spain");
        countryManager.post(c1);
        countryManager.post(c2);

        City city1 = new City(0, "New York", c1);
        City city2 = new City(0, "Madrid", c2);
        cityManager.post(city1);
        cityManager.post(city2);

        Address a1 = new Address(0, "742 Evergreen Terrace", city1);
        Address a2 = new Address(0, "Calle Mayor 1", city2);
        addressManager.post(a1);
        addressManager.post(a2);

        Customer cust = new Customer(0, "Homer", "Simpson", a1);
        customerManager.post(cust);

        Film f1 = new Film(0, "A Great Movie", "Desc");
        filmManager.post(f1);
        Actor act = new Actor(0, "John", "Doe");
        actorManager.post(act);
        FilmActor fa = new FilmActor(0, f1, act);
        filmActorManager.post(fa);

        System.out.println("Proyecto final - Sakila  ORM/CRUD \n");

        try (Scanner sc = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.println("Menu:\n1 List Countries\n2 List Cities\n3 List Addresses\n4 List Customers\n5 Create Country\n6 Create City\n7 Quit");
                System.out.print("Choose: ");
                String opt = sc.nextLine().trim();
                switch (opt) {
                    case "1":
                        for (Country c: countryManager.all()) System.out.println(c);
                        break;
                    case "2":
                        for (City c: cityManager.all()) System.out.println(c);
                        break;
                    case "3":
                        for (Address a: addressManager.all()) System.out.println(a);
                        break;
                    case "4":
                        for (Customer cu: customerManager.all()) System.out.println(cu);
                        break;
                    case "5":
                        System.out.print("Country name: ");
                        String cn = sc.nextLine().trim();
                        countryManager.post(new Country(0, cn));
                        System.out.println("Created.");
                        break;
                    case "6":
                        System.out.print("City name: ");
                        String cityn = sc.nextLine().trim();
                        System.out.print("Country id: ");
                        int cid = Integer.parseInt(sc.nextLine().trim());
                        Country found = countryManager.get(cid);
                        if (found == null) System.out.println("Country not found");
                        else cityManager.post(new City(0, cityn, found));
                        break;
                    case "7":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option");
                }
                System.out.println();
            }
        }
        System.out.println("Chaoooo");
    }
}
