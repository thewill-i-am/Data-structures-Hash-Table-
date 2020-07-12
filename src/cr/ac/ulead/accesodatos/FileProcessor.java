package cr.ac.ulead.accesodatos;

import cr.ac.ulead.modelos.Lista;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class FileProcessor {
    protected String fileName;

    public FileProcessor(String fileName) {
        this.fileName = fileName;
    }

    public Lista processFile() throws FileNotFoundException {
        Scanner reader = openFile();
        Lista result = readLines(reader);
        reader.close();
        return result;
    }

    protected Scanner openFile() throws FileNotFoundException {
        return new Scanner(new File(fileName));
    }

    protected abstract Lista readLines(Scanner reader);
}
