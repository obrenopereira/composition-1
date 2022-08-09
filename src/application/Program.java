package application;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner read = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter departament's name: ");
        String departmentName = read.nextLine();

        System.out.print("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = read.nextLine();
        System.out.print("Level: ");
        String workerLevel = read.nextLine();
        System.out.print("Base Salary: ");
        double baseSalary = read.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departament(departmentName));

        System.out.println("How many contracts to this worker? ");
        int n = read.nextInt();

        for(int i=1; i<=n; i++){
            System.out.println("Enter contract #" + i + " data: ");
            System.out.print("Date (DD/MM/YYYY)");
            Date contractDate = sdf.parse(read.next());
            System.out.print("Value per hour:   ");
            double valuePerHour = read.nextDouble();
            System.out.print("Duration (hours)");
            int hours = read.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.println("Enter month and yar to calculate income (MM/YYYY): ");
        String monthAndYear = read.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Nome: " + worker.getName());
        System.out.println("Department: " + worker.getDepartament().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

    }

}
