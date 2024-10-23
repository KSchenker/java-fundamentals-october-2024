public record Name(String firstName, String lastName) {
    @Override
    public String toString() {
        return "%s, %s".formatted(lastName, firstName);
    }
}
