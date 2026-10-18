# Log-In 🔐

**Completed:** December 14, 2025

Log-In is a Java command-line application that allows users to register accounts and log in using a username and password.

The application includes password validation, SHA-256 hashing, username availability checks, and local account storage using a text file.

I developed this project to explore the fundamentals of authentication systems, password hashing, file handling, and organizing Java applications across multiple classes.

**Note:** This is an educational project designed to demonstrate basic authentication concepts. It is not intended for real-world account security.

## Features

- **User registration:** Create new accounts with a username and password.
- **Login verification:** Verify entered credentials against registered accounts.
- **Password hashing:** Convert passwords into SHA-256 hashes before storing them.
- **Password validation:** Require a minimum password length, four numbers, and four special characters.
- **Username availability:** Check whether a username is already registered.
- **Username suggestions:** Generate alternative usernames when the selected name is unavailable.
- **Local account storage:** Save registered usernames and password hashes in a `.txt` file.
- **Persistent accounts:** Registered accounts remain available after restarting the application.
- **Terminal interface:** Includes ASCII-art headings, status messages, and interactive prompts.

## Requirements

- Java Development Kit (JDK) 11 or newer
- No additional libraries required

The application uses Java's built-in libraries for file handling, cryptographic hashing, user input, and collections.

## Installation

1. Download or clone this repository.
2. Make sure Java JDK 11 or newer is installed.
3. Open a terminal in the repository's main directory.
4. Compile the Java source files:

   ```bash
   javac -encoding UTF-8 -d bin src/MainTer.java src/Hash.java src/TxtReader.java src/TxtWrite.java src/TxtChecker.java src/TxtUsernameCheck.java src/SignPassCheck.java
   ```

5. Run the program:

   ```bash
   java -cp bin MainTer
   ```

The included `login.txt` contains fictional demonstration accounts and should remain in the repository's main directory.

## How to Use

When the application starts, it displays an introduction and asks the user to choose between registering a new account and logging into an existing account.

### 1. Account Registration (Sign In)

To create an account, enter `Sign In` or `s` when the application starts.

The program then guides the user through the registration process.

**Step 1 — Username selection**

Enter your preferred username.

The program checks whether the username is already registered.

If the name is taken, the application suggests an alternative by adding randomly generated numbers.

You can accept the suggestion or enter another username.

**Step 2 — Password creation**

Enter a password that satisfies the following requirements:

| Requirement | Minimum |
|---|---|
| Password length | 8 characters |
| Numbers | 4 |
| Special characters | 4 |

The `:` character is not permitted in usernames or passwords because it is used as a separator in the account storage file.

**Step 3 — Password hashing**

After validation, the password is passed to the SHA-256 hashing function.

The program stores the username and resulting hash rather than the original password.

**Step 4 — Account storage**

The new account is added to the existing records in `login.txt`.

After successful registration, the application displays a confirmation message.

### 2. Logging In (Log In)

To access an existing account, enter `Log In` or `l` when the program starts.

The application asks for:

1. Username
2. Password

The entered password is hashed using SHA-256 and compared with the hash stored for that username.

If both values match, the program displays:

```text
You are successfully loged in!
```

Otherwise, it displays:

```text
Password/username invalid or account hasnt been created!
```

The current application verifies credentials but does not create a persistent authenticated session.

## Example Accounts

The repository includes a `login.txt` file containing two fictional test accounts.

| Username | Password |
|---|---|
| `demo` | `Demo!@#$1234` |
| `school_test` | `School!@#$5678` |

These accounts are included exclusively for demonstration and testing purposes.

They do not represent real users or credentials used by other services.

Passwords are stored as SHA-256 hashes in the following format:

```text
username:password_hash
```

For example:

```text
demo:28c804bdf24503b70506abb0c28998e91f4a817e0ee9f3add79acc9847579d6c
```

The program reads these records when it starts and uses them during authentication.

## How It Works

The application is divided into seven main Java classes, each responsible for a specific function.

### 1. MainTer.java — Main Application

Contains the `main()` method and controls the overall application.

Its responsibilities include:

- Loading registered accounts.
- Displaying the program introduction.
- Selecting registration or login mode.
- Collecting usernames and passwords.
- Calling the appropriate validation and hashing methods.
- Displaying the results.

