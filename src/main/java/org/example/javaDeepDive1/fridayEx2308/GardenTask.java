package org.example.javaDeepDive1.fridayEx2308;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true) // This will include the fields from the superclass in the toString method
public class GardenTask extends Task {
    private String gardenLocation;

    public GardenTask(String title, String description, LocalDate dueDate, String gardenLocation) {
        super(title, description, dueDate);
        this.gardenLocation = gardenLocation;
    }
}
