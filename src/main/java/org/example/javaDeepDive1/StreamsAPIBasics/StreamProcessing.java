package org.example.javaDeepDive1.StreamsAPIBasics;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StreamProcessing {
    public static void main(String[] args) {
        List<Book> books = getbooks();

        // Calculate the average rating of all books
        OptionalDouble averageRating = books.stream()
                .mapToDouble(Book::getRating)
                .average();
        averageRating.ifPresent(System.out::println);
        System.out.println();


        // Filter and display books published after a specific year
        books.stream()
                .filter(book -> book.getPublicationYear() > 1900)
                .forEach(System.out::println);


        // Sort books by rating in descending order
        List<Book> sorted = books.stream()
                .sorted(Comparator.comparing(Book::getRating).reversed())
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
        System.out.println();


        // Find and display the title of the highest-rated book
        books.stream()
                .max(Comparator.comparing(book -> book.getRating()))
                .ifPresent(System.out::println);
        System.out.println();


        // Group books by author and calculate average rating for each author
        books.stream()
                .collect(Collectors.groupingBy(book -> book.getAuthor()))
                .forEach((author, books1) -> books1.stream().mapToDouble(Book::getRating).average()
                        .ifPresent(avg -> System.out.println("Author: " + author + " Rating: " + avg)));
        System.out.println();


        // Calculate the total number of pages for all books
        System.out.println("Amount of pages in total :" + books.stream()
                .mapToDouble(Book::getPages)
                .sum());
    }


    public static List<Book> getbooks() {
        return List.of(
                new Book("To Kill a Mockingbird", "Harper Lee", 1960, 4.28, 281),
                new Book("1984", "George Orwell", 1949, 4.17, 328),
                new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 3.92, 180),
                new Book("Pride and Prejudice", "Jane Austen", 1813, 4.26, 279),
                new Book("The Catcher in the Rye", "J.D. Salinger", 1951, 3.81, 277),
                new Book("The Hobbit", "J.R.R. Tolkien", 1937, 4.27, 310),
                new Book("Moby-Dick", "Herman Melville", 1851, 3.51, 635)
        );
    }
}
