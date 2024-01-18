

# Features

- task
	- can check tasks for today
	- can view previous tasks
	- can view monthly summary
	- can view past monthly summaries
	- can share results with WhatsApp
- sync
	- can sync with google doc
	- can push notifications to others
- management
	- can create task list
	- can export/import task list
	- can share task list


# Functions

- [F01] show tasks in a list
- [F02] load tasks from a text file

# Issues
- [I001] checkable listview items
- [I002] debug app/apk on phone securely

# Design

## Navigation Views

- Score
- Tasks
- Settings

## Objects

TimeTasks (TaskGroup)	- "Morning Checklist"
	time-start/end		- 5 AM - 10 PM
	time-strict			- false
	hasMany: Task
		description		- "Hand holding in cars"
		remarks			- "All the time"

```checklists.yaml
id: 1
published_date: 18/01/2024
name: Kids checklists
version: 0.0.1
checklists:
  - name: Wake-Up Tasks
    id: 1-wake-up
	time-start: 05:00:00
	time-end: 10:00:00
    tasks:
      - name: Prepare your own snacks
      - name: Get ready at doorway by 7:15 AM
  - name: School Commuting Tasks
    id: 2-school-commuting
	time-start: 07:00:00
	time-end: 09:00:00
    tasks:
      - name: 
  - name: After-School Tasks
    id: 3-after-school
	time-start: 15:00:00
	time-end: 19:00:00
    tasks:
      - name: Fold dried clothes
	  - name: One plus exercise
	    remarks: To ensure we are healthy everyday
  - name: Bedtime Routines
    id: 4-bedtime
	time-start: 19:00:00
	time-end: 22:00:00
    tasks:
      - name: Clean up toys


```


## Sequences

settings > checlist editor, create and edit above yaml file
tasks ListView
	- onItemClick -> message box: Are you sure? OK/No -> Yes: check
	- onItemLongClick -> show details with confirmation button: I did it! -> check and show toast


# Tutorials

- https://guides.codepath.com/android/Basic-Todo-App-Tutorial = https://github.com/codepath/android_guides/wiki/Basic-Todo-App-Tutorial
	1. create layouts: ListView, EditText, Button; 2. add ListView into MainActivity; 3. write add item button; 4. long click to remove item; 5. reading and writing to file

- https://hub.packtpub.com/how-to-develop-a-simple-to-do-list-app-tutorial/
- https://steemit.com/utopian-io/@ideba/creating-a-todolist-android-application-with-android-achitecture-components-part-1
- https://www.codercrunch.com/post/47915445/build-a-todo-app-in-android

- https://data-flair.training/blogs/develop-android-to-do-list-app-project/
- https://www.sitepoint.com/starting-android-development-creating-todo-app/


- https://reintech.io/blog/implementing-todo-list-app-android-notifications-reminders

- https://medium.com/swlh/simple-settings-library-build-a-settings-screen-in-seconds-5b6394fbd2fc, https://github.com/marcauberer/simple-settings

