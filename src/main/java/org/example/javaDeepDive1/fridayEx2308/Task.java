package org.example.javaDeepDive1.fridayEx2308;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Task {
    private String title;
    private String description;
    private LocalDate dueDate;
}
