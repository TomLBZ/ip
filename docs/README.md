# User Guide

## Features 

#### Addition and removal of tasks
The program allows user to add or delete tasks from the task list.<br>
The program also provides shortcuts such as the `clear` command to delete tasks quickly.

#### Mark tasks as done or undone
The program allows user to mark tasks as done (denoted by `[V]`) or undone (denoted by `[X]`).

#### List tasks and reorder them by their ***date*** field
The program allows user to list tasks in ascending order or descending order with respect to their ***date*** values.<br>
The program also allows the user to filter the task list and only display tasks within a specified date.

#### Deadlines, Events and ToDo's
The program allows user to create 3 different kinds of tasks, *deadlines*, *events* and *todos*.<br>
*deadline* and *event* consists of both *description* and *time*, while *todo* does not contain *time*.<br>
The *time* field consists of a *date* part (such as `Oct 13 1998`), and a *time* part (such as `00:00`).<br>

#### Fuzzy parsing
The program fuzzily parses user's inputs with respect to date and time.<br>
`"Oct 13 1998"`, `10/13/98`, `13-10-1998`, `13 Oct 98` and many more common date formats are all supported.<br>
`1:1:0`, `01:01:00`, `1:01`, `01:1` and many more common time formats are all supported.

#### Auto-save and auto-load
The program saves the tasks list automatically every time the list changes. <br>
When the program loads up, it looks for the last saved tasks list first and tries to load it.

#### Syntax reminder
The program can remind the user of the syntax of a command if the command is correct but wrong syntax is present.

## Usage (alphabetical order)

### `bye` - Quit the program

Typing `bye` results in the program saving the current task list to a local file named 
`./data/duke.txt`, and then quitting the program.

Example of usage: 

`bye`

Expected outcome:

   ```	
    ____________________________________________________________
        Bye. Hope to see you again soon!
    ____________________________________________________________
   ```

### `clear` - Clear the task list

Typing `clear` results in the program deleting all added tasks from the task list.

Example of usage: 

`clear`

Expected outcome:

   ```	
    ____________________________________________________________
        Nice! I've cleared everything in the list.
    ____________________________________________________________
   ```

### `deadline` - Add a deadline to the task list

Typing `deadline` allows the program to parse user's input and create a ***deadline*** object with 
specified *description* and *time*. It will be appended to the end of the task list.

Syntax: 

`deadline [description] /by [time]`

Example of usage:

`deadline ddl /by 21/9/15 1:12`

Expected outcome:

   ```	
    ____________________________________________________________
        Got it. I've added this task:
        [D][X] ddl (by: Sep 15 2021 01:12)
        Now you have 1 tasks in the list.
    ____________________________________________________________
   ```

### `delete` - Delete a task from the task list

Typing `delete` deletes the task with specified *index* from the current task list.<br>
Note: *index* can be an integer number or a letter (`A` or `a` corresponds to 1).

Syntax:

`delete [index]`

Example of usage: 

`delete 1`

Expected outcome:

   ```	
    ____________________________________________________________
        Noted. I've removed this task:
        [D][X] ddl (by: Sep 15 2021 01:12)
        Now you have 0 tasks in the list.
    ____________________________________________________________
   ```

### `done` - Mark a task as done

Typing `done` allows the user to mark the task at a specified *index* as **done**.<br>
Note: *index* can be an integer number or a letter (`A` or `a` corresponds to 1).

Syntax:

`done [index]`

Example of usage: 

`done 1`

Expected outcome:

   ```	
    ____________________________________________________________
        Nice! I've marked this task as done:
        [D][V] ddl (by: Sep 15 2021 01:12)
    ____________________________________________________________
   ```

### `event` - Add an event to the task list

Typing `event` allows the program to parse user's input and create an ***event*** object with 
specified *description* and *time*. It will be appended to the end of the task list.

Syntax:

`event [description] /at [time]`

Example of usage: 

`event midterm exam /at May 13 2020 8:00`

Expected outcome:

   ```	
    ____________________________________________________________
        Got it. I've added this task:
        [E][X] midterm exam (at: May 13 2020 08:00)
        Now you have 1 tasks in the list.
    ____________________________________________________________
   ```

### `find` - Find an event in the task list

Typing `find` commands the program to search through the task list and print all tasks with the
specified *keyword*. If there is no task with such a *keyword*, `[NOT FOUND]` will be printed instead.

Syntax:

`find [keyword]`

Example of usage: 

`find exam`

