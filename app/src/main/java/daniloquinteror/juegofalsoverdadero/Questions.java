package daniloquinteror.juegofalsoverdadero;

/**
 * Created by daniloquinteror on 24/11/17.
 */

public class Questions {

    public String mQuestions[] = {
            "Mercurio es el primer planeta del Sistema Solar",
            "Venus es el tercer planeta del Sistema Solar",
            "La Tierra es el cuarto planeta del Sistema Solar",
            "Marte es el primer planeta del Sistema Solar",
            "Jupiter es el séptimo planeta del Sistema Solar",
            "Saturno es el quinto planeta del Sistema Solar",
            "Urano es el séptimo planeta del Sistema Solar",
            "Neptuno es el octavo planeta del Sistema Solar",


    };

    public String mAnswers[] = {
            "true",
            "false",
            "False",
            "False",
            "False",
            "False",
            "true",
            "true"

    };

    public String getQuestion (int number){
        return mQuestions [number];
    }

    public String getAnswer (int number){
        return mAnswers [number];
    }
}
