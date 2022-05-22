package com.kubilaybal.dgpaysitbootcampproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.kubilaybal.dgpaysitbootcampproject.databinding.FragmentLoginScreenBinding;

public class LoginScreenFragment extends Fragment {

    private FragmentLoginScreenBinding binding;
    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login_screen, container, false);
        View view = binding.getRoot();
        mAuth = FirebaseAuth.getInstance();
        login();
        forgotPassword();
        return view;
    }

/*    @Override
    public void onStart() {  //Login kontrolü yapılmak istenirse açılabilir
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Toast.makeText(getActivity().getApplicationContext(), "Authentication success.",
                    Toast.LENGTH_SHORT).show();
        }
    }*/

    public void login() {
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = String.valueOf(binding.editTextEmail.getText());
                String password = String.valueOf(binding.editTextPassword.getText());
                if (!email.isEmpty() && !password.isEmpty()) {
                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.d("Login", "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                Navigation.findNavController(view).navigate(R.id.action_loginScreenFragment_to_mainFragment);
                            } else {
                                Log.w("Login", "signInWithEmail:failure", task.getException());
                                MainActivity.makeToast("Authentication failed.",getActivity().getApplicationContext());
                            }
                        }
                    });
                } else {
                    MainActivity.makeToast("Email or Password is empty",getActivity().getApplicationContext());

                }
            }
        });
    }

    public void forgotPassword() {
        binding.forgotPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_loginScreenFragment_to_forgetPasswordFragment);
            }
        });
    }
}