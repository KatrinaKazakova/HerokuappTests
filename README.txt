#Installation

1. Download and Install JDK 13.0.2

------------------------------------------------------------------------------------------------------------------------
##WINDOWS##
2. In you system variables create JAVA variable that points to your jdk folder in Program Files
(ex. C:\Program Files\Java\jdk-13.0.2)

3. In your `Path` system variable point to `\bin` in your jdk folder in Program Files
ex.(C:\Program Files\Java\jdk-13.0.2\bin)

4. Download and install Maven Apache 3.6.3 from `https://maven.apache.org/docs/3.6.3/release-notes.html`

5. In your system variables create MAVEN variable that points to your newly installed Maven Apache
ex.(C:\Program Files\Maven\apache-maven-3.6.3)

6. In your `Path` system variable point to `\bin` in your maven folder
ex.(C:\Program Files\Maven\apache-maven-3.6.3\bin)

------------------------------------------------------------------------------------------------------------------------
##MAC##
2. In your .bash_profile create JAVA variable that points your jdk folder
ex.(export JAVA_HOME=$(/usr/libexec/java_home)

3. In your .bash_profile export the `PATH` to your Maven bin folder
ex.(export PATH=$PATH:/User/username/Documents/Maven/apache-maven-3.6.3/bin)

------------------------------------------------------------------------------------------------------------------------
7. Download and install Community version for IntelliJ from `https://www.jetbrains.com/idea/download`

8. After opening the project go to File -> Project Structure -> Project Settings -> Project
*change Project language level to `13`

9. Go to File -> Project Structure -> Project Settings -> Modules -> Sources
*change Language level to `13`

________________________________________________________________________________________________________________________

#Execution

There are 2 ways to run a whole suite of tests:
   a. Right click on testng.xml > Run
   b. From command prompt: Go to project's directory where pom.xml file exists. Run 'mvn clean' command. Run 'mvn test'
   command.

Test results:
   a. In test-output/ExtentReport.html - open it in your browser.
   b. In console.
   c. In command prompt after running tests using 'mvn test' maven command.