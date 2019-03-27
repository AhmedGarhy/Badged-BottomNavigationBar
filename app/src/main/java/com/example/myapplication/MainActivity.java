package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.badgedbottomnavigationbar.BadgedBottomNavigationBar;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private BadgedBottomNavigationBar navigation;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    navigation.getMenu().getItem(0).setIcon(R.drawable.ic_home_black_24dp);
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };


//    public void updateNavigationBarBadges(String[] ids) {
//        for (String screenId : ids) {
//            int menuItemIndex = 2;
//            for (int i = 0; i < 2; i++) {
//                if (navigation.getMenu().getItem(i).getTitle().equals(screenId)) {
//                    menuItemIndex = i;
//                    break;
//                }
//            }
//            navigation.showBadge(menuItemIndex);
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        navigation = (BadgedBottomNavigationBar) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 3; i++) {
                    navigation.showBadge(i);
                }
            }
        });

        findViewById(R.id.remove_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 3; i++) {
                    navigation.removeBadge(i);
                }
            }
        });

    }
}
