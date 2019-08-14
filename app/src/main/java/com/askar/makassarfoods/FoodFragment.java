package com.askar.makassarfoods;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.askar.makassarfoods.Adapters.FoodAdapters;
import com.askar.makassarfoods.Models.Food;

import java.util.ArrayList;
import java.util.List;

import static com.askar.makassarfoods.Constants.Constants.KEY;

public class FoodFragment extends Fragment implements FoodAdapters.OnClickListener{

    View view;
    private RecyclerView recyclerView;
    private List<Food> foodList = new ArrayList<>();
    private FoodAdapters foodAdapter;
    private Food food;

    public FoodFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.food_fragment, container, false);
        recyclerView = view.findViewById(R.id.rv_foods_fragment);

        initsComponent();
        return view;
    }

    private void initsComponent(){
        data();
        foodAdapter = new FoodAdapters(getContext(), foodList);
        foodAdapter.setListener(this);
        recyclerView.setAdapter(foodAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void data(){
        Food food1 = new Food("https://sahabatnesia.com/wp-content/uploads/2017/11/1-8.jpg", "Coto Makassar", "Makanan",
                "Coto makassar atau coto mangkasara adalah makanan tradisional Makassar, Sulawesi Selatan. Makanan ini terbuat dari jeroan (isi perut) sapi yang direbus dalam waktu yang lama. Rebusan jeroan bercampur daging sapi ini kemudian diiris-iris lalu dibumbui dengan bumbu yang diracik secara khusus. Coto dihidangkan dalam mangkuk dan dinikmati dengan ketupat dan \"burasa\" atau yang biasa dikenal sebagai buras, yakni sejenis ketupat yang dibungkus daun pisang.");

        foodList.add(food1);

        Food food2 = new Food("https://sahabatnesia.com/wp-content/uploads/2017/11/2-8.jpg", "Sop Saudara", "Makanan",
                "Sop saudara merupakan masakan khas dari Sulawesi Selatan berupa hidangan berkuah dengan bahan dasar daging sapi yang biasanya disajikan bersama bahan pelengkap seperti bihun, perkedel kentang, jeroan sapi (misalnya, paru goreng), dan telur rebus. Masakan ini umum dikonsumsi bersama dengan nasi putih dan ikan bolu (bandeng) bakar.");
        foodList.add(food2);

        Food food3 = new Food("https://sahabatnesia.com/wp-content/uploads/2017/11/3-8.jpg", "Konro", "Makanan",
                "Sup Konro adalah masakan sup iga sapi khas Indonesia yang berasal dari tradisi Bugis dan Makassar. Sup ini biasanya dibuat dengan bahan iga sapi atau daging sapi. Masakan berkuah warna coklat kehitaman ini biasa dimakan dengan burasa dan ketupat yang dipotong-potong terlebih dahulu. Warna gelap ini berasal dari buah kluwek yang memang berwarna hitam. Bumbunya relatif \"kuat\" akibat digunakannya ketumbar. Rasa pedas dan berbumbu ini dibuat dari campuran rempah-rempah, seperti ketumbar, keluwak (buah yang menyebabkan masakan berwarna hitam), sedikit pala, kunyit, kencur, kayu manis, asam, daun lemon, cengkih, dan daun salam.");
        foodList.add(food3);

        Food food4 = new Food("https://sahabatnesia.com/wp-content/uploads/2017/11/7-8.jpg", "Gogoso", "Makanan",
                "Gogoso adalah salah satu makanan khas orang bugis makassar yang sangat digemari di Sulawesi Selatan ketika lebaran. Gogos atau gogoso adalah makanan khas Makassar yang mirip dengan lemper dari jawa atau Lalampa dari Manado. Bentuknya lebih panjang dan agak langsing bila dibandingkan dengan lemper. Gogos sendiri ada yang tanpa isian dan ada juga yang dengan isian. Gogos yang ada isian disebut dengan gogos kambu atau gogos isi. Isinya biasanya ikan tongkol yang dicampur dengan kelapa sangrai dan bumbu.");
        foodList.add(food4);

        Food food5 = new Food("https://sahabatnesia.com/wp-content/uploads/2017/11/8-8.jpg", "Pallu Basa", "Makanan",
                "Pallubasa adalah makanan tradisional Makassar, Sulawesi Selatan. Seperti Coto Mangkasara (Coto Makassar), Pallubasa juga terbuat dari jeroan (isi dalam perut) sapi atau kerbau. Proses memasaknya pun hampir sama dengan Coto Makassar, yaitu direbus dalam waktu lama. Setelah matang, jeroan yang ditambah dengan daging itu diiris-iris, kemudian ditaruh/dihidangkan dalam mangkuk.\n" +"\n" +"Dahulu, Pallubasa dengan daging sapi sirloin dan tenderloin hanya disajikan untuk disantap oleh keluarga kerajaan, sementara bagian jeroan disajikan untuk masyarakat kelas bawah atau abdi dalem pengikut kerajaan. Kini, penjual-penjual Pallubasa memberikan bermacam-macam pilihan daging sapi atau jeroan untuk dihidangkan.\n" +"\n" +"Yang membedakan Pallubasa dengan Coto Makassar adalah bumbunya yang diracik khusus. Selain itu, Coto Makassar dimakan bersama ketupat, sementara Pallubasa dimakan bersama nasi putih.");
        foodList.add(food5);

        Food food6 = new Food("https://sahabatnesia.com/wp-content/uploads/2017/11/9-8.jpg", "Mie Titi", "Makanan",
                "Mie Kering atau Mie Kering Makassar adalah masakan Tionghoa Indonesia, jenis mie kering yang disajikan dengan saus kental dan irisan ayam, udang, jamur, hati, dan cumi. Makanan ini agak mirip dengan I Fu Mie Tiongkok, hanya saja mienya yang lebih tipis.\n" +
                        "\n" +
                        "Resep itu dibuat oleh keturunan Tionghoa, Ang Kho Tjao. Dia membuka toko mie untuk menjual mie keringnya dan mendapatkan popularitas di Makassar sejak awal 70-an. Ang Kho Tjao mewariskan pengetahuan tentang resep makana ini kepada tiga anaknya yaitu Hengky, Awa', dan Titi. Setelah Ang Kho Tjao meninggal, bisnis toko mie kering dilanjutkan oleh ketiga anaknya yang terpisah membuka toko mereka sendiri. Titi paling populer di Makassar, disinilah asal nama \"Mie titi\" menjadi identik dengan mie kering Makassar.[1][2] Mie Kering adalah salah satu hidangan Makassar yang paling terkenal, yang lain adalah Coto Makassar dan Sup Konro.");
        foodList.add(food6);

        Food food7 = new Food("https://i1.wp.com/www.seruni.id/wp-content/uploads/2016/11/makanan-khas-makassar-9.jpg?w=800&ssl=1", "Juku Pallu Ce'la", "Makanan", "Pallu Cella merupakan masakan ikan bercita rasa asin dengan aroma khas kunyit. Ikan Pallu Cella bisanya terbuat dari ikan Cakalang, Layang, Bolu, Sibula atauTembang. Pallu Cella biasanya dibuat dengan bahan-bahan yang sederhana saja serta mudah atau gampang didapatkan, antara lain garam serta kunyit saja. Dalam pembuatan ikan pallu cella, kita harus memasak ikan tersebut dicampur dengan bahan-bahan tadi hingga airnya betul-betul meresap, sehingga rasa garam sarta aroma kunyit merata kedalam tubuh ikan.");
        foodList.add(food7);

        Food food8 = new Food("https://sahabatnesia.com/wp-content/uploads/2017/11/11-8.jpg", "Bebek Palekko", "Makanan",
                "Nasu Palekko adalah salah satu kuliner khas suku Bugis yang terbuat dari Daging Bebek yang dipotong-potong kecil seperti dicincang, atau disebut Daging Bebek Cincang. Dimana dalam proses pembuatannya, daging bebek yang sudah disembelih dan dikuliti serta dicincang lalu dicuci bersih. Kemudian diberi cuka atau jeruk nipis untuk menghilangkan bau amis-nya.\n" +
                        "\n" +
                        "Adapun bumbu-nya terdiri dari cabai, bawang merah, bawang putih, jahe, sereh , garam, bumbu rempah-rempah lainnya serta cuka,. Biasanya, cuka yang digunakan adalah cuka yang terbuat dari mangga muda. Cuka dan bawang putih atau jeruk nipis biasanya digunakan juga untuk menghilangkan bau amis pada daging. Kemudian bumbu tersebut di giling halus lalu dicampur potongan daging bebek sebelum dimasukkan kedalam penggorengan yang kemudian diaduk hingga matang untuk disajikan.");
        foodList.add(food8);

        Food food9 = new Food("https://sahabatnesia.com/wp-content/uploads/2017/11/13-7.jpg", "Kapurung", "Makanan",
                "Kappurung adalah salah satu makanan khas tradisional di Sulawesi Selatan, khususnya masyarakat daerah Luwu (Kota Palopo, Kabupaten Luwu, Luwu Utara, Luwu Timur) Makanan ini terbuat dari sari atau tepung sagu. Di daerah Maluku dikenal dengan nama Papeda. Kappurung dimasak dengan campuran ikan atau daging ayam dan aneka sayuran. Meski makanan tradisional, Kappurung mulai populer. Selain ditemukan di warung-warung khusus di Makassar juga telah masuk ke beberapa restoran, bersanding dengan makanan modern.Di daerah Luwu sendiri nama Kappurung' ini sering juga di sebut Pugalu atau Bugalu.");
        foodList.add(food9);

        Food food10 = new Food("https://apabedanya.com/wp-content/uploads/2019/04/Apa-Bedanya-Lontong-Ketupat-dan-Buras-foto-radar-tarakan-e1554718148810.jpg", "Burasa", "Makanan", "Burasa adalah salah satu panganan khas masyarakat Bugis dan makassar di Sulawesi Selatan. Panganan ini dikenal juga dengan nama lapat, lontong bersantan atau buras. Bentuknya hampir mirip dengan lontong cuma agak pipih dan dimasak dengan cara tersendiri. Burasa merupakan makanan wajib bagi masyarakat Sulawesi Selatan pada hari lebaran yang bisanya tersaji bersama coto makassar ataupun opor ayam.\n" +
                "\n" +"Panganan ini terbuat dari beras yang dimasak tertebih dahulu dengan santan yang banyak hingga menjadi nasi lembek dan selanjutnya dibungkus dengan daun pisang. Biasanya dibuat menjadi dua bagian dalam satu ikatan (menggunakan tali rapia atau daun pisang) kemudian direbus hingga matang. Panganan ini juga biasanya ditemui di luar provinsi Sulawesi Selatan seperti Gorontalo atau Kalimantan dan beberapa daerah lain di Indonesia dan Malaysia. Mungkin dikarenakan banyaknya suku Makassar dan Bugis yang merantau dan menetap di daerah-daerah tersebut sehingga panganan ini ikut menjadi bagian dari tradisi hari lebaran di daerah-daerah tersebut.");
        foodList.add(food10);

        Food food11 = new Food("https://sahabatnesia.com/wp-content/uploads/2017/11/21-3.jpg", "Sokko / Sangkolo", "Makanan",
                "Sokko/Sangkolo juga merupakan makanan khas yang terbuat dari beras ketan putih yang dikukus sampai matang, terkadang kue ini juga memakai beras ketan hitam. Songkolo begadang ini dihidangkan diatas piring dan diberikan taburan yang terbuat dari kelapa parut yang telah digoreng. Lauk pendampingnya yang biasa dibuat khas dari sini yaitu ikan asin kering dan telur itik asin. Jika pembeli yang bermaksud untuk mengkonsumsi kue ini dirumah, maka setiap porsi songkolo ini harus dibungkus dengan menggunakan bahan dari daun pisang yang di ikatkan dengan karet.");
        foodList.add(food11);

        Food food12 = new Food("https://scontent-sin6-2.cdninstagram.com/vp/c886318a67117eddfb055e8ad77c352d/5DB143AD/t51.2885-15/e35/55790172_2413667038656883_7535113424263026490_n.jpg?_nc_ht=scontent-sin6-2.cdninstagram.com&se=7&ig_cache_key=MjAyMzA4MDQzNzg3MzkwMzM3OA%3D%3D.2&_nc_ig_catcb=1",
                "Jalangkote", "Makanan", "Jalangkote adalah makanan ringan kuliner khas Makassar yang bentuknya serupa dengan kue pastel. Bedanya kue pastel memiliki kulit yang lebih tebal dibandingkan jalangkote dan bila pastel dimakan bersama cabe rawit, jalangkote dimakan bersama sambal cair campuran cuka dan cabe. Jalangkote memiliki isi wortel dan kentang yang dipotong dadu, tauge, serta laksa yang ditumis dengan menggunakan bawang putih, bawang merah, merica, dan bumbu-bumbu lainnya.[1] Beberapa jalangkote menambahkan seperempat atau setengah telur rebus dan daging cincang untuk isinya. Kulit jalangkote terbuat dari bahan dasar tepung terigu, telur, santan, mentega, dan garam.");
        foodList.add(food12);
    }

    @Override
    public void onClick(View view, int position) {
        food = new Food();
        food = foodList.get(position);
        startActivity(new Intent(getActivity(), DetailsFoods.class)
                .putExtra(KEY, food));
    }
}
