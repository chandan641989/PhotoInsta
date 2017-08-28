package com.kartnap.chandan.photoinsta.Login;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.kartnap.chandan.photoinsta.R;
import com.kartnap.chandan.photoinsta.Utills.FirebaseMethods;

/**
 * Created by Chandan on 7/8/2017.
 */

public class RegisterActivity extends AppCompatActivity{
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Context mContext = RegisterActivity.this;
    private String email,password,name;
    private EditText mEmail,mName,mPassword;
    private Button signup;
    private ProgressBar progressBar;
    FirebaseMethods firebaseMethods;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mContext = RegisterActivity.this;
        firebaseMethods = new FirebaseMethods(mContext);

        initWidgets();
        setupFirebaseAuth();
        init();
    }
    private void init(){
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = mEmail.getText().toString();
                password = mPassword.getText().toString();
                name = mName.getText().toString();
                if(checkInput(email,password,name)){
                    progressBar.setVisibility(View.VISIBLE);
                    firebaseMethods.registerNewEmail(email,password,name);
                }
            }
        });

    }
    private boolean checkInput(String email,String password,String name){
        if(email.equals("") || password.equals("") || name.equals("")){
            Toast.makeText(mContext,"All fields must be filled",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
    private void initWidgets(){
        progressBar = (ProgressBar)findViewById(R.id.register_prograssbar);
        mEmail = (EditText)findViewById(R.id.input_email);
        mName = (EditText)findViewById(R.id.input_name);
        mPassword = (EditText)findViewById(R.id.input_passowrd);
        signup = (Button)findViewById(R.id.btn_register);

        progressBar.setVisibility(View.GONE);

    }
    private boolean isStringNull(String string){
        if(string == "")
            return true;

        return false;
    }
    private void setupFirebaseAuth(){
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    // Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    // Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
