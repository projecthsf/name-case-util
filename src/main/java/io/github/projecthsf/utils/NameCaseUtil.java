package io.github.projecthsf.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NameCaseUtil {
    private final static Set<Character> spaceChars = new HashSet<>(Arrays.asList(' ', '-', '_', '.', '/', '\\'));
    public static String toCamelCase(String str) {
        String identifier = getNameCase(str, false, true);
        return identifier.replace(" ", "");
    }

    public static String toSnakeCase(String str) {
        String identifier = getNameCase(str, false, false);
        return identifier.replace(" ", "_");
    }

    public static String toKebabCase(String str) {
        String identifier = getNameCase(str, false, false);
        return identifier.replace(" ", "-");
    }

    public static String toPascalCase(String str) {
        String identifier = getNameCase(str, true, true);
        return identifier.replace(" ", "");
    }

    public static String toTitleCase(String str) {
        String identifier = getNameCase(str, true, true);
        return identifier;
    }


    private static String getNameCase(String str, boolean upperCaseFirstLetter, boolean upperCaseFirstWordLetter) {
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                if (result.length() == 0) {
                    result.append(upperCaseFirstLetter ? Character.toUpperCase(c) : Character.toLowerCase(c));
                    continue;
                }

                if(Character.isUpperCase(c)) {
                    if (!checkLastCharIsSpaceOrDigit(result)) {
                        result.append(" ");
                    }
                    result.append(upperCaseFirstWordLetter ? c : Character.toLowerCase(c));
                    continue;
                }

                result.append(checkLastCharIsSpace(result) && upperCaseFirstWordLetter ? Character.toUpperCase(c): c);
                continue;
            }

            if (Character.isDigit(c)) {
                result.append(checkLastCharIsSpaceOrDigit(result) ? c: " " + c);
                continue;
            }

            if (result.length() == 0) {
                continue;
            }


            if (checkLastCharIsSpace(result)) {
                continue;
            }

            if (spaceChars.contains(c)) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    private static boolean checkLastCharIsSpace(StringBuilder result) {
        char lastChar = result.charAt(result.length() - 1);
        return spaceChars.contains(lastChar);
    }

    private static boolean checkLastCharIsSpaceOrDigit(StringBuilder result) {
        char lastChar = result.charAt(result.length() - 1);
        return spaceChars.contains(lastChar) || Character.isDigit(lastChar);
    }
}
