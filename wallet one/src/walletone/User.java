package walletone;

public class User {
    private final String fullName;
    private final String zipCode;

    public User(String fullName, String zipCode) {
        this.fullName = fullName;
        this.zipCode = zipCode;
    }

    // Getters and setters
    public String getName() {
        return fullName;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return "Full name: " + fullName + "\nZip code: " + zipCode;
    }
}