Expected outcome (found):

   ```	
    ____________________________________________________________
        Tasks with the specified keyword are:
        1.[D][X] math exam (by: Oct 15 2020 10:30)
        2.[D][X] CS exam (by: Oct 18 2020 15:00)
        3.[E][X] exam review session (at: Oct 01 2020 08:00)
    ____________________________________________________________
   ```

Expected outcome (not found):

   ```	
    ____________________________________________________________
        Tasks with the specified keyword are:
        [NOT FOUND]
    ____________________________________________________________
   ```

### `help` - Print help text of the commands

Typing `help` allows the user to either print a list of available commands, 
or print the details of a specified command.

Syntax:

`help` <br> `help [target]`

Example of usage: 

`help`

Expected outcome:

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
Example of usage: 

`help list`

Expected outcome:

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

### `list` - Print a list of added tasks

Typing `list` commands the program to print either all added tasks or tasks at a specified *date*.<br>
The user can also control how the tasks printed are ordered with respect to *date*:<br>

The `asc` parameter tells the program to list tasks in ascending order with respect to their *date* field.<br>
The `desc` parameter tells the program to list tasks in descending order with respect to their *date* field.<br>
The `spec` parameter tells the program to only list tasks with the specified value of the *date* field.<br>

Note: with each execution of the `list` command, the indices of all tasks will be 
dynamically changed to refer to the task in the current list with the current indices.<br>
In other words, indices of tasks are not tied to their sequence of creation, allowing the user
to use commands much more flexibly, especially with the `find` command or the reordering parameters.

Syntax:

`list` <br> `list date [asc / desc / spec "date"]`, where `"date"` can be in any common date format.

Example of usage: 

`list`

Expected outcome:

   ```	
    ____________________________________________________________
        Here is the list of tasks:
        1.[D][X] math exam (by: Oct 15 2020 10:30)
        2.[D][X] CS exam (by: Oct 18 2020 15:00)
        3.[E][X] exam review session (at: Oct 01 2020 08:00)
    ____________________________________________________________
   ```

Example of usage: 

`list date asc`

Expected outcome:

   ```	
    ____________________________________________________________
        Here is the list of tasks:
        1.[E][X] exam review session (at: Oct 01 2020 08:00)
        2.[D][X] math exam (by: Oct 15 2020 10:30)
        3.[D][X] CS exam (by: Oct 18 2020 15:00)
    ____________________________________________________________
   ```

Example of usage: 

`list date spec 10/15/20`

Expected outcome:

   ```	
    ____________________________________________________________
        Here is the list of tasks:
        1.[D][X] math exam (by: Oct 15 2020 10:30)
    ____________________________________________________________
   ```

### `todo` - Add a todo to the task list

Typing `todo` allows the program to parse user's input and create a ***todo*** object with 
specified *description*. It will be appended to the end of the task list.

Syntax:

`todo [description]`

Example of usage: 

`todo class`

Expected outcome:

   ```	
    ____________________________________________________________
        Got it. I've added this task:
        [T][X] class
        Now you have 1 tasks in the list.
    ____________________________________________________________
   ```

### `undone` - Mark a task as undone

Typing `undone` allows the user to mark the task at a specified *index* as **undone**.<br>
Note: *index* can be an integer number or a letter (`A` or `a` corresponds to 1).

Syntax:

`undone [index]`

Example of usage: 

`undone 1`

Expected outcome:

   ```	
    ____________________________________________________________
        Nice! I've marked this task as undone:
        [D][X] math exam (by: Oct 15 2020 10:30)
    ____________________________________________________________
   ```

### `unknown` - Prints error message

Typing `unknown` or any string that is not a command will trigger the `unknown` command.<br>
The `unknown` command prints an error message for debug purposes, it is also the default behaviour of the program
when it fails to recognize the user's command. <br>

Note: If the program recognizes the command successfully, yet fails to find required parameters, 
it will not trigger this `unknown` command. It will print a syntax error and remind the user of
the correct syntax instead.

Syntax:

`unknown` <br> `[anything that is not a command]`

Example of usage: 

`who is duke?`

Expected outcome:

   ```	
    ____________________________________________________________
        OOPS, I don't know what that means :-( Try "help"!
    ____________________________________________________________
   ```

### Syntax reminder

Typing a correct command with wrong syntax will trigger the syntax reminder.

Example of usage:

`deadline /at 10-10-10`<br>

Note that the command `deadline` is a correct command, but:<br>
1. Description is missing
1. Parameter name is wrong

Expected outcome:

   ```	
    ____________________________________________________________
        Invalid Command! Please check the syntax.
        deadline [description] /by [time]
    ____________________________________________________________
   ```
