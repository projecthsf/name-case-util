Name Case Util
====
This utility provides functions to convert strings between various common naming conventions, such as:
  - camel case (i.e: yourName)
  - snake case (i.e: your_name)
  - Pascal case (i.e: YourName)
  - kebab case (i.e: your-name)
  - title case (i.e: Your Name)


## Dependency:
#### Maven
```xml
<dependency>
  <groupId>io.github.projecthsf</groupId>
  <artifactId>name-case-util</artifactId>
  <version>1.0.0</version>
</dependency>
```

#### Gradle
```gradle
implementation 'io.github.projecthsf:name-case-util:1.0.0'
```

## Usage:
```java
import io.github.projecthsf.utils.NameCaseUtil;

System.out.println(NameCaseUtil.toCamelCase("your name")); // output: yourName
System.out.println(NameCaseUtil.toSnakeCase("your name")); // output: your_name
System.out.println(NameCaseUtil.toPascalCase("your name")); // output: YourName
System.out.println(NameCaseUtil.toKebabCase("your name")); // output: your-name
System.out.println(NameCaseUtil.toTitleCase("your name")); // output: Your Name
```
