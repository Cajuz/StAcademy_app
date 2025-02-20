package br.com.etecia.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Login_Activity extends AppCompatActivity {

    //declarar as váriaveis globais
    MaterialButton btnRecuperarSenha, btnCadastrarSenha, btnEntrar;
    TextInputEditText txtSenha, txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //apresentando as variáveis do java para o xml
        btnRecuperarSenha = findViewById(R.id.btnRecuperarSenha);
        btnEntrar = findViewById(R.id.btnEntrar);
        txtEmail = findViewById(R.id.txtEmail);
        txtSenha = findViewById(R.id.txtSenha);

        //criando as ações dos botões
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password;

                email = txtEmail.getText().toString().trim();
                password = txtSenha.getText().toString().trim();

                if (email.equals("alvarolindo") && password.equals("alvarolindo")) {
                    startActivity(new Intent(getApplicationContext(),
                            MenuPrincipal_Activity.class));
                    finish();
                } else {
                    Toast.makeText(Login_Activity.this,  "Usuário ou senha inválidos", Toast.LENGTH_SHORT).show();
//

                }
            }
        });

        btnRecuperarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RecuperarSenha_Activity.class));
                finish();
            }
        });
    }
}