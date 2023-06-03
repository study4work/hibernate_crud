package com.lysenko.view;

import com.lysenko.controller.SpecialtyController;
import com.lysenko.entity.Specialty;
import com.lysenko.entity.Status;

import java.util.Scanner;

public class SpecialtyView {

    private final Scanner scanner;
    private final SpecialtyController specialtyController;

    public SpecialtyView(Scanner scanner, SpecialtyController specialtyController) {
        this.scanner = scanner;
        this.specialtyController = specialtyController;
    }

    public void createSpecialty() {
        printSpecialityMenu();
        switch (scanner.next()) {
            case "1" :
                Specialty specialty = new Specialty();
                System.out.println("1. Enter specialty description");
                String description = scanner.next();
                specialty.setDescriptionSpecialty(description);
                specialty.setStatus(Status.ACITVE);
                specialtyController.save(specialty);
                System.out.println("Specialty created");
                break;
            case "2":
                System.out.println(specialtyController.findAll());
                break;
            case "3":
                System.out.println("Enter new description");
                String updateDescription = scanner.next();
                System.out.println("Enter old specialty id");
                long id = scanner.nextLong();
                Specialty updateSpecialty = new Specialty();
                updateSpecialty.setDescriptionSpecialty(updateDescription);
                updateSpecialty.setStatus(Status.ACITVE);
                specialtyController.update(id, updateSpecialty);
                System.out.println("specialty have been updated");
                break;
            case "4":
                System.out.println("Enter specialty id to delete");
                long specId = scanner.nextLong();
                specialtyController.delete(specId);
                System.out.println("specialty have been deleted");
                break;
            case "5":
                break;
        }
    }

    private void printSpecialityMenu() {
        System.out.println("----------");
        System.out.println("We need to make specialty for our developer");
        System.out.println("Please enter the form below");
        System.out.println("----------");
        System.out.println("Select 1 to create specialty");
        System.out.println("Select 2 to show all specialty");
        System.out.println("Select 3 to update specialty:");
        System.out.println("Select 4 to delete specialty:");
        System.out.println("Select 5 to return");
        System.out.println("----------");
    }
}
