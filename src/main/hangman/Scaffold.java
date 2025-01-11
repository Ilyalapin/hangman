package main.hangman;

public enum Scaffold {
    ZERO_POSITION("""
                     _______
                     |     |
                           |
                           |
                           |
                           |
            ----------------
            """),
    ONE("""
                     _______
                     |     |
                     O     |
                           |
                           |
                           |
            ----------------
            """),
    TWO("""
                     _______
                     |     |
                     O     |
                     |     |
                     |     |
                           |
            ----------------
            """),
    THREE("""
                     _______
                     |     |
                     O     |
                  ---|     |
                     |     |
                           |
            ----------------
            """),
    FOUR("""
                     _______
                     |     |
                     O     |
                  ---|---  |
                     |     |
                           |
            ----------------
            """),
    FIVE("""
                     _______
                     |     |
                     O     |
                  ---|---  |
                    _|     |
                   _|      |
            ----------------
            """),
    SIX("""
                     _______
                     |     |
                     O     |
                  ---|---  |
                    _|_    |
                   _| |_   |
            ----------------
            """);

    private final String value;

    Scaffold(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }


    public static String draw(int counterErrors) {

        return switch (counterErrors) {
            case 0 -> ZERO_POSITION.toString();
            case 1 -> ONE.toString();
            case 2 -> TWO.toString();
            case 3 -> THREE.toString();
            case 4 -> FOUR.toString();
            case 5 -> FIVE.toString();
            default -> throw new IllegalArgumentException("Invalid number of errors: " + counterErrors);
        };
    }
}
