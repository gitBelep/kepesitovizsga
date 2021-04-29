package hu.nive.ujratervezes.kepesitovizsga.phonebook;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class Phonebook {

    public void exportPhonebook(Map<String, String> contacts, String output) {
        checkParameters(contacts, output);
        Path path = Path.of(output);
        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
            writeLines(bw, contacts);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    private void writeLines(BufferedWriter bw, Map<String, String> contacts) throws IOException {
        boolean moreEntry = false;
        for (Map.Entry<String, String> e : contacts.entrySet()) {
            if (moreEntry) {
                bw.newLine();
            }
            String line = String.format("%s: %s", e.getKey(), e.getValue());
            bw.write(line);
            moreEntry = true;
        }
    }

    private void checkParameters(Map<String, String> contacts, String output) {
        if (contacts == null) {
            throw new IllegalArgumentException("Contacts is null");
        }
        if (output == null) {
            throw new IllegalArgumentException("Path parameter is null");
        }
    }

}
