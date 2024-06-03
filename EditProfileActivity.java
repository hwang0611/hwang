package com.example.servertest;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfileActivity extends AppCompatActivity {
    EditText editUsernameEditText, editPW1EditText, editPW2EditText, editEmailEditText;
    ImageView eyeIcon3, eyeIcon4;
    TextView editprofilebutton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);

        editUsernameEditText = findViewById(R.id.editUsername);
        editPW1EditText = findViewById(R.id.editPW);
        editPW2EditText = findViewById(R.id.editPW2);
        editEmailEditText = findViewById(R.id.editEmail);
        eyeIcon3 = findViewById(R.id.eye_icon1_1);
        eyeIcon4 = findViewById(R.id.eye_icon2_1);
        editprofilebutton = findViewById(R.id.Editprofilebutton);


        editprofilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editusername = editUsernameEditText.getText().toString();
                String editpw = editPW1EditText.getText().toString();
                String editpw2 = editPW2EditText.getText().toString();
                String editemail = editEmailEditText.getText().toString();

                if (editusername.isEmpty() || editpw.isEmpty() || editpw2.isEmpty() || editemail.isEmpty()) {
                    Toast.makeText(EditProfileActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                // 비밀번호 확인을 확인하세요
                if (!editpw.equals(editpw2)) {
                    Toast.makeText(EditProfileActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                EditProfile editPrfile = new EditProfile(editusername, editpw, editemail);

                /*Call<Void> call = apiService.edit(editPrfile);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(retrofit2.Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            // 수정 성공
                            Toast.makeText(EditProfileActivity.this, "Information modification completed", Toast.LENGTH_SHORT).show();
                            // 마이페이지 이동
                            Intent intent = new Intent(EditProfileActivity.this, Menu5Fragment.class);
                            startActivity(intent);
                            finish();
                        } else {
                                // 상태 코드가 다른 경우 기본 메시지를 표시합니다.
                                Toast.makeText(EditProfileActivity.this, "Registration failed: " + response.message(), Toast.LENGTH_SHORT).show();

//                            Toast.makeText(SignUpActivity.this, "response.isSuccessful()) = failed : " + response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(retrofit2.Call<Void> call, Throwable t) {
                        // 연결 오류 처리
                        Toast.makeText(EditProfileActivity.this, "Registration failed : " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });*/

            }
        });

                // 비밀번호에 있는 눈 아이콘을 클릭하면 이벤트를 처리합니다
                eyeIcon3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editPW1EditText.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                            editPW1EditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                            eyeIcon3.setImageResource(R.drawable.ic_eye);
                        } else {
                            editPW1EditText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                            eyeIcon3.setImageResource(R.drawable.ic_eyex);
                        }
                    }
                });

                eyeIcon4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editPW2EditText.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                            editPW2EditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                            eyeIcon4.setImageResource(R.drawable.ic_eye);
                        } else {
                            editPW2EditText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                            eyeIcon4.setImageResource(R.drawable.ic_eyex);
                        }
                    }
                });

    }
}
