package com.thealeshka.labOne;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Thealeshka on 08.10.2019 inside the package - com.thealeshka.labOne
 */


public class LabOne {

    public static Map<String, Long> mapReduce(String... fileURLs) {
        return List.of(List.of(fileURLs).parallelStream().map(LabOne::readFile).reduce("", (s1, s2) -> s1 + " " + s2)
                .split(" ")).parallelStream().filter(s -> !s.equals(""))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }

    private static String readFile(String fileURL) {
        try {
            return Files.readAllLines(Path.of(fileURL)).parallelStream().reduce("", (s1, s2) -> s1 + " " + s2);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

