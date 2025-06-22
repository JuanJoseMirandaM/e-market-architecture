public record Email(String value) {
    private static final Pattern REGEX =
        Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public Email {
        if (!REGEX.matcher(value).matches()) {
            throw new IllegalArgumentException("Invalid e-mail format");
        }
    }
}