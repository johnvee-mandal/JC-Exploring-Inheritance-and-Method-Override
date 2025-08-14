class Vehicle {
    protected String brand = "Generic Vehicle";

    public void honk() {
        System.out.println("Tuut, tuut!");
    }
}

class Bicycle extends Vehicle {
    public void ringBell() {
        System.out.println("Ring ring!");
    }
}

abstract class Animal {
    public void breathe() {
        System.out.println("Inhale... Exhale...");
    }

    public abstract void makeSound();
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

class GameCharacter {
    protected int health = 100;

    public void takeDamage(int amount) {
        this.health -= amount;
    }

    public int getHealth() {
        return this.health;
    }
}

class ArmoredCharacter extends GameCharacter {
    @Override
    public void takeDamage(int amount) {
        int reducedDamage = amount / 2;
        super.takeDamage(reducedDamage);
    }
}

class BankAccount {
    protected double balance;

    public BankAccount(double startingBalance) {
        this.balance = startingBalance;
    }

    public double getBalance() {
        return this.balance;
    }
}

class CheckingAccount extends BankAccount {
    private double fee = 5.0;

    public CheckingAccount(double startingBalance) {
        super(startingBalance);
    }

    public void deductMonthlyFee() {
        balance = balance - fee;
        System.out.println("Fee deducted. New balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Challenge 1: Basic Inheritance ---");
        Bicycle myBicycle = new Bicycle();
        System.out.print("Bicycle says: ");
        myBicycle.honk();
        System.out.print("Bicycle says: ");
        myBicycle.ringBell();
        System.out.println("\n===================================================\n");

        System.out.println("--- Challenge 2: Abstract Classes ---");
        Dog myDog = new Dog();
        myDog.breathe();
        myDog.makeSound();
        System.out.println("\n===================================================\n");

        System.out.println("--- Challenge 3: Method Overriding ---");
        GameCharacter player1 = new GameCharacter();
        ArmoredCharacter player2 = new ArmoredCharacter();
        int damageAmount = 100;

        player1.takeDamage(damageAmount);
        System.out.println("Regular character takes " + damageAmount + " damage. New health: " + player1.getHealth());

        player2.takeDamage(damageAmount);
        System.out.println("Armored character takes " + (damageAmount / 2) + " damage. New health: " + player2.getHealth());
        System.out.println("\n===================================================\n");

        System.out.println("--- Challenge 4: Fix The Code (protected) ---");
        CheckingAccount myChecking = new CheckingAccount(100.0);
        myChecking.deductMonthlyFee();
        System.out.println("\n===================================================\n");
    }
}