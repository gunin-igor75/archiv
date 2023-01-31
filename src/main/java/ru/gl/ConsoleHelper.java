package ru.gl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    private static Logger LOG = LoggerFactory.getLogger(ConsoleHelper.class);

    // Вывод в консоль сообщения
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    // Считывание с консоли строки
    public static String readString() {
        String line = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            line = reader.readLine();
        } catch (IOException ex) {
            LOG.error("Input error  {}", ex.getMessage());
            ex.printStackTrace(System.out);
        }
        return line;
    }

    // Считывание с консоли целого числа
    public static int readInt() {
        int number = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            number = Integer.parseInt(reader.readLine());
        } catch (IOException ex) {
            LOG.error("Input error  {}", ex.getMessage());
            ex.printStackTrace(System.out);
        } catch (NumberFormatException ex) {
            LOG.error("Not an integer entered");
            ex.printStackTrace(System.out);
        }
        return number;
    }
}
