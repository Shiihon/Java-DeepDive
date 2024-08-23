package org.example.javaDeepDive1.fridayEx2308;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString(callSuper = true) // This will include the fields from the superclass in the toString method
@NoArgsConstructor
@AllArgsConstructor
public class GardenTask extends Task {
    private String gardenLocation;
}
