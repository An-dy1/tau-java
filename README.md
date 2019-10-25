### Chapter 1 - set-up

1. To the pom.xml, need to add a properties value that tells compiler to compile our code using Java 13:
    ```xml
    <properties>
          <maven.compiler.target>1.13</maven.compiler.target>
          <maven.compiler.source>1.13</maven.compiler.source>
      </properties>
      ```
2. Then, set dependencies (for now, just Selenium Chromedriver dependency):
    ```xml
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-chrome-driver</artifactId>
        <version>3.141.59</version>
    </dependency>
    ```
3. Check that dependency is there by opening the maven sidebar in IntelliJ and opening the dependencies folder; hit the refresh icon to re-import

4. Add chromedriver executable to the project. Put in a 'resources' folder.

### Chapter 2 - Webdriver

- To ask: what's up with main vs test directory?
- Put tests inside a package
- Once you have your Test Class:
    1. Create a webdriver object
    2. Create a method
    3. Tell webdriver where it can find chromedriver (there are other ways to do this, yes?)
    4. Instantiate driver as a chrome driver; the one we're using is an interface, we're using it as a type
- To change browser window size

### Chapter 4.1

- Two layers of test automation projects: framework layer, test layer
- Under src folder there is main and test
- Main:
    - Where you put your framework
    - All interactions with web browser should be here
    - Finding and clicking on elements
- Test:
    - Where you typically put your test
    - Focus on the test itself
    - Checking whether something was successful
- Page object model design pattern:
    - Create a class in the framework that represents a page in your application
    - New class for new pages
    - Convention to have "page" in your class
    - In the page object, fields that represent elements on a page and methods to interact with them
    - Only create what you need at the time