This class connects the different components of the authentication system.

### 2. TxtReader.java — Reading Account Data

Reads existing account information from `login.txt`.

Each line is split into a username and password hash using the `:` separator.

The values are stored in two separate lists:

```java
static List<String> usernames = new ArrayList<>();
static List<String> passwords = new ArrayList<>();
```

The application can then access the loaded account information when validating usernames or checking login credentials.

### 3. TxtUsernameCheck.java — Username Validation

Checks whether the requested username already exists.

The method:

```java
public static boolean checkUserTXT(String username)
```

searches through the existing username list.

It returns:

- `true` if the username is already registered.
- `false` if the username is available.

If the username is already taken, the registration process can suggest an alternative.

### 4. SignPassCheck.java — Password Validation

Checks whether a new password meets the required character conditions.

The method:

```java
public static boolean pass_CHECK(String pass)
```

examines the password character by character.

It counts:

- Numerical characters (`0–9`).
- Non-alphanumeric characters.

The method returns `false` when the required counts are satisfied and `true` otherwise.

The password-length requirement is checked separately in `MainTer.java`.

### 5. Hash.java — Password Hashing

Uses Java's built-in `MessageDigest` class to calculate a SHA-256 hash.

```java
MessageDigest md = MessageDigest.getInstance("SHA-256");
byte[] result = md.digest(s.getBytes(StandardCharsets.UTF_8));
```

The resulting bytes are converted into a hexadecimal string.

SHA-256 always produces a 256-bit digest, normally represented as 64 hexadecimal characters.

During registration, the hash is stored in `login.txt`.

During login, the entered password is hashed again so it can be compared with the stored value.

**Important:** SHA-256 is a hashing algorithm, not encryption. Although the original password is not stored directly, SHA-256 without a salt or password-specific hashing scheme is not appropriate for protecting real user passwords.

### 6. TxtChecker.java — Login Verification

The method:

```java
public static boolean checkTXT(String username, String password)
```

checks whether the entered username exists and whether its associated hash matches the supplied password hash.

It returns:

- `true` when both values match.
- `false` when the username is not found or the hash is incorrect.

This result determines whether the program displays a successful login message.

### 7. TxtWrite.java — Saving Account Data

Handles writing account information to `login.txt`.

It uses Java's `FileWriter` class to save the username and password-hash lists.

Each record follows this structure:

```text
username:password_hash
```

After registration, the application rewrites the text file using the updated lists, preserving the loaded accounts and adding the new account.

## Project Structure

```text
Log-In/
├── src/
│   ├── MainTer.java
│   ├── Hash.java
│   ├── TxtReader.java
│   ├── TxtWrite.java
│   ├── TxtChecker.java
│   ├── TxtUsernameCheck.java
│   └── SignPassCheck.java
├── login.txt
├── .gitignore
└── README.md
```

The `login.txt` file contains fictional demonstration accounts.

Generated Java `.class` files and the `bin/` directory are excluded from the public source repository.

## Known Limitations

- **Educational authentication only:** The application is not designed for production use.
- **Unsalted SHA-256:** Passwords are hashed with SHA-256 without individual salts, making them vulnerable to offline password guessing if the hashes are exposed.
- **Local text storage:** Accounts are stored in a readable `.txt` file rather than a secured database.
- **Visible password input:** Passwords are displayed in the terminal while being entered.
- **No authenticated session:** Successful login only displays a confirmation message.
- **No password recovery:** Users cannot reset or recover forgotten passwords through the application.
- **Limited error handling:** Missing or malformed account files can cause errors.
- **Inconsistent password messages:** Some displayed password-length instructions differ from the actual validation condition.
- **No graphical interface:** The application runs entirely through the terminal.
- **Limited login attempts:** The current program does not implement account lockout or rate limiting.

## Development Note

I created this project to experiment with the basic components of an authentication system.

It helped me develop my understanding of Java programming, multiple-class applications, file operations, lists, password validation, and cryptographic hashing.

The project represents my programming knowledge at the time of its development. Known security and implementation limitations are documented rather than redesigning the original application.

The public version uses fictional test accounts and a relative file path instead of a personal Windows directory.



**Author:** [Nik Berginc](https://github.com/nikberginc)
