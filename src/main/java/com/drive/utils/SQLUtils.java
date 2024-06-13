package com.drive.utils;


public class SQLUtils {

    public static String preparedStatement(String statement, Object... args) {
        StringBuilder sb = new StringBuilder(statement);

        int index = 0;
        for (Object arg : args) {
            index = sb.indexOf("?", index);
            if (index == -1) {
                break;
            }
            sb.replace(index, index + 1, "'" + arg.toString() + "'");
            index += arg.toString().length() + 2; // Move index past the inserted value
        }

        return sb.toString();
    }
}
