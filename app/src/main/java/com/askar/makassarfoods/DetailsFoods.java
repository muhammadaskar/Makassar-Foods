package com.askar.makassarfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.askar.makassarfoods.Models.Food;
import com.squareup.picasso.Picasso;

import static com.askar.makassarfoods.Constants.Constants.KEY;

public class DetailsFoods extends AppCompatActivity {

    private ImageView imageView;
    private TextView textViewNama,
            textViewJenis, textViewDeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_foods);

        imageView = findViewById(R.id.img_detail);
        textViewNama = findViewById(R.id.tv_nama_detail);
        textViewJenis = findViewById(R.id.tv_jenis_detail);
        textViewDeskripsi = findViewById(R.id.tv_deskripsi_detail);
        getDetail();
    }

    private void getDetail(){
        final Food food = (Food) getIntent().getParcelableExtra(KEY);
        if (food != null){
            Picasso.get().load(food.getPhoto()).into(imageView);
            textViewNama.setText(food.getNama());
            textViewJenis.setText(food.getJenis());
            textViewDeskripsi.setText(food.getDeskripsi());

            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle("Detail "+food.getJenis());
            }

        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }


    public void clickKembali(View view) {
        onBackPressed();
    }
}
