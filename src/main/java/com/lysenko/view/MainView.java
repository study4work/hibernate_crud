package com.lysenko.view;

import com.lysenko.config.FlywayConfig;
import com.lysenko.controller.DeveloperController;
import com.lysenko.controller.SkillController;
import com.lysenko.controller.SpecialtyController;

import java.util.Scanner;

public class MainView {

    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            FlywayConfig.startMigration();

            DeveloperController developerController = new DeveloperController();
            SkillController skillController = new SkillController();
            SpecialtyController specialtyController = new SpecialtyController();

            DeveloperView developerView = new DeveloperView(scanner, developerController);
            SkillView skillView = new SkillView(scanner, skillController);
            SpecialtyView specialtyView = new SpecialtyView(scanner, specialtyController);

            mainRun(scanner, developerView, skillView, specialtyView);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void mainRun(Scanner scanner, DeveloperView developerView, SkillView skillView, SpecialtyView specialtyView) {
        printMainMenu();
        switch (scanner.next()) {
            case "1" :
                skillView.createSkill();
                mainRun(scanner, developerView, skillView, specialtyView);
            case "2" :
                specialtyView.createSpecialty();
                mainRun(scanner, developerView, skillView, specialtyView);
            case "3" :
                developerView.createNewDeveloper();
                mainRun(scanner, developerView, skillView, specialtyView);
            case "4" :
                return;
            default:
                System.out.println("Only 1 to 3 available");
        }
    }

    private void printMainMenu() {
        System.out.println("----------");
        System.out.println("1. Skills menu");
        System.out.println("2. Specialty menu");
        System.out.println("3. Developer menu");
        System.out.println("4. Exit");
        System.out.println("----------");
    }
}
