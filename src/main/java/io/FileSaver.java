package io;

import jobs.Task;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * The type File saver.
 */
public class FileSaver extends IO{

    /**
     * Instantiates a new File saver.
     *
     * @param path     the path
     * @param fileName the file name
     */
    public FileSaver(String path, String fileName) {
        super(path, fileName);
    }

    /**
     * Save boolean.
     *
     * @param tasks the tasks
     * @return the boolean
     */
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

    /**
     * Save boolean.
     *
     * @param string the string
     * @return the boolean
     */
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
