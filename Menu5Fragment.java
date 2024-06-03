package com.example.servertest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.servertest.model.CircleTransform;
import com.example.servertest.model.User;
import com.squareup.picasso.Picasso;

public class Menu5Fragment extends Fragment {
//    private TextView usernameTextView;
//    private TextView emailTextView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu5fragment, container, false);
        TextView logoutTextView = view.findViewById(R.id.textViewLogout);
        TextView editinformationTextView = view.findViewById(R.id.editinformation);





        Bundle bundle = getArguments();
        if (bundle != null) {
            User user = (User) bundle.getSerializable("user");
            if (user != null) {
                TextView usernameTextView = view.findViewById(R.id.Text_Name);
                TextView emailTextView = view.findViewById(R.id.text_gmail);
                ImageView imgviewMyAvt = view.findViewById(R.id.imageViewMyAvt);
                ImageView imgviewCover = view.findViewById(R.id.imgviewcoverimg);
                usernameTextView.setText(user.getUsername());
                emailTextView.setText(user.getEmail());
                if (user != null && user.getAvatarImage() != null && !user.getAvatarImage().isEmpty()) {
                    Picasso.get().load(user.getAvatarImage())
                            .transform(new CircleTransform())
                            .placeholder(R.drawable.custom_border2)
                            .error(R.drawable.custom_border2)
                            .into(imgviewMyAvt);
                    Picasso.get().load(user.getCoverImage()).into(imgviewCover);
                } else {
                    // Nếu không có đường dẫn ảnh hoặc đường dẫn rỗng, hiển thị ảnh mặc định từ thư mục drawable
                    // 이미지 경로가 없거나 경로가 비어 있는 경우 drawable 폴더의 기본 이미지를 표시합니다.
                    imgviewMyAvt.setImageResource(R.drawable.user_icon2);
                    imgviewCover.setImageResource(R.drawable.ic_bg);
                }
//                Log.e("Menu5Fragment", "Username: " + user.getUsername());
//                Log.e("Menu5Fragment", "Email: " + user.getEmail());
//                Log.e("menu5","userid: "+ user.getUserId());
            }
        }

        editinformationTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EditProfileActivity.class);
                startActivity(intent);
            }
        });


        logoutTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 여기서 로그아웃을 처리하세요

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish(); // 현재 활동 닫기
            }
        });
        return view;
    }


}