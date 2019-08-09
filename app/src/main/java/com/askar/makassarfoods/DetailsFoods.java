package com.askar.makassarfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.askar.makassarfoods.Models.Food;
import com.squareup.picasso.Picasso;

public class DetailsFoods extends AppCompatActivity {

    private ImageView imageView;
    private TextView textViewNama,
            textViewJenis, textViewDeskripsi;

    private ListMakanan makanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_foods);

        imageView = findViewById(R.id.img_detail);
        textViewNama = findViewById(R.id.tv_nama_detail);
        textViewJenis = findViewById(R.id.tv_jenis_detail);
        textViewDeskripsi = findViewById(R.id.tv_deskripsi_detail);

        makanan = new ListMakanan();
        getDetail();
    }

    private void getDetail(){
        final Food food = (Food) getIntent().getParcelableExtra(makanan.getKEY());
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
}
