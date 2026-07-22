# AddressBook-System

A simple Java console-based address book application that supports storing and managing contacts.

## Features
- Add a contact with personal and address details
- Edit an existing contact by first name
- Delete a contact by first name
- Display all contacts
- Search a contact by first name
- Validate empty input, phone number format, email format, and menu choices

## Project structure
- src/Contact.java - contact model
- src/AddressBook.java - menu-driven address book logic
- src/AddressBookMain.java - application entry point

## How to run
From the project root, run:

```bash
javac src/Contact.java src/AddressBook.java src/AddressBookMain.java
java -cp src AddressBookMain
```

On Windows, you can also run:

```bat
run.bat
```
