public class Policy {
    private String policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokerStatus;
    private double height;
    private double weight;
//default values initialization
    public Policy() {
        this.policyNumber = "";
        this.providerName = "";
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.smokerStatus = "non-smoker";
        this.height = 0;
        this.weight = 0;
    }

    public Policy(String policyNumber, String providerName, String firstName, String lastName,
                  int age, String smokerStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokerStatus = smokerStatus;
        this.height = height;
        this.weight = weight;
    }
//method to calculate BMI
    public double calculateBMI() {
        if (height == 0) {
            return 0;
        }
        return (weight * 703) / (height * height);
    }
//method to calculate policy price
    public double calculatePolicyPrice() {
        double basePrice = 600;
        double additionalFee = 0;

        if (age > 50) {
            additionalFee += 75;
        }
        if (smokerStatus.equalsIgnoreCase("smoker")) {
            additionalFee += 100;
        }
        if (calculateBMI() > 35) {
            double bmi = calculateBMI();
            additionalFee += (bmi - 35) * 20;
        }

        return basePrice + additionalFee;
    }
//getters and setters
    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSmokerStatus() {
        return smokerStatus;
    }

    public void setSmokerStatus(String smokerStatus) {
        this.smokerStatus = smokerStatus;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
