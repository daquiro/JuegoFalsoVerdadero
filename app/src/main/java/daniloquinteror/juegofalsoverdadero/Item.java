package daniloquinteror.juegofalsoverdadero;

/**
 * Created by daniloquinteror on 24/11/17.
 */

public class Item {

    private String question, answer;

    public Item(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
