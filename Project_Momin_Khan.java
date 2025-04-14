import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Project_Momin_Khan {
    public static void main(String[] args) {
        ArrayList<Policy> policies = new ArrayList<>();
        int smokerCount = 0;
        int nonSmokerCount = 0;

        try {
            Scanner fileScanner = new Scanner(new File("PolicyInformation.txt"));

            while (fileScanner.hasNextLine()) {
                String policyNumber = readNextLine(fileScanner);
                String providerName = readNextLine(fileScanner);
                String firstName = readNextLine(fileScanner);
                String lastName = readNextLine(fileScanner);
                int age = Integer.parseInt(readNextLine(fileScanner));
                String smokerStatus = readNextLine(fileScanner);
                double height = Double.parseDouble(readNextLine(fileScanner));
                double weight = Double.parseDouble(readNextLine(fileScanner));

                if (smokerStatus.equalsIgnoreCase("smoker")) {
                    smokerCount++;
                } else if (smokerStatus.equalsIgnoreCase("non-smoker")) {
                    nonSmokerCount++;
                }

                Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokerStatus, height, weight);
                policies.add(policy);
            }

            fileScanner.close();

            for (Policy policy : policies) {
                System.out.println(policy);
            }

            System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
            System.out.println("The number of policies with a smoker is: " + smokerCount);
            System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String readNextLine(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
        }
        return null;
    }
}
