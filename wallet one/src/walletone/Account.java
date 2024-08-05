package walletone;

public abstract class Account {

    static int accountIndex = 100100;
    String accountNumber;
    String randomBinNumber = BinList.getRandomBinNumber();

    // List of shared properties for virtual cards
    public String fullName;
    public String zipCode;

    // Constructor to set base properties and initialize the card
    public Account(String fullName, String zipCode) {
        this.fullName = fullName;
        this.zipCode = zipCode;

        // Set account number
        ++accountIndex;
        this.accountNumber = setAccountNumber();
    }

    // Create user account number
    private String setAccountNumber() {
        String firstThreeOfZipCode = zipCode.substring(0, 3);
        return accountIndex + firstThreeOfZipCode;
    }

    // List common methods
    public void showCardInfo() {
        System.out.println("Full name: " + fullName);
        System.out.println("ZIP code: " + zipCode);
        System.out.println("Account number: " + this.accountNumber);
    }

}
