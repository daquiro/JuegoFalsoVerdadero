package daniloquinteror.juegofalsoverdadero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    TextView tv_question;
    Button b_true, b_false;

    Questions mQuestions;
    int questionsLength;

    ArrayList<Item> questionsList;

    int currentQuestion = 0;
    boolean winner = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         // comienzo
        tv_question = (TextView)findViewById(R.id.tv_question);
        b_true = (Button)findViewById(R.id.b_true);
        b_false = (Button)findViewById(R.id.b_false);

        mQuestions = new Questions();
        questionsLength = mQuestions.mQuestions.length;

        questionsList = new ArrayList<>();


        // Guardar todas las preguntas en la lista
        for (int i = 0; i < questionsLength; i++){
            questionsList.add(new Item(mQuestions.getQuestion(i),mQuestions.getAnswer(i)));
        }

        //Barajar las preguntas
        Collections.shuffle(questionsList);

        //Comienzo del juego

       setQuestion(currentQuestion);

        b_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkQuestion(currentQuestion)){
                    // Correcto, el juego continua
                    currentQuestion++;
                    if (currentQuestion < questionsLength){
                        setQuestion(currentQuestion);
                    }else {
                        //fin del juego - ganador
                        winner = true;
                       endGame();
                    }
                }else {
                    //error - fin del juego
                 endGame();
                }

            }
        });

        b_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkQuestion(currentQuestion)){
                    // El juego continua
                    currentQuestion++;
                    if (currentQuestion < questionsLength){
                        setQuestion(currentQuestion);
                    }else {
                        //fin del juego - ganador
                        winner = true;
                     endGame();
                    }
                }else {
                    //error - fin del juego
                    endGame();
                }

            }
        });
    }
    //mostrar la pregunta en la pantalla
    private void setQuestion(int number){
        tv_question.setText(questionsList.get(number).getQuestion());

    }

    //Verificar que la respuesta sea correcta
    private boolean checkQuestion(int number){
        String answer = questionsList.get(number).getAnswer();
        return answer.equals("true");

    }



    //Fin del juego - Game over
     private void endGame(){
        if (winner){
            Toast.makeText(this, "Fin del Juego: Tu ganas", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Fin del Juego: Tu pierdes", Toast.LENGTH_SHORT).show();
            finish();
        }
     }

}
