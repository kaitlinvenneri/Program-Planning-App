README
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

**Open-Close Principle Analysis**

I implemented the Open-Closed Principle in the way that I created a MenuOption interface, which multiple MenuOptions implement (AdminMenuOption, QuitMenuOption, UploadCoursesMenuOption, UploadTranscriptMenuOption, UserMenuOption). The Open-Closed Principle has been demonstrated here in that the MenuOption interface contains the methods required for controlling MenuOptions, but how the methods are implemented are up to the MenuOptions that implement this interface. This allows for structure in requiring anything that implements the interface to include necessary functionality, but there is flexibility in how the MenuOptions choose to do so.

**How to Build & Run My App**

From Inside of the project Folder:

*  delete build.gradle - or rename to anything that isn't build.gradle
*  rename buildForMarking.gradle to build.gradle
*  enter command into command line: gradle wrapper
*  enter command into command line: ./gradlew build
*  enter command into command line: ./gradlew run --console=plain
