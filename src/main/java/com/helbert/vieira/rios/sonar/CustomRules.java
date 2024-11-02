package com.helbert.vieira.rios.sonar;

import com.helbert.vieira.rios.sonar.rules.AvoidOldDateApi;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.sonar.plugins.java.api.JavaCheck;

public class CustomRules {

    public static final String REPOSITORY_KEY = "project-key-sonar-custom-rules-java-plugin";

    private CustomRules() {
    }

    public static Class<?>[] checkClassesAllArray() {
        return checkClassesAll().toArray(new Class<?>[0]);
    }

    public static List<Class<?>> checkClassesAll() {
        return Stream.concat(
                checkClasses().stream().map(clazz -> (Class<?>) clazz),
                testCheckClasses().stream().map(clazz -> (Class<?>) clazz)
        ).toList();
    }

    public static List<Class<? extends JavaCheck>> checkClasses() {
        return List.of(AvoidOldDateApi.class);
    }

    public static List<Class<? extends JavaCheck>> testCheckClasses() {
        return Collections.emptyList();
    }

}
