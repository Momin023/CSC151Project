/**
 * Represents an insurance policy with personal details and methods to calculate BMI and policy price.
 */
public class Policy {
    private String policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokerStatus;
    private double height;
    private double weight;

    /**
     * Default constructor that initializes the policy with default values.
     */
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

    /**
     * Parameterized constructor to initialize a policy with specific values.
     *
     * @param policyNumber the policy number
     * @param providerName the name of the insurance provider
     * @param firstName the first name of the policyholder
     * @param lastName the last name of the policyholder
     * @param age the age of the policyholder
     * @param smokerStatus the smoking status of the policyholder (smoker/non-smoker)
     * @param height the height of the policyholder in inches
     * @param weight the weight of the policyholder in pounds
     */
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

    /**
     * Calculates the BMI (Body Mass Index) of the policyholder.
     * The BMI is calculated using the formula: (weight * 703) / (height * height).
     * If the height is 0, the BMI will be 0 to avoid division by zero.
     *
     * @return the BMI value for the policyholder, or 0 if height is 0.
     */
    public double calculateBMI() {
        if (height == 0) {
            return 0;
        }
        return (weight * 703) / (height * height);
    }

    /**
     * Calculates the insurance policy price based on the policyholder's details.
     * The price is based on a base price and additional fees determined by the policyholder's age, smoking status, and BMI.
     * 
     * @return the calculated price of the policy.
     */
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

    /**
     * Gets the policy number.
     *
     * @return the policy number.
     */
    public String getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Sets the policy number.
     *
     * @param policyNumber the policy number to set.
     */
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    /**
     * Gets the provider name.
     *
     * @return the provider name.
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Sets the provider name.
     *
     * @param providerName the provider name to set.
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /**
     * Gets the first name of the policyholder.
     *
     * @return the first name of the policyholder.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the policyholder.
     *
     * @param firstName the first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the policyholder.
     *
     * @return the last name of the policyholder.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the policyholder.
     *
     * @param lastName the last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the age of the policyholder.
     *
     * @return the age of the policyholder.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the policyholder.
     *
     * @param age the age to set.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the smoking status of the policyholder.
     *
     * @return the smoking status of the policyholder.
     */
    public String getSmokerStatus() {
        return smokerStatus;
    }

    /**
     * Sets the smoking status of the policyholder.
     *
     * @param smokerStatus the smoking status to set.
     */
    public void setSmokerStatus(String smokerStatus) {
        this.smokerStatus = smokerStatus;
    }

    /**
     * Gets the height of the policyholder.
     *
     * @return the height of the policyholder in inches.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the policyholder.
     *
     * @param height the height to set.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Gets the weight of the policyholder.
     *
     * @return the weight of the policyholder in pounds.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the policyholder.
     *
     * @param weight the weight to set.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }
}
