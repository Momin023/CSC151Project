import java.util.Scanner;

public class Project_Momin_Khan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a new Policy object
        Policy policy = new Policy();

        // Taking user input for policy details
        System.out.print("Please enter the Policy Number: ");
        policy.setPolicyNumber(scanner.nextLine());

        System.out.print("Please enter the Provider Name: ");
        policy.setProviderName(scanner.nextLine());

        System.out.print("Please enter the Policyholder's First Name: ");
        policy.setFirstName(scanner.nextLine());

        System.out.print("Please enter the Policyholder's Last Name: ");
        policy.setLastName(scanner.nextLine());

        System.out.print("Please enter the Policyholder's Age: ");
        policy.setAge(scanner.nextInt());
        
        scanner.nextLine(); // Consume the leftover newline character

        System.out.print("Please enter the Policyholder's Smoking Status (smoker/non-smoker): ");
        policy.setSmokerStatus(scanner.nextLine());

        System.out.print("Please enter the Policyholder's Height (in inches): ");
        policy.setHeight(scanner.nextDouble());

        System.out.print("Please enter the Policyholder's Weight (in pounds): ");
        policy.setWeight(scanner.nextDouble());

        // Displaying the required output in the specified format
        System.out.println("\nSample Output:");
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

        scanner.close(); // Close the scanner to avoid resource leak
    }
}
