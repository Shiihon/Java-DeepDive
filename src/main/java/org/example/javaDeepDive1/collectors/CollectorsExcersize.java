package org.example.javaDeepDive1.collectors;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsExcersize {

    public static void main(String[] args) {
        List<Transaction> transactions = getTransactions();

        // Calculate the total sum of all transaction amounts
        double totalSum = transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
        System.out.println("Total sum of all transactions : " + totalSum);
        System.out.println(); //space


        double totalSumUsingCollectors = transactions.stream()
                .collect(Collectors.summingDouble(Transaction::getAmount));
        System.out.println("Total sum of all transactions using collectors : " + totalSumUsingCollectors);
        System.out.println(); //space


        // Group transactions by currency and calculate sum for each currency
        Map<String, Double> sumByCurrency = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCurrency,
                        Collectors.summingDouble(Transaction::getAmount)));

        sumByCurrency.forEach((currency, sum) ->
                System.out.println("Currency : " + currency + ", Total amount : " + sum + " " + currency));
        System.out.println(); // space


        // Find the highest transaction amount
        transactions.stream()
                .collect(Collectors.maxBy(Comparator.comparing(transaction -> transaction.getAmount())))
                //.max(Comparator.comparing(transaction -> transaction.getAmount()))            : If Collect isn't used.
                .ifPresent(transaction ->
                        System.out.printf("The highest transaction amount is: %.2f %s%n",
                                //%.2F = refers to double, then %s = placeholder for a string "currency", %n = adds new line in the end.
                                transaction.getAmount(), transaction.getCurrency()));


        // Find the average transaction amount
        double averageAmount = transactions.stream()
                .collect(Collectors.averagingDouble(Transaction::getAmount));
        System.out.println("The average amount of all transactions : " + averageAmount);
    }

    private static List<Transaction> getTransactions() {
        return List.of(
                new Transaction(1, 100.0, "USD"),
                new Transaction(2, 150.0, "EUR"),
                new Transaction(3, 200.0, "USD"),
                new Transaction(4, 75.0, "GBP"),
                new Transaction(5, 120.0, "EUR"),
                new Transaction(6, 300.0, "GBP")
        );

    }
}
