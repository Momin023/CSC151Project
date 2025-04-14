public class Policy {
    private String policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;

    private static int policyCount = 0;

    public Policy(String policyNumber, String providerName, String firstName, String lastName, int age, String smokerStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = new PolicyHolder(firstName, lastName, age, smokerStatus, height, weight);
        policyCount++;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getFirstName() {
        return policyHolder.getFirstName();
    }

    public String getLastName() {
        return policyHolder.getLastName();
    }

    public int getAge() {
        return policyHolder.getAge();
    }

    public String getSmokerStatus() {
        return policyHolder.getSmokerStatus();
    }

    public double getHeight() {
        return policyHolder.getHeight();
    }

    public double getWeight() {
        return policyHolder.getWeight();
    }

    public double calculateBMI() {
        return policyHolder.calculateBMI();
    }

    public double calculatePolicyPrice() {
        double baseFee = 600.0;
        double additionalFee = 0.0;

        if (policyHolder.getAge() > 50) {
            additionalFee += 75.0;
        }
        if (policyHolder.getSmokerStatus().equalsIgnoreCase("smoker")) {
            additionalFee += 100.0;
        }
        if (calculateBMI() > 35) {
            additionalFee += 75.0;
        }

        return baseFee + additionalFee;
    }

    public static int getPolicyCount() {
        return policyCount;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + "\n" +
               "Provider Name: " + providerName + "\n" +
               policyHolder.toString() + "\n" +
               "Policy Price: $" + String.format("%.2f", calculatePolicyPrice()) + "\n";
    }
}
