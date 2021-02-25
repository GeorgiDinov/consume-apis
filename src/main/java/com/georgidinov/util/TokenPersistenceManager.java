package com.georgidinov.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;

import static com.georgidinov.util.ApplicationConstants.TOKEN_PATH;

public final class TokenPersistenceManager {


    public static void writeToken(String token) {
        try (BufferedWriter writer = Files.newBufferedWriter(TOKEN_PATH)) {
            writer.write(token);
        } catch (IOException e) {
            System.out.println("Exception while writing token: " + e.getMessage());
        }
    }

    public static String readToken() {
        String token = "";
        try (BufferedReader reader = Files.newBufferedReader(TOKEN_PATH)) {
            token = reader.readLine();
        } catch (IOException e) {
            System.out.println("Exception while reading token: " + e.getMessage());
        }
        return token;
    }

}
