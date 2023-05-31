package com.popov.utils;

import lombok.SneakyThrows;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class UserInputUtil {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    @SneakyThrows
    public static int getUserAction(final List<String> values) {
        int userInput;
        do {
            System.out.println("What you want to do?");
            for (int i = 0; i < values.size(); i++) {
                System.out.printf("%d. %s%n", i, values.get(i));
            }
            final String line = READER.readLine();
            if (NumberUtils.isCreatable(line)) {
                userInput = Integer.parseInt(line);
            } else {
                userInput = -1;
            }
        } while (userInput < 0 || userInput >= values.size());
        return userInput;
    }
}
