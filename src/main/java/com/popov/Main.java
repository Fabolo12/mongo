package com.popov;

import com.popov.action.Action;
import com.popov.utils.UserInputUtil;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {


    @SneakyThrows
    public static void main(String[] args) {
        final Action[] values = Action.values();

        final List<String> collect = Arrays.stream(values)
                .map(Objects::toString)
                .collect(Collectors.toList());

        while (true) {
            final int userInput = UserInputUtil.getUserAction(collect);
            values[userInput].getActionType().doAction();
        }

    }
}
