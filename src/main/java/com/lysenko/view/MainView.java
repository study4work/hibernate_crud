package com.lysenko.view;

import com.lysenko.config.FlywayConfig;
import com.lysenko.config.HibernateConfig;
import com.lysenko.controller.DeveloperController;
import com.lysenko.controller.SkillController;
import com.lysenko.controller.SpecialtyController;
import com.lysenko.service.DeveloperService;
import com.lysenko.service.SkillService;
import com.lysenko.service.SpecialtyService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class MainView {

    public void run() {
        Session session = null;
        try {
            Scanner scanner = new Scanner(System.in);
            FlywayConfig.startMigration();

            SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
            session = sessionFactory.openSession();

            DeveloperService developerService = new DeveloperService(session);
            SkillService skillService = new SkillService(session);
            SpecialtyService specialtyService = new SpecialtyService(session);

            DeveloperController developerController = new DeveloperController(developerService);
            SkillController skillController = new SkillController(skillService);
            SpecialtyController specialtyController = new SpecialtyController(specialtyService);

            DeveloperView developerView = new DeveloperView(scanner, developerController);
            SkillView skillView = new SkillView(scanner, skillController);
            SpecialtyView specialtyView = new SpecialtyView(scanner, specialtyController);

            mainRun(scanner, developerView, skillView, specialtyView);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (session != null && session.isOpen())
                session.close();
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
