package com.example.moneymanager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 100;
    private GoogleSignInOptions gso;
    private GoogleSignInClient mGoogleSignInClient;
    SharedPreferences sharepreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // configure request for sign-in and build the request.
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestProfile()
                .requestIdToken("529122432788-s4mg646qqhrhtkv6jd98osrmjatpgp9k.apps.googleusercontent.com")
                .build();

        //google sign client where client is passing this for configure the request "gso".
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        SignInButton signInButton = findViewById(R.id.googleLogin);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        sharepreferences = getSharedPreferences("SHARED_PREF",MODE_PRIVATE);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                loginGoogle();
            }


        });

    }

    public void loginGoogle() {
        Intent signIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //matching the result code
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> task) {
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
            if (acct != null) {
                String personName = acct.getDisplayName();
                String personGivenName = acct.getGivenName();
                String personFamilyName = acct.getFamilyName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();
                Uri personPhoto = acct.getPhotoUrl();

                SharedPreferences.Editor editor=sharepreferences.edit();
                editor.putString("Name",personName);
                editor.putString("Email",personEmail);
                editor.putString("ID",personId);
                editor.apply();


                Toast.makeText(this, "User email:" + personEmail, Toast.LENGTH_SHORT).show();

                startActivity(new Intent(MainActivity.this, Dashboard.class));
                finish();
            }
//            account.getIdToken();
//            Log.e(account.getEmail(), account.getDisplayName());
//            Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show();

//            startActivity(new Intent(MainActivity.this, HomePage.class));
//            finish();
        } catch (ApiException e) {
            Log.e("Sign in Google", "signInResult:failed code" + e);
        }
    }




}