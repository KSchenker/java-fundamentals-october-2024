package de.iad.test;

import de.iad.logging.LogEntry;

import java.time.LocalDateTime;

public class LogEntryDemo {

    public static void main(String[] args) {
        var timestamp = LocalDateTime.of(2024, 9, 30, 23, 15);
        var entry = new LogEntry(timestamp, "Speicher voll", "Dateisystem");
        System.out.println(entry);
        System.out.println(entry.getAgeInDays());

    }
}
