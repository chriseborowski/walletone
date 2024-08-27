# WalletOne: Virtual Credit Card Management System

  <img src="wallet one/images/WalletOne-Virtual-Credit-Card-Management-System-Java-app-logo.jpg" alt="WalletOne: Virtual Credit Card Management System" title="WalletOne: Virtual Credit Card Management System" />

WalletOne is a robust Java-based virtual credit card management system designed for efficient handling of card information, user data, and related operations, all in the command-line interface (CLI). For a detailed description and overview of its main functionalities, see this blog post: [Introducing WalletOne: An Interactive Java Backend App Featuring a Virtual Credit Card Management System](https://chriseborowski.notion.site/Introducing-WalletOne-An-Interactive-Java-Backend-App-Featuring-a-Virtual-Credit-Card-Management-Sy-ae31693fde4249f28a142ddda560f637).

## Key Features

- [x] Add and remove credit cards with unique card numbers
- [x] Manage multiple users per card
- [x] Search functionality by zip code and user name
- [x] Display detailed card information
- [x] Constant-time card lookup using hash-based data structures
- [x] Efficient user management with multi-key indexing

## Technical Highlights

- **Constant-time Card Lookup**: Utilizes HashMap for O(1) card retrieval by card number
- **Multi-key Indexing**: Implements separate HashMaps for zip code and name-based user lookups
- **Memory-efficient User Storage**: Uses a shared User object across different indexes
- **HashMap-based Card Storage**: 
  The `CardManager` class uses a `HashMap<String, Card>` (cardHashMap) for O(1) card retrieval by card number.
- **Scalable Architecture**: Designed to handle a large number of cards and users efficiently

## Installation

1. Ensure you have Java Development Kit (JDK) 8 or higher installed on your system.
2. Clone the repository:
   
`git clone https://github.com/chriseborowski/walletone.git`

3. Navigate to the project directory:
   
`cd walletone`

4. Compile the Java files:

`javac -d bin src/walletone/*.java`

## Usage

1. Run the main application:

`java -cp bin walletone.Main`

2. Follow the on-screen prompts to interact with the system.

## Class Structure

- `Card`: Represents a credit card with associated users
- `User`: Represents a card user with name and zip code
- `CardManager`: Core class managing all card operations and user lookups
- `Main`: Entry point of the application (not provided in the context, but assumed to exist)

## Key Methods

- `addNewCard`: Adds a new card to the system
- `removeCard`: Removes a card and updates all related data structures
- `addUserToCard`: Adds a new user to an existing card
- `searchByZip`: Retrieves users by zip code
- `searchByName`: Retrieves users by name
- `showAllCards`: Displays information for all cards in the system

## Performance Considerations

- Card lookup: O(1) time complexity
- User lookup by zip code or name: O(1) average case, O(n) worst case where n is the number of users with the same zip code or name
- Adding/Removing cards: O(1) time complexity
- Adding users to a card: O(1) amortized time complexity

## Future Enhancements

- Implement data persistence (database integration)
- Add user authentication and authorization
- Develop a graphical user interface (GUI)
- Implement card transaction tracking and analysis

## Contributing

Contributions are welcome! Please feel free to submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
