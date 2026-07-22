# UC4 Implementation Summary

## Files changed
- src/AddressBook.java: added delete-contact functionality by first name, along with success and not-found messages.
- src/AddressBookMain.java: kept the main entry point aligned with the updated menu.
- TASKS.md: recorded the UC4 task checklist.

## What was added
- Implemented the UC4 delete-contact workflow.
- Added clear success and failure messages for delete operations.

## Verification
- Compiled successfully with javac.
- Ran the program with sample input covering a successful deletion and a not-found case.

## Assumption
- The delete flow removes the first matching contact by first name.
