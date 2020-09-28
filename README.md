# IP Project Duke

###### by TomLBZ

This is my IP project for *CS2113T*. It is a task management system based on the CLI interface. 
It is written in *Java*. Given below are instructions on how to use it.

## For Developers

#### Set up IntelliJ

Prerequisites: JDK 11, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project dialog first)
1. Set up the correct JDK version, as follows:
   1. Click `Configure` > `Structure for New Projects` and then `Project Settings` > `Project` > `Project SDK`
   1. If JDK 11 is listed in the drop down, select it. If it is not, click `New...` and select the directory where you installed JDK 11
   1. Click `OK`
1. Import the project into Intellij as follows:
   1. Click `Open or Import`.
   1. Select the project directory, and click `OK`
   1. If there are any further prompts, accept the defaults.
1. After the importing is complete, locate the `src/main/java/duke.Duke.java` file, right-click it, and choose `Run duke.Duke.main()`. If the setup is correct, you should see something like the below:
   ```
    ____________________________________________________________
        Hello, I'm Duke. What can I do for you?
    ____________________________________________________________
   ```
1. Now you are all set.

## For Users

#### Run the Program

Prerequisites: JRE 11

1. Install JRE if you haven't.
   1. In case you have multiple Java Runtime installed, please modify the PATH variable such that 
   the path for JRE 11 is ***in front of*** the path for other JREs.
1. Download the jar file from Github, go to `Release` and download the latest version.
1. Open a shell, such as _bashrc_, _cmd_, _gitbash_, etc.
1. Move the focus to the directory of the jar file.
1. Run the jar using 'java -jar tp.jar'.
1. Enjoy.

#### Useful Commands

* Type `help` to see the following screen:
   ```
    ____________________________________________________________
        Command: bye        Description: Quit the program
        Command: clear      Description: Clear the task list
        Command: deadline   Description: Add a deadline to the task list
        Command: delete     Description: Delete a task from the task list
        Command: done       Description: Mark a task as done
        Command: event      Description: Add an event to the task list
        Command: find       Description: Find an event in the task list with the specified keyword
        Command: help       Description: Print the list of available commands, or print the details of a specified command
        Command: list       Description: Print a list of all added tasks
        Command: todo       Description: Add a todo to the task list
        Command: undone     Description: Mark a task as undone
        Command: unknown    Description: Prints the error message for an unrecognized command
        Use "help [target]" to see details :) Try "help help"!
    ____________________________________________________________
   ```
* Type `help list` to see the detailed usages of the `list` command:
   ```
    ____________________________________________________________
        Name: list
        Description: Print a list of all added tasks
        Syntax:
        list
        list date [asc / desc / spec MMM dd yyyy]
        Usages:
        1. "list" >> list all added tasks
        2. "list date asc" >> list tasks with a "date" field in ascending order
        3. "list date spec Oct 5 2020" >> list tasks with specific "date" field of October 5 2020
    ____________________________________________________________

   ```
* Type `help deadline` to see the detailed usage of the `deadline` command:
   ```
    ____________________________________________________________
        Name: deadline
        Description: Add a deadline to the task list
        Syntax:
        deadline [description] /by [time]
        Usages:
        1. "deadline ddl /by 21/9/15 1:12" >> adds a deadline with description "ddl" and time "September 15 2021 1:12"
    ____________________________________________________________
   ```
* Feel free to explore other commands!
* If you found a bug, please raise an ***issue*** on Github.