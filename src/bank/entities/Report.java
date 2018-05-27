package bank.entities;

public class Report {
    private final String text;

    public Report(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
