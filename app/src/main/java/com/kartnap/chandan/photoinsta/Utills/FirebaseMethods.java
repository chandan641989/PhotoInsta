package com.kartnap.chandan.photoinsta.Utills;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.kartnap.chandan.photoinsta.R;

import static android.content.ContentValues.TAG;

/**
 * Created by Chandan on 7/8/2017.
 */

public class FirebaseMethods {
    private FirebaseAuth mAuth;
    private Context mcontext;
    String userID;
    private FirebaseAuth.AuthStateListener mAuthListener;
    public FirebaseMethods(Context context){
        mcontext = context;
        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser() != null){
            userID = mAuth.getCurrentUser().getUid();
        }

    }

    /**
     * Register new user with email
     * @param Email
     * @param Password
     * @param username
     */
    public void registerNewEmail(final String Email, String Password, final String username){

        mAuth.createUserWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(mcontext, R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();
                        }else {
                            userID = mAuth.getCurrentUser().getUid();
                        }

                        // ...
                    }
                });
    }
}
