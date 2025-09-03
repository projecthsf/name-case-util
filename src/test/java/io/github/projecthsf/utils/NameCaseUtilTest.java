package io.github.projecthsf.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NameCaseUtilTest {
    private final String[] INPUT_VALUES = {"your name", "  your   name  "};
    @ParameterizedTest
    @MethodSource("dataTestProvider")
    void toCamelCase(String input) {
        assertEquals("yourName012", NameCaseUtil.toCamelCase(input));
    }

    @ParameterizedTest
    @MethodSource("dataTestProvider")
    void toSnakeCase(String input) {
        assertEquals("your_name_012", NameCaseUtil.toSnakeCase(input));
    }

    @ParameterizedTest
    @MethodSource("dataTestProvider")
    void toKebabCase(String input) {
        assertEquals("your-name-012", NameCaseUtil.toKebabCase(input));
    }

    @ParameterizedTest
    @MethodSource("dataTestProvider")
    void toPascalCase(String input) {
        assertEquals("YourName012", NameCaseUtil.toPascalCase(input));
    }

    @ParameterizedTest
    @MethodSource("dataTestProvider")
    void toTitleCase(String input) {
        assertEquals("Your Name 012", NameCaseUtil.toTitleCase(input));
    }

    private static Stream<Arguments> dataTestProvider() {
        return Stream.of(
                Arguments.of("yourName012"),
                Arguments.of("your.name.012"),
                Arguments.of("your/name/012"),
                Arguments.of("YourName012"),
                Arguments.of("your-name-012"),
                Arguments.of("your_name_012"),
                Arguments.of("your name 012"),
                Arguments.of("your name 012"),
                Arguments.of("Your Name 012"),
                Arguments.of("your name 012"),
                Arguments.of("  your name 012"),
                Arguments.of("  Your   Name 012"),
                Arguments.of("  Your ;,!@#$%^&*()-=\\{}\":?><}  Name 012"),
                Arguments.of("  your   name 012")
        );
    }
}