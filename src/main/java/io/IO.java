package io;

import java.io.IOException;
import java.io.File;

public class IO {

    protected String path;
    protected String fileName;

    public IO(String path, String fileName) {
        this.path = path;
        this.fileName = fileName;
    }

    protected boolean validateFile()
            throws IOException{
        boolean output = true;
        File path = new File(this.path);
        if (!path.exists() || !path.isDirectory()) {
            output = output && path.mkdirs();
        }
        File file = new File(this.path + "/" + this.fileName);
        if (!file.exists() || !file.isFile()) {
            output = output && file.createNewFile();
        }
        return output;
    }

}
