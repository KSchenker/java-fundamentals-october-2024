package de.iad.logging;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public record LogEntry(LocalDateTime timestamp, String message, String origin) {

    public LogEntry {
        Objects.requireNonNull(timestamp);
        Objects.requireNonNull(message);
        Objects.requireNonNull(origin);

        // Eine als var deklarierte Variable erhält vom Compiler den passenden Datentyp, sofern er aus
        // dem Ausdruck auf der rechten Seite der Zuweisung eindeutig herleitbar ist.
        var now = LocalDateTime.now();
        if (now.isBefore(timestamp) || message.isBlank() || origin.isBlank()) {
            throw new IllegalArgumentException("Zeitstempel darf nicht in Zukunft liegen. Meldung und Herkunft dürfen nicht leer sein");
        }
    }

    public long getAgeInDays() {
        return ChronoUnit.DAYS.between(this.timestamp, LocalDateTime.now());
    }

}
