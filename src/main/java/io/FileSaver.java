package io;
import jobs.Task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileSaver extends IO{

    public FileSaver(String path, String fileName) {
        super(path, fileName);
    }

    public boolean save(ArrayList<Task> tasks) {
        try {
            StringBuilder strBuilder = new StringBuilder();
            for (Task task: tasks) {
                strBuilder.append(task.toString()).append("\r\n");
            }
            if (isFileInvalid()) {
                throw new IOException();
            }
            Files.writeString(
                    Paths.get(path + "/" + fileName),
                    strBuilder.toString());
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
