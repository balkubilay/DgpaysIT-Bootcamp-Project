package com.kubilaybal.dgpaysitbootcampproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.kubilaybal.dgpaysitbootcampproject.databinding.FragmentForgetPasswordBinding;

public class ForgetPasswordFragment extends Fragment {

    private FragmentForgetPasswordBinding binding;
    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_forget_password, container, false);
        View view = binding.getRoot();
        mAuth = FirebaseAuth.getInstance();
        forgotPassword();
        alreadyHavAccount();
        return view;
    }

    public void forgotPassword() {
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = String.valueOf(binding.editTextEmail.getText());
                if (!email.isEmpty()) {
                    mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                binding.editTextEmail.setText(null);
                                Log.d("forgotPassword", "Email sent.");
                                Toast.makeText(getActivity().getApplicationContext(), "Email sent", Toast.LENGTH_SHORT).show();
                            } else {
                                Log.d("forgotPassword", "Email not found.");
                                Toast.makeText(getActivity().getApplicationContext(), "Email not found", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else {
                    MainActivity.makeToast("Email is empty",getActivity().getApplicationContext());
                }
            }
        });
    }
    public void alreadyHavAccount(){
        binding.alreadyHavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_forgetPasswordFragment_to_loginScreenFragment);
            }
        });
    }
}