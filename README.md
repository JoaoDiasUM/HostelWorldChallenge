# HostelWorldChallenge

https://github.com/user-attachments/assets/6a752e07-4958-4075-bfc7-b9dad0a5b0c1

## Repository Discription
This repository was created with the aim to build a sample app for the Hostelworld code challenge. This app was made with the goal to display a list of properties with general information about them while being to open a details view for 
an individual property to known more details.

## Implementation Notes
The app is separated into 3 principal packages of data, domain and presentation by feature following the principles of clean architecture for single responsibility use cases, making the components more independent and easier to test.
Also following MVVM principles in the presentation layer like the viewmodel acting like a bridge between the composable views and the models.
The viewmodel makes use of mutable state flow to provide a reactive and efficient way of handling view interactions and updates, updating the UI when requests or user inputs are made and also diplaying error messages.

## Considerations
- Filtering property list by if is featured or from newer to older
- Animated splash screen
- Checking Rates periodically

## Limitation
- Maps can be somewhat slow to load

