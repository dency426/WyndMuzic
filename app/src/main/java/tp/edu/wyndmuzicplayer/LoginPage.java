package tp.edu.wyndmuzicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class LoginPage extends AppCompatActivity {

    Timer counting;

    private EditText Email;
    private EditText Password;
    private TextView Attempts;
    private Button Login;
    private int Counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Email = (EditText)findViewById(R.id.Name);
        Password =(EditText)findViewById(R.id.Password);
        Attempts =(TextView) findViewById(R.id.Attempts);
        Login =(Button)findViewById(R.id.loginbtn);

        counting = new Timer();
        counting.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(LoginPage.this, HomePage.class);
                startActivity(intent);
                LoginPage.this.finish();
            }
        }, 3000);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Email.getText().toString(), Password.getText().toString());
            }
        });
    }
    private void validate(String email, String password ){
        if((email == "WyndMusic") && (password == "5678")){
            Intent intent = new Intent(LoginPage.this, HomePage.class);
            startActivity(intent);
        }else{
            Counter--;
            if(Counter == 0){
                Login.setEnabled((false));
            }
        }
    }

    public void validate1(View view) {

    }
}
