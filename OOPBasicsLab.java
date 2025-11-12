/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package yes; 

import java.util.Scanner;

public class Yes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ACTIVITY 1 & 2: STUDENT");
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Grade: ");
        double grade = scanner.nextDouble();

        Student student1 = new Student(name, age, grade);
        student1.displayInfo();

        System.out.println("ACTIVITY 3: VEHICLE");
        
        Vehicle myCar = new Vehicle("Toyota", "Vios", 60.0);
        
        myCar.displayStatus();
        myCar.accelerate(20.0);
        System.out.println("After accelerating car...");
        myCar.displayStatus();
        
        Vehicle motorcycle = new Vehicle("Honda", "Click 125", 40.0);
        
        motorcycle.displayStatus();
        motorcycle.accelerate(15.0);
        System.out.println("After accelerating motorcycle...");
        motorcycle.displayStatus();

        System.out.println("ACTIVITY 4: BANK ACCOUNT");
        BankAccount myAccount = new BankAccount("Ann Sherille", 500.0);
        myAccount.displayBalance();

        int choice = 0;
        while (choice != 3) {
            System.out.println("Bank Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    myAccount.deposit(depositAmount);
                    myAccount.displayBalance();
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    myAccount.withdraw(withdrawAmount);
                    myAccount.displayBalance();
                    break;
                case 3:
                    System.out.println("Exiting bank simulation.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        System.out.println("ACTIVITY 5: CIRCLE"); 
        System.out.print("Enter radius for Circle 1: ");
        double r1 = scanner.nextDouble();
        Circle circle1 = new Circle(r1);
        circle1.displayDetails();
        
        System.out.print("Enter radius for Circle 2:");
        double r2 = scanner.nextDouble();
        Circle circle2 = new Circle(r2);
        circle2.displayDetails();
        
        scanner.close();
    }
}


class Student {

    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public void displayInfo() {
        System.out.println("Student Information");
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Grade: " + this.grade);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return this.grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

class Vehicle {

    String brand;
    String model;
    double speed;

    public Vehicle(String brand, String model, double speed) {
        this.brand = brand;
        this.model = model;
        this.speed = speed;
    }


    public void accelerate(double increment) {
        this.speed += increment;
    }

    public void displayStatus() {
        System.out.println("--- Vehicle Status ---");
        System.out.println("Brand: " + this.brand);
        System.out.println("Model: " + this.model);
        System.out.println("Current Speed: " + this.speed + " km/h");
    }
}

class BankAccount {

    String accountHolder;
    double balance;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited:  ₱" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Withdrawn:  ₱" + amount);
        } else if (amount > this.balance) {
            System.out.println("Withdrawal failed: Insufficient funds.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public void displayBalance() {
        System.out.println("Account Holder: " + this.accountHolder);
        System.out.println("Current Balance:  ₱" + this.balance);
    }
}

class Circle {

    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * this.radius;
    }

    public void displayDetails() {
        System.out.println("Circle Details");
        System.out.println("Radius: " + this.radius);
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
    }
}