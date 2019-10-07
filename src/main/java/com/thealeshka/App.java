package com.thealeshka;

import com.thealeshka.labOne.LabOne;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Map;

/**
 * Created by Thealeshka on 08.10.2019 inside the package - com.thealeshka
 */


public class App {
    public static void main(String[] args) throws IOException {
        Files.write(Path.of("Res.txt"), () -> LabOne.mapReduce("file1.txt", "file2.txt").entrySet()
                .parallelStream().sorted(Comparator.comparing(Map.Entry::getKey)).<CharSequence>map(n -> n.getKey() + "=" + n.getValue()).iterator());
    }
}
