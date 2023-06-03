package com.lysenko.view;

import com.lysenko.controller.DeveloperController;
import com.lysenko.entity.Developer;
import com.lysenko.entity.Skill;
import com.lysenko.entity.Specialty;
import com.lysenko.entity.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeveloperView {

    private final Scanner scanner;
    private final DeveloperController developerController;

    public DeveloperView(Scanner scanner, DeveloperController developerController) {
        this.scanner = scanner;
        this.developerController = developerController;
    }

    public void createNewDeveloper() {
        printDeveloperMenu();
        switch (scanner.next()) {
            case "1":
                Developer developer = new Developer();
                Specialty specialty = new Specialty();
                System.out.println("Enter first name:");
                String firstName = scanner.next();
                System.out.println("Enter last name:");
                String lastName = scanner.next();

                developer.setFirstName(firstName);
                developer.setLastName(lastName);
                developer.setStatus(Status.ACITVE);

                System.out.println("Enter specialty description");
                String specialtyDescription = scanner.next();
                specialty.setDescriptionSpecialty(specialtyDescription);
                specialty.setStatus(Status.ACITVE);
                specialty.setDeveloper(developer);

                System.out.println("Do you want to add a new Skill?");
                while (scanner.next().equals("y")) {
                    Skill skill = new Skill();
                    System.out.println("Enter skill description");
                    skill.setSkillDescription(scanner.next());
                    skill.setStatus(Status.ACITVE);
                    skill.addDeveloper(developer);
                    developer.addSkill(skill);
                    System.out.println("Do you want to add a new Skill?");
                }
                developer.setSpecialty(specialty);
                developerController.save(developer);
                System.out.println("Developer created");
                break;
            case "2":
                System.out.println("Enter id to find developer: ");
                long idToFind = scanner.nextLong();
                System.out.println("Your developer: " + developerController.findById(idToFind));
                break;
            case "3":
                System.out.print(developerController.findAll());
                break;
            case "4":
                Developer newDeveloper = new Developer();
                System.out.println("Enter old id of developer to update: ");
                long devId = scanner.nextLong();
                System.out.println("Enter first name:");
                String newFirstName = scanner.next();
                System.out.println("Enter last name:");
                String newLastName = scanner.next();
                newDeveloper.setFirstName(newFirstName);
                newDeveloper.setLastName(newLastName);
                System.out.println("developer have been updated");
                developerController.update(devId, newDeveloper);
                break;
            case "5":
                System.out.println("Enter id to find developer: ");
                long idToDelete = scanner.nextLong();
                developerController.delete(idToDelete);
                System.out.println("Developer have been deleted");
                break;
            case "6": break;
        }
    }

    private void printDeveloperMenu() {
        System.out.println("----------");
        System.out.println("We need to make developer");
        System.out.println("Please enter the form below");
        System.out.println("----------");
        System.out.println("Select 1 to create developer");
        System.out.println("Select 2 to find developer by id : insert id :");
        System.out.println("Select 3 to show all developer");
        System.out.println("Select 4 to update developer:");
        System.out.println("Select 5 to delete developer by id: insert id");
        System.out.println("Select 6 to return");
        System.out.println("----------");
    }
}
