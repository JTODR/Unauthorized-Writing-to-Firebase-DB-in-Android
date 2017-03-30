# Unauthorized-Writing-to-Firebase-DB-in-Android
This Android activity will write to a connected Firebase database. The user does not have to be authorized prior to writing to the database. 

This simple app is an example of writing to a Firebase database.

I used Android Studio 2.2.3 and was therefore able to sign into Android Studio using my Google account. Click the small icon on the top right corner to do this. Then go to the Tools tab and select Firebase. When the Firebase window opens, select Realtime Database and connect your app to Firebase. Then select Add the Realtime Database to your App, this will set up the dependencies for the app.

Log into Firebase with the same Google account as in Android Studio and find your new project in the Console. Go to the Database tab on the left and change the rules of the database to:

{
  "rules": {
    ".read": "auth == null",
    ".write": "auth == null"
  }
}

These rules will allow for unauthorized writing to the database
