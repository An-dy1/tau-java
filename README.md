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