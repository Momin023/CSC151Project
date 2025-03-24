import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Project_Momin_Khan {
    public static void main(String[] args) {
        // Initialize a list to store Policy objects
        ArrayList<Policy> policies = new ArrayList<>();
        int smokerCount = 0;   // To keep track of number of smokers
        int nonSmokerCount = 0; // To keep track of number of non-smokers

        try {
            // Create a scanner object to read from the file
            Scanner fileScanner = new Scanner(new File("PolicyInformation.txt"));
            
            // Read each policy from the file
            while (fileScanner.hasNextLine()) {
                // Read and process each line of the file in the required order

                // Read policy number (String)
                String policyNumber = readNextLine(fileScanner);
                if (policyNumber == null) break;  // Stop if data is incomplete

                // Read provider name (String)
                String providerName = readNextLine(fileScanner);
                if (providerName == null) break;

                // Read first name (String)
                String firstName = readNextLine(fileScanner);
                if (firstName == null) break;

                // Read last name (String)
                String lastName = readNextLine(fileScanner);
                if (lastName == null) break;

                // Read and parse age (Integer)
                int age = 0;
                String ageString = readNextLine(fileScanner);
                if (ageString != null) {
                    try {
                        age = Integer.parseInt(ageString.trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age format: " + ageString);
                        continue;  // Skip this record and proceed to the next one
                    }
                }

                // Read smoker status (String)
                String smokerStatus = readNextLine(fileScanner);
                if (smokerStatus == null) break;

                // Count smokers and non-smokers
                if (smokerStatus.equalsIgnoreCase("smoker")) {
                    smokerCount++;
                } else if (smokerStatus.equalsIgnoreCase("non-smoker")) {
                    nonSmokerCount++;
                }

                // Read and parse height (Double)
                double height = 0.0;
                String heightString = readNextLine(fileScanner);
                if (heightString != null) {
                    try {
                        height = Double.parseDouble(heightString.trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid height format: " + heightString);
                        continue;  // Skip this record and proceed to the next one
                    }
                }

                // Read and parse weight (Double)
                double weight = 0.0;
                String weightString = readNextLine(fileScanner);
                if (weightString != null) {
                    try {
                        weight = Double.parseDouble(weightString.trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid weight format: " + weightString);
                        continue;  // Skip this record and proceed to the next one
                    }
                }

                // Create a new Policy object using the values
                Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokerStatus, height, weight);

                // Add the Policy object to the list
                policies.add(policy);
            }

            // Close the file scanner after reading
            fileScanner.close();

            // Display the details of all the policies
            for (Policy policy : policies) {
                System.out.println("Policy Number: " + policy.getPolicyNumber());
                System.out.println("Provider Name: " + policy.getProviderName());
                System.out.println("Policyholder's First Name: " + policy.getFirstName());
                System.out.println("Policyholder's Last Name: " + policy.getLastName());
                System.out.println("Policyholder's Age: " + policy.getAge());
                System.out.println("Policyholder's Smoking Status: " + policy.getSmokerStatus());
                System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
                System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
                System.out.println("Policyholder's BMI: " + String.format("%.2f", policy.calculateBMI()));
                System.out.println("Policy Price: $" + String.format("%.2f", policy.calculatePolicyPrice()));
            }

            // Display the number of smokers and non-smokers
            System.out.println("\nThe number of poilicies with a smoker is: " + smokerCount);
            System.out.println("The number of poilicies with a non-smoker is: " + nonSmokerCount);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Reads the next non-empty line from the file.
     * Returns null if no valid line is found.
     */
    private static String readNextLine(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
        }
        return null;  // Return null if no valid lines are found
    }
}
