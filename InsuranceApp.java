package org.bootcamp.javaActivity2.BadCode;

import java.util.*;
import java.util.function.*;

// Example of an interface with private method and functional interface usage
interface InsurancePolicy {
    private void validatePolicy() {
        // Private method in interface
        System.out.println("Validating policy...");
    }

    static List<String> createPolicyTypes() {
        return Arrays.asList("Health", "Car", "Home"); // Immutable factory method for List
    }

    default void processPolicy(String type) {
        validatePolicy();
        System.out.println("Processing policy type: " + type);
    }
}

public class InsuranceApp {
    public static void main(String[] args) {
        // Immutable factory methods
        List<String> policyTypes = Arrays.asList("Health", "Car", "Home"); // Using Arrays.asList() instead of List.of()
        Set<String> customers = new HashSet<>(Arrays.asList("Alice", "Bob", "Charlie")); // Using HashSet instead of Set.of()
        Map<String, Integer> policyLimits = new HashMap<>();
        policyLimits.put("Health", 100000);
        policyLimits.put("Car", 50000);
        policyLimits.put("Home", 200000);

        // Optional
        String typeOfInsurance = "Health";
        Optional<String> optionalType = Optional.ofNullable(typeOfInsurance); // Using Optional.ofNullable() instead of Optional.of()
        optionalType.ifPresent(new Consumer<String>() { // Using anonymous inner class instead of lambda
            @Override
            public void accept(String s) {
                System.out.println("Found optional typeOfInsurance: " + s);
            }
        });

        // ForEach
        for (String customer : customers) { // Using traditional for loop instead of forEach
            System.out.println("Processing customer: " + customer);
        }

        // Calling methods from interface
        InsurancePolicy.createPolicyTypes().forEach(type -> {
            InsurancePolicy policy = new InsurancePolicy() {
                @Override
                public void processPolicy(String type) {
                    System.out.println("Processing policy typeOfInsurance: " + type);
                }
            };
            policy.processPolicy(type);
        });
    }
}

