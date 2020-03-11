README
========

**How to Build & Run My App**

From Inside of the project Folder:

*  delete build.gradle - or rename to anything that isn't build.gradle
*  rename buildForMarking.gradle to build.gradle
*  enter command into command line: gradle build
*  enter command into command line: gradle run

### Milestone 2

**User Stories & Acceptance Criteria**

1) As an administrator, I want to upload a file containing the required courses for a program, so that this information can be used for program planning purposes.

*Acceptance Criteria:*

Given that I have selected to upload a file containing program course requirements, 
When I provide the correct name of a file containing properly formatted program course requirements, 
Then the program course requirements are stored within the application.

Given that I have selected to upload a file containing program course requirements, 
When I provide the name of a file that does not exist, 
Then I am prompted to re-enter the name of a file containing program course requirements.

Given that I have selected to upload a file containing program course requirements, 
When I provide the name of a file that contains incorrectly formatted program course requirements, 
Then I am prompted to re-enter the filename of a valid file containing program course requirements.

2) As a user, I want to select my program, so that I can analyze my transcript against my progam of study.

*Acceptance Criteria:*

Given that I have uploaded a valid transcript, 
When I am provided with program options, 
Then I am able to select my program of study.

3) As a user, I want to analyze my transcript against my program of study, so that I can find out which required courses I have completed and which required courses I still need.

*Acceptance Criteria:*

Given that I have uploaded a valid transcript and selected my program, 
When I choose to find out which required courses I have completed, 
Then a summary indicating courses completed toward my program is provided to me.

**Liskov Substitution Principle Analysis**

One good example of where I used the Liskov Substitution Principle is with regards to the Course class.
There are two types that inherit Course: AdminCourse, and CourseAttempt.
Both of these types increase the behaviour of Course, but the base type still holds and is not violated in any way.
Anywhere where the base class Course is used could use an AdminCourse or CourseAttempt and be functionally the same.

**Interface Segregation Analysis**

I used interface segregation with regards to my MenuOption interface.
While there are many methods in this interface, every one of them is used by the classes that implement the MenuOption interface and are necessary.
For this reason, interface segregation holds well here.

**A Comment About Unit Test Coverage**

While it is hard to eyeball the amount of unit test coverage that I have at the present in my project, I do think I have a good start of unit tests.
Other than Classes that implement the MenuOption interface, and some Utility type classes, pretty well all other classes are unit tested to a high degree.
I intend to improve upon this unit test coverage and add more testing.
That being said, much of the functionality used in creating and calling other classes from the classes that implement MenuOption 
is tested indirectly via the unit tests I have created thus far.

**How I Improved Based on Milestone 1 Feedback**

The two pieces of feedback I received pertained to my menu navigation and my FileParser classes.

In Milestone 1, there were several cases in which my program would exit at unexpected times.
I have since revised this functionality so that a user must quit to exit the program.

The feedback I received around file parsing is that my CourseFileParser and TranscriptFileParser should inherit from a base FileParser class.
After some consideration, and the addition of a new type of file parser for Milestone 2, I have found that my file parsing is quite different for each type of parsing.
Based on this, I found it hard to inherit from a base class.
Instead, I feel that the solution to this problem is to use dependency injection.
Since I am just familiarizing myself with this concept (and we are not required to implement this type of functionality for Milestone 2), I intend to make this change
for Milestone 3.

**Data Schema**

A pdf containing my data schema can be found in the root directory of this project.

**Data Synthesis Method**

To synthesize data used by my application, my data synthesis tool can be used.
This tool exists in the following repository:
https://gitlab.socs.uoguelph.ca/vennerik/data-synthesis-tool-for-program-planning-app

========

### Milestone 1

**User Stories & Acceptance Criteria**

1) As a user, I want to upload a file containing my transcript, so that I can use the program planning application to plan my academics.

*Acceptance Criteria:*

Given that I have selected to upload a transcript, 
When I provide the correct name of a file containing a properly formatted transcript, 
Then my transcript is stored within the application.

Given that I have selected to upload a transcript, 
When I provide the name of a file that does not exist, 
Then I am prompted to re-enter the filename of a transcript.

Given that I have selected to upload a transcript, 
When I provide the name of a file that contains an incorrectly formatted transcript, 
Then I am prompted to re-enter the filename of a valid transcript.

2) As a user, I want to generate a summary of my transcript, so that I can view the breakdown of the courses on my transcript.

*Acceptance Criteria:*

Given that I have uploaded a valid transcript, 
When I choose to generate a summary of my transcript, 
Then a summary indicating courses completed, planned, and in progress is provided to me.

Given that I have not uploaded a valid transcript, 
When I use the application as a user, 
Then I am not given the option to generate a summary of my transcript.

3) As an administrator, I want to upload a file containing course information, so that this information can be used for program planning purposes. 

*Acceptance Criteria:*

Given that I have selected to upload a file containing course information, 
When I provide the correct name of a file containing properly formatted course information, 
Then the course information is stored within the application.

Given that I have selected to upload a file containing course information, 
When I provide the name of a file that does not exist, 
Then I am prompted to re-enter the name of a file containing course information.

Given that I have selected to upload a file containing course information, 
When I provide the name of a file that contains incorrectly formatted course information, 
Then I am prompted to re-enter the filename of a valid file containing course information.

**Single Responsibility Principle Analysis**

I feel that the Single Responsibility Principle has been well implemented in the following classes/files:

*  AdminCourse – responsible for administrative course information handling
*  Course – responsible for general course handling
*  CourseAttempt – responsible for user course attempt handling
*  CourseFileParser – responsible for parsing course files
*  InputHandler – responsible for handling user input
*  Menu – responsible for handling a menu
*  Program – responsible for handling a program
*  QuitMenuOption – responsible for handling quitting the program
*  Status – an enum containing a Status of Course Attempts
*  TranscriptFileParser - responsible for parsing transcript files

The reason for this is that these classes have a single responsibility each, as mentioned next to them. In making modifications with relation to the classes mentioned above, there should be a limited impact on other classes because of the way that they have been implemented to fulfill a single functionality. 

Some classes that I would like to improve on with regards to the Single Responsibility Principle would be:

*  PlanningApp
*  Any class that implements MenuOption

The reason that these currently require improvement is because I am still deciding on how to handle the flow of the program. Because of this, MenuOptions currently may be responsible for more than one responsibility, including controlling the flow of the program. I would like to make this better. PlanningApp also suffers from this issue as this is the class that sets up the application initially and begins the menu creation and flow for both user types.

**Open-Closed Principle Analysis**

I implemented the Open-Closed Principle in the way that I created a MenuOption interface, which multiple MenuOptions implement (AdminMenuOption, QuitMenuOption, UploadCoursesMenuOption, UploadTranscriptMenuOption, UserMenuOption). The Open-Closed Principle has been demonstrated here in that the MenuOption interface contains the methods required for controlling MenuOptions, but how the methods are implemented are up to the MenuOptions that implement this interface. This allows for structure in requiring anything that implements the interface to include necessary functionality, but there is flexibility in how the MenuOptions choose to do so.
