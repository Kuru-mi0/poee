package poe;

import javax.swing.JOptionPane;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        String yourName = JOptionPane.showInputDialog("Enter your name"); //input name
        String surname = JOptionPane.showInputDialog("Enter your surname"); //input surname

        boolean checkUserName = false;
        String username = "";

        while (!checkUserName) {

            username = JOptionPane.showInputDialog("Create your username" + "\n" + "Your username must contain 5 characters and a _");
            int usernameSize = username.length();

            boolean checkUserLength = usernameSize == 5; //checks username length
            boolean checkUserSpecialC = false;

            for (char UsernameC : username.toCharArray()) {
                if ("_".contains(String.valueOf(UsernameC))) { //makes sure it has an underscore
                    checkUserSpecialC = true;
                    break;
                }
            }
            checkUserName = checkUserLength && checkUserSpecialC;

            if (checkUserName) {
                String userMessage = "Username successfully captured";
                JOptionPane.showMessageDialog(null, userMessage); //if username is correct
            } else {
                String userMessageFail = "Username is ot correctly formatted, please ensure that your username contains an underscore and is no longer than 5 characters long.";
                JOptionPane.showMessageDialog(null, userMessageFail); //if username is incorrect
            }
        }
        String password = null;
        boolean checkPasswordComplexity = false;

        boolean checkLogin = false;
        while (!checkPasswordComplexity) {

            password = JOptionPane.showInputDialog("Create your password, must contain: " +
                    "8 characters, a capital letter, a number, a special character.");
            int passwordSize = password.length();

            boolean checkPasswordLength = passwordSize == 8; //checks password length
            boolean checkPasswordSpecial = false;
            boolean checkPasswordCapital = false;
            boolean checkPasswordNumber = false;

            for (char PasswordCharacters : password.toCharArray()) { //checks if password has all the inputs needed
                if ("*&^%$#@!<>".contains(String.valueOf(PasswordCharacters))) {
                    checkPasswordSpecial = true;
                } else if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(String.valueOf(PasswordCharacters))) {
                    checkPasswordCapital = true;
                } else if ("1234567890".contains(String.valueOf(PasswordCharacters))) {
                    checkPasswordNumber = true;
                }
            }

            checkPasswordComplexity = checkPasswordLength && checkPasswordSpecial && checkPasswordCapital && checkPasswordNumber;

            if (checkPasswordComplexity) {
                String registerUser = "Password successfully captured";

                JOptionPane.showMessageDialog(null, registerUser);
            } else {
                String registerUser = "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";

                JOptionPane.showMessageDialog(null, registerUser);

            }

            while (!checkLogin) {

                String UsernameLogin = JOptionPane.showInputDialog("Please enter your username"); //username attempt
                String PasswordLogin = JOptionPane.showInputDialog("Please enter your password"); //password attempt

                boolean UsernameCorrect = Objects.equals(UsernameLogin, username); //checks if username is the same as the saved one
                boolean PasswordCorrect = Objects.equals(PasswordLogin, password); //checks if password is the same as the saved one

                checkLogin = UsernameCorrect && PasswordCorrect;

                if (checkLogin) {
                    String LoginSuccess = "Welcome" + " " + yourName + " " + surname + ", " + "Good to see you again!";
                    JOptionPane.showMessageDialog(null, LoginSuccess); //if login is successful
                } else {
                    String LoginFail = "Username or password is incorrect. Try again."; //if login is unsuccessful
                    JOptionPane.showMessageDialog(null, LoginFail);
                }
            }

        }


        // part 2


        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");


        int taskNumber = 1;
        // Allow the logged-in user to create as many tasks as they want
        // if user has logged in (checkLogin == true) then as how many tasks they must add
        while (checkLogin) {
            // Show JOptionPane.showInputDialog
            // Save input to choice

            // Define an array of custom options for the dialog
            Object[] options = {"1 - Add Tasks", "2 - Show Report - Coming soon", "3 - Quit"};

            // Display an option dialog with custom options
            // The user's choice is stored in the 'choice'
            // variable
            int choice = JOptionPane.showOptionDialog(
                    null, // Parent component (null means center on screen)
                    "Select your option.", // Message to display
                    "Options", // Dialog title
                    JOptionPane.YES_NO_CANCEL_OPTION, // Option type (Yes, No, Cancel)
                    JOptionPane.QUESTION_MESSAGE, // Message type (question icon)
                    null, // Custom icon (null means no custom icon)
                    options, // Custom options array
                    options[2] // Initial selection (default is "Cancel")
            );

            switch (choice) {
                case 0:

                    String numTaskMaking = JOptionPane.showInputDialog("Enter how many tasks you want to add");
                    int i = Integer.parseInt(numTaskMaking);
                    int t = 0;

                    while (i > 0) {

                        String taskName = JOptionPane.showInputDialog("Please enter your task name");

                        //Task t1 = new Task(taskName, taskNumber++);

                        String taskDesc;
                        boolean isValidDescription;
                        do {
                            taskDesc = JOptionPane.showInputDialog("Please enter your task description of 50 characters or less.");
                            int descSize = taskDesc.length();
                            isValidDescription = descSize <= 50;
                            if (!isValidDescription) {
                                String descBad = "Description not valid, it may not exceed 50 characters";
                                JOptionPane.showMessageDialog(null, descBad);
                            }

                        }
                        while (!isValidDescription);
                        {

                            String enterDevName = JOptionPane.showInputDialog("Please enter your name.");
                            String enterDevSurname = JOptionPane.showInputDialog("Please enter your surname.");
                            String taskDuration = JOptionPane.showInputDialog("How long will your task take? Enter the time in hours.");
                            String taskStatus = JOptionPane.showInputDialog("What is the status of this task? \n1) To Do \n2) Doing \n3) Done");


                            if (Objects.equals(taskStatus, "1")) {
                                taskStatus = "To Do";
                            } else if (Objects.equals(taskStatus, "2")) {
                                taskStatus = "Doing";
                            } else {
                                taskStatus = "Done";
                            }

                            String taskID = taskName.substring(0, 2) + ":" + t + ":" + enterDevName.substring(enterDevName.length() - 3);
                            taskID = taskID.toUpperCase();
                            i--;


                            String outputDetails = "Your task details:"
                                    + "\nTask Status: " + taskStatus
                                    + "\nDeveloper Deatils: " + enterDevName + " " + enterDevSurname
                                    + "\nTask Number: " + t
                                    + "\nTask Name: " + taskName
                                    + "\nTask Description: " + taskDesc
                                    + "\nTask ID: " + taskID
                                    + "\nTask Duration: " + taskDuration + "hours";
                            JOptionPane.showMessageDialog(null, outputDetails);

                        }

                    }

                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Coming soon!");
                    break;
                case 2:
                case -1:
                    System.out.println("Goodbye");
                    checkLogin = false;
                    break;
                default:
                    System.out.println("Unknown choice: " + choice);
                    break;
            }

        }
    }
}



