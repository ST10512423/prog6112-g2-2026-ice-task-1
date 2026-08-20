/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.flowershop;

/**
 *
 * @author singh
 */
import java.util.Scanner;

public class FlowerShop {

    
//2D array to stores weekly sale    
static final String[] DAYS = {
"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
};
static final String[] BOUQUETS = {"Roses", "Tulips", "Lilies"};


//Enter sales data
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
int[][] sales = new int[DAYS.length][BOUQUETS.length];

enterSales(scanner, sales);

int[] bouquetTotals = calculateBouquetTotals(sales);
int[] dailyTotals = calculateDailyTotals(sales);
int overallTotal = calculateOverallTotal(bouquetTotals);

displaySales(sales, dailyTotals, bouquetTotals, overallTotal);

scanner.close();
}
    
    
static void enterSales(Scanner scanner, int[][] sales) {
        for (int day = 0; day < DAYS.length; day++) {
            for (int bouquet = 0; bouquet < BOUQUETS.length; bouquet++) {
                System.out.print("Enter sales for " + DAYS[day] + " - " + BOUQUETS[bouquet] + ": ");
                sales[day][bouquet] = scanner.nextInt();
            }
            System.out.println();
        }
    }


static int[] calculateBouquetTotals(int[][] sales) {
        int[] totals = new int[BOUQUETS.length];
        for (int bouquet = 0; bouquet < BOUQUETS.length; bouquet++) {
            int sum = 0;
            for (int day = 0; day < DAYS.length; day++) {
                sum += sales[day][bouquet];
            }
            totals[bouquet] = sum;
        }
        return totals;
    }


static int[] calculateDailyTotals(int[][] sales) {
        int[] totals = new int[DAYS.length];
        for (int day = 0; day < DAYS.length; day++) {
            int sum = 0;
            for (int bouquet = 0; bouquet < BOUQUETS.length; bouquet++) {
                sum += sales[day][bouquet];
            }
            totals[day] = sum;
        }
        return totals;
    }


static int calculateOverallTotal(int[] bouquetTotals) {
        int total = 0;
        for (int i = 0; i < bouquetTotals.length; i++) {
            total += bouquetTotals[i];
        }
        return total;
    }

//Dsiplays weekly report
static void displaySales(int[][] sales, int[] dailyTotals,
        int[] bouquetTotals, int overallTotal) {

    String border = "=============================================";
    String border2 = "------------------------------------------------";

    System.out.println(border);
    System.out.println("       FLOWER SHOP WEEKLY SALES REPORT");
    System.out.println(border);
    System.out.println();

    
    System.out.printf("%-12s %8s %8s %8s %8s%n",
        "DAY", "ROSES", "TULIPS", "LILIES", "TOTAL");

    System.out.println(border2);

    for (int day = 0; day < DAYS.length; day++) {

System.out.printf("%-12s %8d %8d %8d %8d%n",
        DAYS[day],
        sales[day][0],
        sales[day][1],
        sales[day][2],
        dailyTotals[day]);
}

    System.out.println(border2);

    System.out.printf("%-12s %8d %8d %8d %8d%n",
    "TOTAL",
    bouquetTotals[0],
    bouquetTotals[1],
    bouquetTotals[2],
    overallTotal);

    System.out.println();
    
    System.out.println("Total sales for Roses: R" + bouquetTotals[0]);
    System.out.println("Total sales for Tulips: R" + bouquetTotals[1]);
    System.out.println("Total sales for Lilies: R" + bouquetTotals[2]);

    System.out.println();

    for (int day = 0; day < DAYS.length; day++) {
        System.out.println("Total sales for " + DAYS[day]
                + ": R " + dailyTotals[day]);
    }

    System.out.println();

    System.out.println("Overall total sales for the week: R" + overallTotal);
}
}