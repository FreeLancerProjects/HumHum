package com.creativeshare.humhum.activities_fragments.activity_splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.creativeshare.humhum.R;
import com.creativeshare.humhum.activities_fragments.activity_home.client_home.activity.ClientHomeActivity;
import com.creativeshare.humhum.activities_fragments.activity_sign_in.activity.SignInActivity;
import com.creativeshare.humhum.language.Language_Helper;
import com.creativeshare.humhum.models.UserModel;
import com.creativeshare.humhum.preferences.Preferences;
import com.creativeshare.humhum.singletone.UserSingleTone;
import com.creativeshare.humhum.tags.Tags;

public class SplashActivity extends AppCompatActivity {

    private Preferences preferences;

    private ImageView cov, img_hum;
    private String current_lang;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(Language_Helper.updateResources(base, Language_Helper.getLanguage(base)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        preferences = Preferences.getInstance();
        cov = findViewById(R.id.img_cov);
        img_hum = findViewById(R.id.img_hum);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.move);
        final Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.fade);

        cov.startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                img_hum.setVisibility(View.VISIBLE);
                img_hum.startAnimation(animation1);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler()
                        .postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                String session = preferences.getSession(SplashActivity.this);

                                if (session.equals(Tags.session_login)) {
                                    UserModel userModel = preferences.getUserData(SplashActivity.this);
                                    UserSingleTone userSingleTone = UserSingleTone.getInstance();
                                    userSingleTone.setUserModel(userModel);

                                    Intent intent = new Intent(SplashActivity.this, ClientHomeActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Intent intent = new Intent(SplashActivity.this, SignInActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        },1000);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
