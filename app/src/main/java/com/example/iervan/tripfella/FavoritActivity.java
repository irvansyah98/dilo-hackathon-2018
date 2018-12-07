package com.example.iervan.tripfella;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class FavoritActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorit);

        BottomNavigationView navigationBottom = (BottomNavigationView) findViewById(R.id.navigationViewBottom);

        navigationBottom.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                Intent intent = new Intent(FavoritActivity.this, HomeActivity.class);
                                startActivity(intent);

                                return true;
                            case R.id.navigation_pesananku:
                                intent = new Intent(FavoritActivity.this, PesanankuActivity.class);
                                startActivity(intent);

                                return true;
                            case R.id.navigation_favorit:
                                return true;
                            case R.id.navigation_profil:
                                intent = new Intent(FavoritActivity.this, ProfilActivity.class);
                                startActivity(intent);
                                return true;
                        }
                        return false;
                    }
                });
    }
}
