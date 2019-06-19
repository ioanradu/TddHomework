public class NegativeNumberException extends Exception {
    private String message;

    public NegativeNumberException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "NegativeNumberException{" +
                "message='" + message + '\'' +
                '}';
    }
}
