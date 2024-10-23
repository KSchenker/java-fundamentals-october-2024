import java.time.LocalDateTime;
import java.util.Comparator;

public record LogEntry(LocalDateTime timestamp, String message, String origin) implements Comparable<LogEntry> {

    public static final Comparator<LogEntry> ORIGIN_ORDER = new OriginOrder();


    @Override
    public int compareTo(LogEntry other) {
        return this.timestamp.compareTo(other.timestamp);
    }

    private static class OriginOrder implements Comparator<LogEntry> {
        @Override
        public int compare(LogEntry first, LogEntry second) {
            return first.origin.compareToIgnoreCase(second.origin);
        }
    }

}
