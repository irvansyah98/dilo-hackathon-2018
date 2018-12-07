package com.example.iervan.tripfella;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class HomeActivity extends AppCompatActivity {

    CarouselView carouselView;
    int[] sampleImages = {R.drawable.jatimpark, R.drawable.hotel, R.drawable.batu};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        EditText txt_cari = (EditText) findViewById(R.id.txt_cari);
        ImageView img_produk1 = (ImageView) findViewById(R.id.thumbnail_home1);
        ImageView img_produk5 = (ImageView) findViewById(R.id.thumbnail_home5);
        ImageView img_produk6 = (ImageView) findViewById(R.id.thumbnail_home6);
        ImageView img_produk7 = (ImageView) findViewById(R.id.thumbnail_home7);
        ImageView img_produk8 = (ImageView) findViewById(R.id.thumbnail_home8);
        ImageView img_cart = (ImageView) findViewById(R.id.btn_cart);

        img_cart.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, KeranjangActivity.class);
                startActivity(intent);
            }
        });

        img_produk1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, DetailPaketActivity.class);
                startActivity(intent);
            }
        });

        img_produk5.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, DetailPaketActivity.class);
                startActivity(intent);
            }
        });

        img_produk6.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, WisataActivity.class);
                startActivity(intent);
            }
        });

        img_produk7.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, PenginapanActivity.class);
                startActivity(intent);
            }
        });

        img_produk8.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, Oleh2Activity.class);
                startActivity(intent);
            }
        });

        txt_cari.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CariActivity.class);
                startActivity(intent);
            }
        });

        BottomNavigationView navigationBottom = (BottomNavigationView) findViewById(R.id.navigationViewBottom);

        navigationBottom.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                return true;
                            case R.id.navigation_pesananku:
                                Intent intent = new Intent(HomeActivity.this, PesanankuActivity.class);
                                startActivity(intent);
                                return true;
                            case R.id.navigation_favorit:
                                     intent = new Intent(HomeActivity.this, FavoritActivity.class);
                                    startActivity(intent);
                                return true;
                            case R.id.navigation_profil:
                                intent = new Intent(HomeActivity.this, ProfilActivity.class);
                                startActivity(intent);
                                return true;
                        }
                        return false;
                    }
                });
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
}
