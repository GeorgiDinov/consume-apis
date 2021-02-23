package com.georgidinov.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public final class TokenPersistenceManager {


    //== fields ==
    private static final Path tokenPath = FileSystems.getDefault().getPath("Token/token.txt");


    public static void writeToken(String token) {
        try (BufferedWriter writer = Files.newBufferedWriter(tokenPath)) {
            writer.write(token);
        } catch (IOException e) {
            System.out.println("Exception while writing token: " + e.getMessage());
        }
    }


    public static String readToken() {
        String token = "";
        try (BufferedReader reader = Files.newBufferedReader(tokenPath)) {
            token = reader.readLine();
        } catch (IOException e) {
            System.out.println("Exception while reading token: " + e.getMessage());
        }
        return token;
    }

}
