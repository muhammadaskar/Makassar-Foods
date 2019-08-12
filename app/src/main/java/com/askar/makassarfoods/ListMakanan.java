package com.askar.makassarfoods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.askar.makassarfoods.Adapters.FoodAdapters;
import com.askar.makassarfoods.Models.Food;

import java.util.ArrayList;
import java.util.List;

public class ListMakanan extends AppCompatActivity implements FoodAdapters.OnClickListener{

    private Food food;
    private RecyclerView recyclerView;
    private FoodAdapters foodAdapter;
    private List<Food> foodList = new ArrayList<>();


    private ViewPager2 viewPager2;

    private static final String KEY = "kunci";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_makanan);

        viewPager2 = findViewById(R.id.viewPager2);
        recyclerView = findViewById(R.id.rv_foods);
        initComponents();
    }

    private void initComponents(){
        data();
        try {
            foodAdapter = new FoodAdapters(foodList);
            foodAdapter.setListener(this);
            recyclerView.setAdapter(foodAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        } catch (Exception e){
            Log.d("peringatan", "Terjadi Kesalahan Pada "+e);
        }

    }

    @Override
    public void onClick(View view, int position) {
        food = new Food();
        food = foodList.get(position);
        startActivity(new Intent(ListMakanan.this, DetailsFoods.class)
            .putExtra(KEY, food));
    }

    public static String getKEY() {
        return KEY;
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.acttion_about:
                Intent i = new Intent(this, AboutActivity.class);
                startActivity(i);
                break;
                default:
        return super.onOptionsItemSelected(menuItem);
        }
        return true;
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

        Food food7 = new Food("https://sahabatnesia.com/wp-content/uploads/2017/11/7-8.jpg", "Gogoso", "Makanan",
                "Gogoso adalah salah satu makanan khas orang bugis makassar yang sangat digemari di Sulawesi Selatan ketika lebaran. Gogos atau gogoso adalah makanan khas Makassar yang mirip dengan lemper dari jawa atau Lalampa dari Manado. Bentuknya lebih panjang dan agak langsing bila dibandingkan dengan lemper. Gogos sendiri ada yang tanpa isian dan ada juga yang dengan isian. Gogos yang ada isian disebut dengan gogos kambu atau gogos isi. Isinya biasanya ikan tongkol yang dicampur dengan kelapa sangrai dan bumbu.");
        foodList.add(food7);

        Food food8 = new Food("https://sahabatnesia.com/wp-content/uploads/2017/11/8-8.jpg", "Pallu Basa", "Makanan",
                "Pallubasa adalah makanan tradisional Makassar, Sulawesi Selatan. Seperti Coto Mangkasara (Coto Makassar), Pallubasa juga terbuat dari jeroan (isi dalam perut) sapi atau kerbau. Proses memasaknya pun hampir sama dengan Coto Makassar, yaitu direbus dalam waktu lama. Setelah matang, jeroan yang ditambah dengan daging itu diiris-iris, kemudian ditaruh/dihidangkan dalam mangkuk.\n" +"\n" +"Dahulu, Pallubasa dengan daging sapi sirloin dan tenderloin hanya disajikan untuk disantap oleh keluarga kerajaan, sementara bagian jeroan disajikan untuk masyarakat kelas bawah atau abdi dalem pengikut kerajaan. Kini, penjual-penjual Pallubasa memberikan bermacam-macam pilihan daging sapi atau jeroan untuk dihidangkan.\n" +"\n" +"Yang membedakan Pallubasa dengan Coto Makassar adalah bumbunya yang diracik khusus. Selain itu, Coto Makassar dimakan bersama ketupat, sementara Pallubasa dimakan bersama nasi putih.");
        foodList.add(food8);

        Food food9 = new Food("https://sahabatnesia.com/wp-content/uploads/2017/11/9-8.jpg", "Mie Titi", "Makanan",
                "Mie Kering atau Mie Kering Makassar adalah masakan Tionghoa Indonesia, jenis mie kering yang disajikan dengan saus kental dan irisan ayam, udang, jamur, hati, dan cumi. Makanan ini agak mirip dengan I Fu Mie Tiongkok, hanya saja mienya yang lebih tipis.\n" +
                        "\n" +
                        "Resep itu dibuat oleh keturunan Tionghoa, Ang Kho Tjao. Dia membuka toko mie untuk menjual mie keringnya dan mendapatkan popularitas di Makassar sejak awal 70-an. Ang Kho Tjao mewariskan pengetahuan tentang resep makana ini kepada tiga anaknya yaitu Hengky, Awa', dan Titi. Setelah Ang Kho Tjao meninggal, bisnis toko mie kering dilanjutkan oleh ketiga anaknya yang terpisah membuka toko mereka sendiri. Titi paling populer di Makassar, disinilah asal nama \"Mie titi\" menjadi identik dengan mie kering Makassar.[1][2] Mie Kering adalah salah satu hidangan Makassar yang paling terkenal, yang lain adalah Coto Makassar dan Sup Konro.");
        foodList.add(food9);

        Food food10 = new Food("https://i1.wp.com/www.seruni.id/wp-content/uploads/2016/11/makanan-khas-makassar-9.jpg?w=800&ssl=1", "Juku Pallu Ce'la", "Makanan", "Pallu Cella merupakan masakan ikan bercita rasa asin dengan aroma khas kunyit. Ikan Pallu Cella bisanya terbuat dari ikan Cakalang, Layang, Bolu, Sibula atauTembang. Pallu Cella biasanya dibuat dengan bahan-bahan yang sederhana saja serta mudah atau gampang didapatkan, antara lain garam serta kunyit saja. Dalam pembuatan ikan pallu cella, kita harus memasak ikan tersebut dicampur dengan bahan-bahan tadi hingga airnya betul-betul meresap, sehingga rasa garam sarta aroma kunyit merata kedalam tubuh ikan.");
        foodList.add(food10);

        Food food11 = new Food("https://sahabatnesia.com/wp-content/uploads/2017/11/11-8.jpg", "Bebek Palekko", "Makanan",
                "Nasu Palekko adalah salah satu kuliner khas suku Bugis yang terbuat dari Daging Bebek yang dipotong-potong kecil seperti dicincang, atau disebut Daging Bebek Cincang. Dimana dalam proses pembuatannya, daging bebek yang sudah disembelih dan dikuliti serta dicincang lalu dicuci bersih. Kemudian diberi cuka atau jeruk nipis untuk menghilangkan bau amis-nya.\n" +
                        "\n" +
                        "Adapun bumbu-nya terdiri dari cabai, bawang merah, bawang putih, jahe, sereh , garam, bumbu rempah-rempah lainnya serta cuka,. Biasanya, cuka yang digunakan adalah cuka yang terbuat dari mangga muda. Cuka dan bawang putih atau jeruk nipis biasanya digunakan juga untuk menghilangkan bau amis pada daging. Kemudian bumbu tersebut di giling halus lalu dicampur potongan daging bebek sebelum dimasukkan kedalam penggorengan yang kemudian diaduk hingga matang untuk disajikan.");
        foodList.add(food11);

        Food food12 = new Food("https://sahabatnesia.com/wp-content/uploads/2017/11/13-7.jpg", "Kapurung", "Makanan",
                "Kappurung adalah salah satu makanan khas tradisional di Sulawesi Selatan, khususnya masyarakat daerah Luwu (Kota Palopo, Kabupaten Luwu, Luwu Utara, Luwu Timur) Makanan ini terbuat dari sari atau tepung sagu. Di daerah Maluku dikenal dengan nama Papeda. Kappurung dimasak dengan campuran ikan atau daging ayam dan aneka sayuran. Meski makanan tradisional, Kappurung mulai populer. Selain ditemukan di warung-warung khusus di Makassar juga telah masuk ke beberapa restoran, bersanding dengan makanan modern.Di daerah Luwu sendiri nama Kappurung' ini sering juga di sebut Pugalu atau Bugalu.");
        foodList.add(food12);

        Food food13 = new Food("https://apabedanya.com/wp-content/uploads/2019/04/Apa-Bedanya-Lontong-Ketupat-dan-Buras-foto-radar-tarakan-e1554718148810.jpg", "Burasa", "Makanan", "Burasa adalah salah satu panganan khas masyarakat Bugis dan makassar di Sulawesi Selatan. Panganan ini dikenal juga dengan nama lapat, lontong bersantan atau buras. Bentuknya hampir mirip dengan lontong cuma agak pipih dan dimasak dengan cara tersendiri. Burasa merupakan makanan wajib bagi masyarakat Sulawesi Selatan pada hari lebaran yang bisanya tersaji bersama coto makassar ataupun opor ayam.\n" +
                "\n" +"Panganan ini terbuat dari beras yang dimasak tertebih dahulu dengan santan yang banyak hingga menjadi nasi lembek dan selanjutnya dibungkus dengan daun pisang. Biasanya dibuat menjadi dua bagian dalam satu ikatan (menggunakan tali rapia atau daun pisang) kemudian direbus hingga matang. Panganan ini juga biasanya ditemui di luar provinsi Sulawesi Selatan seperti Gorontalo atau Kalimantan dan beberapa daerah lain di Indonesia dan Malaysia. Mungkin dikarenakan banyaknya suku Makassar dan Bugis yang merantau dan menetap di daerah-daerah tersebut sehingga panganan ini ikut menjadi bagian dari tradisi hari lebaran di daerah-daerah tersebut.");
        foodList.add(food13);

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

        Food food20 = new Food("https://sahabatnesia.com/wp-content/uploads/2017/11/21-3.jpg", "Sokko / Sangkolo", "Makanan",
                "Sokko/Sangkolo juga merupakan makanan khas yang terbuat dari beras ketan putih yang dikukus sampai matang, terkadang kue ini juga memakai beras ketan hitam. Songkolo begadang ini dihidangkan diatas piring dan diberikan taburan yang terbuat dari kelapa parut yang telah digoreng. Lauk pendampingnya yang biasa dibuat khas dari sini yaitu ikan asin kering dan telur itik asin. Jika pembeli yang bermaksud untuk mengkonsumsi kue ini dirumah, maka setiap porsi songkolo ini harus dibungkus dengan menggunakan bahan dari daun pisang yang di ikatkan dengan karet.");
        foodList.add(food20);

        Food food21 = new Food("https://scontent.cdninstagram.com/vp/78f9cd1c95e767a583b7da1e5df1163f/5D64FFDE/t51.2885-15/e35/s480x480/58409993_432621740642161_4523678084535439417_n.jpg?_nc_ht=scontent-ort2-2.cdninstagram.com", "Buroncong", "Dessert",
                "Buroncong adalah salah satu kue tradisional khas Bugis Makassar yang hingga saat ini masih diminati. ... Jajanan ini terbuat dari campuran tepung terigu, santan dan parutan kelapa muda, gula pasir, garam serta penambahan soda kue.");
        foodList.add(food21);

        Food food22 = new Food("https://scontent-sin6-2.cdninstagram.com/vp/c886318a67117eddfb055e8ad77c352d/5DB143AD/t51.2885-15/e35/55790172_2413667038656883_7535113424263026490_n.jpg?_nc_ht=scontent-sin6-2.cdninstagram.com&se=7&ig_cache_key=MjAyMzA4MDQzNzg3MzkwMzM3OA%3D%3D.2&_nc_ig_catcb=1",
                "Jalangkote", "Food", "Jalangkote adalah makanan ringan kuliner khas Makassar yang bentuknya serupa dengan kue pastel. Bedanya kue pastel memiliki kulit yang lebih tebal dibandingkan jalangkote dan bila pastel dimakan bersama cabe rawit, jalangkote dimakan bersama sambal cair campuran cuka dan cabe. Jalangkote memiliki isi wortel dan kentang yang dipotong dadu, tauge, serta laksa yang ditumis dengan menggunakan bawang putih, bawang merah, merica, dan bumbu-bumbu lainnya.[1] Beberapa jalangkote menambahkan seperempat atau setengah telur rebus dan daging cincang untuk isinya. Kulit jalangkote terbuat dari bahan dasar tepung terigu, telur, santan, mentega, dan garam.");
        foodList.add(food22);

        Food food23 = new Food("https://sahabatnesia.com/wp-content/uploads/2017/11/24-2.jpg", "Sarabba", "Minuman",
                "Sarabba merupakan minuman yang berasal dari Kota Makassar yang dibuat dengan bahan utama dari jahe, gula merah, telur kuning serta santan. Sarabba ini mempunyai citra rasa yang begitu menggoda lidah sehingga para pembeli ketagihan saat mencicipinya. Sarabba terbukti dipercaya dapat meningkatkan stamina tubuh, menghilangkan masuk angin, serta menyembuhkan penyakit yang datang kepada kita.");
        foodList.add(food23);
    }
}
