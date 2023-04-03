package org.example;

import org.example.sendEmail.Controller;
import org.example.sendEmail.SendEmail;

import java.util.Scanner;

public class Main {
    private static Controller controller;
    private static Scanner sc;
    private static int choice;
    public static void main(String[] args) {
        controller = new Controller();
        System.out.println("WELCOME BACK ADMIN");
        do {

        System.out.println("Menu: \n 1.Send direct email\n 2.Send to all emails\n 3.Exit program");
        System.out.print("Choose one option :");
        sc=new Scanner(System.in);
        choice =sc.nextInt();

        switch (choice){
            case 1: {
                System.out.println("Option: \n 1.Use default email\n 2.Add custom email");
                System.out.print("Choose one option :");
                choice =sc.nextInt();
                switch (choice){
                    case 1: {
                        controller.sendDefaultEmail();
                        break;
                    }
                    case 2: {
                        System.out.print("Write the email :");
                        String email = sc.nextLine();
                        email = sc.nextLine();
                        controller.sendCustomEmail(email);
                        break;
                    }

                }
            }
            case 2: {
                controller.sendToAll();
                break;
            }
        }
        }while (choice!=3);

    }
}