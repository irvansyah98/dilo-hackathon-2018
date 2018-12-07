package com.example.iervan.tripfella;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        BottomNavigationView navigationBottom = (BottomNavigationView) findViewById(R.id.navigationViewBottom);

        navigationBottom.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                Intent intent = new Intent(ProfilActivity.this, HomeActivity.class);
                                startActivity(intent);

                                return true;
                            case R.id.navigation_pesananku:
                                 intent = new Intent(ProfilActivity.this, PesanankuActivity.class);
                                startActivity(intent);
                                return true;
                            case R.id.navigation_favorit:
                                intent = new Intent(ProfilActivity.this, FavoritActivity.class);
                                startActivity(intent);
                                return true;
                            case R.id.navigation_profil:
                                return true;
                        }
                        return false;
                    }
                });
    }
}
