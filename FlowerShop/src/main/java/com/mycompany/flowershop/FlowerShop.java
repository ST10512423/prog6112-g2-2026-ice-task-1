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

static final String[] DAYS = {
"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
};
static final String[] BOUQUETS = {"Roses", "Tulips", "Lilies"};

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
