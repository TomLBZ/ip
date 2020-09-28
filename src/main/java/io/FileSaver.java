package io;

import jobs.Task;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileSaver extends IO {

    public FileSaver(String path, String fileName) {
        super(path, fileName);
    }

    public boolean save(ArrayList<Task> tasks) {
        try {
            StringBuilder strBuilder = new StringBuilder();
            for (Task task : tasks) {
                strBuilder.append(task.toString()).append(System.lineSeparator());
            }
            if (isFileInvalid()) {
                throw new IOException();
            }
            Files.writeString(
                    Paths.get(path + "/" + fileName),
                    strBuilder.toString(), StandardCharsets.UTF_8);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean save(String string) {
        try {
            Files.writeString(Paths.get(path + "/" + fileName),
                    string, StandardCharsets.UTF_8);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
