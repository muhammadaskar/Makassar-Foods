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

public class DessertFragment extends Fragment implements FoodAdapters.OnClickListener{

    View view;
    private RecyclerView recyclerView;
    private List<Food> foodList = new ArrayList<>();
    private FoodAdapters dessertAdapter;
    private Food dessert;

    FoodService dessertService;

    public DessertFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dessert_fragment, container, false);
        recyclerView = view.findViewById(R.id.rv_dessert_fragment);

        dessertService = ServiceGenerator.createService(FoodService.class);
        initsComponent();
        return view;
    }

    private void initsComponent(){
        dessertAdapter = new FoodAdapters(getContext(), foodList);
        dessertAdapter.setListener(this);
        recyclerView.setAdapter(dessertAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<List<Food>> dessert = dessertService.getDessert();
            dessert.enqueue(new Callback<List<Food>>() {
                @Override
                public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                    foodList = response.body();
                    dessertAdapter.setDataFoodList(foodList);
                }

                @Override
                public void onFailure(Call<List<Food>> call, Throwable t) {
                    Snackbar.make(view, "Ooopsss", Snackbar.LENGTH_SHORT).show();
                }
            });
    }

    @Override
    public void onClick(View view, int position) {
        dessert = new Food();
        dessert = foodList.get(position);
        startActivity(new Intent(getActivity(), DetailsFoods.class)
            .putExtra(KEY, dessert));
    }

    private void data(){
        Food food4 = new Food("https://sahabatnesia.com/wp-content/uploads/2017/11/4-8.jpg", "Barongko", "Dessert",
                "Barongko merupakan makanan khas Bugis-Makassar yang terbuat dari pisang yang dihaluskan, telur, santan, gula pasir, dan garam. Kemudian dibungkus daun pisang lalu dikukus. Jika sudah matang, dimasukkan ke dalam kulkas.\n" +
                        "\n" +"Dahulu, Barongko disajikan sebagai hidangan penutup bagi para raja Bugis. Selain itu juga sering disajikan saat acara adat seperti sunatan, akikah, pernikahan, syukuran dan lain sebagainya. Hingga kinipun Barongko masih biasa disajikan saat pesta adat. Selain itu pula, Barongko masih dapat dijumpai ketika bulan Ramadhan sebagai menu untuk berbuka puasa.\n" +
                        "\n" +
                        "Untuk membuat Barongko ini haruslah dikerjakan oleh orang yang sudah berpengalaman. Dengan tujuan untuk mempertahankan kualitas rasa dan kelezatan yang khas dari Barongko. Karena itulah Barongko tidak mudah dijumpai di pasaran.");
        foodList.add(food4);

        Food food5 = new Food("http://beritamks.com/bm/wp-content/uploads/2015/09/MAKASSAR_PISANG_EPE_-860x450.jpg", "Pisang Epe", "Dessert",
                "Pisang Epe merupakan makanan berbahan dasar pisang raja yang belum terlalu matang dan lembek, lalu dibakar. Kata “epe” sendiri berasal dari Bahasa Makassar yang artinya “jepit”, jadi maksud dari nama Pisang Epe adalah pisang bakar yang dijepit dan menjadi gepeng. Sesuai dengan namanya, Pisang Epe dimasak dengan cara dipanggang di atas bara api setelah sebelumnya dipress hingga menjadi gepeng. Pisang Epe yang telah melalui proses pembakaran biasanya disiram dengan saus yang berbahan dasar gula merah yang telah dicairkan sebagai topping. Namun saat ini, jenis saus Pisang Epe telah menyesuaikan zaman dengan ditambahkannya berbagai variasi saus seperti coklat durian, keju, dan sebagainya.");
        foodList.add(food5);

        Food food6 = new Food("https://sahabatnesia.com/wp-content/uploads/2017/11/6-8.jpg", "Es Pallu Butung", "Dessert",
                "Pallu Butung adalah makanan khas Sulawesi Selatan, makanan ini sering dijadikan hidangan untuk berbuka puasa di saat bulan Ramadan. Pallu Butung ini hampir mirip dengan Pisang Ijo.\n" +"\n" +"Pallu Butung terbuat dari campuran tepung beras, santan, gula pasir, daun pandan, vanili dan garam yang kemudian sampai matang dan kental. lalu dimasukkan potongan-potongan pisang raja yang juga sudah masak lalu diaduk. Pallu Butung dapat dihidangkan hangat-hangat, juga bisa dihidangkan dingin dengan menambah parutan es di atasnya. Pallu Butung juga bisa ditambahkan sedikit sirup untuk menambah warna dan rasa manis.");
        foodList.add(food6);

        Food food14 = new Food("http://2.bp.blogspot.com/-LAh7KgniFLQ/Vj0mYyKVXkI/AAAAAAAADZc/InM6aeSAVrA/s1600/IMG_20151106_093933_edit.jpg", "Putu Cangkir",
                "Dessert", "Putu cangkiri’ ini adalah makanan yang terbuat dari ketan yang memiliki bentuk mirip bagian bawah cangkir bila posisinya ditempatkan terbalik. Umumnya dibuat dengan dua variasi rasa yaitu manis dengan gula merah dan gula putih. Jika memakai gula merah warna Putu Cangkiri’ juga berwarna merah begitu juga saat memakai gula pasir.");
        foodList.add(food14);

        Food food15 = new Food("https://sahabatnesia.com/wp-content/uploads/2017/11/16-7.jpg", "Baje Canggoreng", "Dessert",
                "Baje Canggoreng merupakan kue tradisional yang bahan dasarnya adalah dari bahan kacang tanah dan juga gula merah, rasanya di lidah begitu menagihkan. Rasanya begitu manis dan gurih. Kue ini bisa bertahan kurang lebih satu bulan dalam kemasan. Dan makanan ini biasanya terdapat di penjual pinggir jalan sepanjang jalan Poros wilayah Sulawesi Selatan.");
        foodList.add(food15);

        Food food16 = new Food("https://2.bp.blogspot.com/-GMYylolQf7k/WsH3_YS6jRI/AAAAAAAAAKM/EoIYANqbpr07znpddLwNlgDyKzH90y4wACLcBGAs/s1600/Dange.jpg", "Dange", "Dessert", "Kue Dangge adalah merupakan kue basah hasil olahan dari tepung ketan hitam, dipadukan dengan parutan kepala muda, dan gula merah , hinggah kue dange ini sangat banyak digemari, kue dange ini bisa anda dapatkan di pangkep yakni dijalan poros makassar – pare, tepatnya di kecamatan sigeri, dan Kecamatan Mandalle kurang lebih 60 kilo meter menempuh perjalan dari kota makassar jika bertolak dari bandara internasional sultan hasanuddin");
        foodList.add(food16);

        Food food17 = new Food("http://1.bp.blogspot.com/-L7Ac-VTxNhI/VMp4CvX41FI/AAAAAAAAIOU/wakHb1fe_Ys/s1600/cangkuning_4.jpg", "Doko-doko Cangkuning", "Dessert", "Doko-doko Cangkuning biasa disebut di daerah bugis, dan di daerah Makassar biasa disebut dengan Roko-roko Cangkuning. Terbuat dari bahan tepung beras ketan, tepung kanji, air kapur siri, daun suji yang dicampur menjadi satu adonan. Kemudian untuk bagian isinya terbuat dari gula merah dan parutan kelapa. Kemudian terakhir dibungkus dengan daun pisang berbentuk kerucut. Saat ini jajanan ini banyak dijual sebagai bahan untuk buka puasa di kota Makassar.");
        foodList.add(food17);

        Food food18 = new Food("https://resepnusantara.id/wp-content/uploads/2017/12/baruasa-300x300.jpg", "Baruasa", "Dessert",
                "Baruasa' adalah kue yang terbuat dari tepung terigu yang digoreng bersama kelapa. Ada dua rasa yang berbeda yakni baruasa dengan campuran gula aren dan baruasa dengan campuran gula pasir.");
        foodList.add(food18);

        Food food19 = new Food("https://sahabatnesia.com/wp-content/uploads/2017/11/20-5.jpg", "Cucuru Bayao", "Dessert",
                "Cucuru Bayao, si Kue Manis Simbol Harapan Pengantin. ... Dalam sebuah bosara, baki berkaki tinggi berisikan kue, cucuru bayao disajikan bersama barongko, taloba, biji nangka, kue pelita, dan sikaporo. Dalam bahasa Makassar, 'cucuru' berarti kue, sedangkan 'bayao' artinya telur.");
        foodList.add(food19);

        Food drink1 = new Food("https://sahabatnesia.com/wp-content/uploads/2017/11/24-2.jpg", "Sarabba", "Minuman",
                "Sarabba merupakan minuman yang berasal dari Kota Makassar yang dibuat dengan bahan utama dari jahe, gula merah, telur kuning serta santan. Sarabba ini mempunyai citra rasa yang begitu menggoda lidah sehingga para pembeli ketagihan saat mencicipinya. Sarabba terbukti dipercaya dapat meningkatkan stamina tubuh, menghilangkan masuk angin, serta menyembuhkan penyakit yang datang kepada kita.");
        foodList.add(drink1);
    }

}
