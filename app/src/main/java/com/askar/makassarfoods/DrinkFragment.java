package com.askar.makassarfoods;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.askar.makassarfoods.Adapters.FoodAdapters;
import com.askar.makassarfoods.Generator.ServiceGenerator;
import com.askar.makassarfoods.Models.Food;
import com.askar.makassarfoods.Services.FoodService;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.askar.makassarfoods.Constants.Constants.KEY;

public class DrinkFragment extends Fragment implements FoodAdapters.OnClickListener{

    View view;

    private RecyclerView recyclerView;
    private List<Food> drinkList = new ArrayList<>();
    private FoodAdapters drinkAdapter;
    private Food drink;

    private FoodService drinkService;

    public DrinkFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.drink_fragment, container, false);
        recyclerView = view.findViewById(R.id.rv_drinks_fragment);
        drinkService = ServiceGenerator.createService(FoodService.class);
        initsComponent();
        return view;
    }

    private void initsComponent(){
        drinkAdapter = new FoodAdapters(getContext(), drinkList);
        drinkAdapter.setListener(this);
        recyclerView.setAdapter(drinkAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<List<Food>> food = drinkService.getDessert();
            food.enqueue(new Callback<List<Food>>() {
                @Override
                public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                    drinkList = response.body();
                    drinkAdapter.setDataFoodList(drinkList);
                }

                @Override
                public void onFailure(Call<List<Food>> call, Throwable t) {
                    Snackbar.make(view, "Oopssss", Snackbar.LENGTH_SHORT).show();
                }
            });

    }

    private void data(){
            Food drink1 = new Food("https://sahabatnesia.com/wp-content/uploads/2017/11/24-2.jpg", "Sarabba", "Minuman",
                    "Sarabba merupakan minuman yang berasal dari Kota Makassar yang dibuat dengan bahan utama dari jahe, gula merah, telur kuning serta santan. Sarabba ini mempunyai citra rasa yang begitu menggoda lidah sehingga para pembeli ketagihan saat mencicipinya. Sarabba terbukti dipercaya dapat meningkatkan stamina tubuh, menghilangkan masuk angin, serta menyembuhkan penyakit yang datang kepada kita.");
            drinkList.add(drink1);
    }

    @Override
    public void onClick(View view, int position) {
        drink = new Food();
        drink = drinkList.get(position);
        startActivity(new Intent(getActivity(), DetailsFoods.class)
            .putExtra(KEY, drink));
    }
}
