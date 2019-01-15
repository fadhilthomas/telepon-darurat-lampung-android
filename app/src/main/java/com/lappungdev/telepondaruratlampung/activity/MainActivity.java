package com.lappungdev.telepondaruratlampung.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;
import android.widget.Toast;

import com.lappungdev.telepondaruratlampung.R;
import com.lappungdev.telepondaruratlampung.adapter.RecyclerViewAdapter;
import com.lappungdev.telepondaruratlampung.model.Telepon;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Telepon> list = new ArrayList<>();
    private static final int CALL_PHONE_REQUEST_CODE = 102;
    private SearchView svCari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list.add(new Telepon("Nomor Pengaduan Pelayanan Publik Pemerintah Kota Bandar Lampung","082282204761"));
        list.add(new Telepon("Nomor Pengaduan Pelayanan Publik Pemerintah Kota Bandar Lampung","082282204762"));
        list.add(new Telepon("Nomor Pengaduan Pelayanan Publik Pemerintah Kota Bandar Lampung","082282204763"));
        list.add(new Telepon("Central 21 Bioskop","0721262446"));
        list.add(new Telepon("Boemi Kedaton XXI","07218015582"));
        list.add(new Telepon("Hotline Polisi","110"));
        list.add(new Telepon("POLDA Lampung","0721486841"));
        list.add(new Telepon("Poltabes Bandar Lampung","0721254110"));
        list.add(new Telepon("Polsekta Panjang","072131383"));
        list.add(new Telepon("Polsekta Kedaton","07217691110"));
        list.add(new Telepon("Polsekta Sukarame","07217624250"));
        list.add(new Telepon("Polsekta Tanjung Karang Timur","0721253783"));
        list.add(new Telepon("Polsekta Tanjung Karang Barat","0721255015"));
        list.add(new Telepon("Polsekta Tanjung Karang Utara","0721482083"));
        list.add(new Telepon("Polsekta Teluk Betung Selatan","0721481283"));
        list.add(new Telepon("Polsekta Teluk Betung Barat","0721485383"));
        list.add(new Telepon("Polres Lampung Tengah","072125656"));
        list.add(new Telepon("Polsek Bandar Jaya","072125818"));
        list.add(new Telepon("Polsek Gunung Sugih ","072127100"));
        list.add(new Telepon("Polsek Seputih Banyak","07217623203"));
        list.add(new Telepon("Polsek Seputih Mataram","07217568230"));
        list.add(new Telepon("Polsek Tegineneng","07217851534"));
        list.add(new Telepon("Polsek Punggur","07217001497"));
        list.add(new Telepon("Polres Lampung Selatan","0721321124"));
        list.add(new Telepon("Polsek Gading Rejo","072194449"));
        list.add(new Telepon("Polsek Kalianda","0721322141"));
        list.add(new Telepon("Polsek Natar","072191214"));
        list.add(new Telepon("Polsek Tanjung Bintang","0721351110"));
        list.add(new Telepon("Polsek Sidomulyo","07217693110"));
        list.add(new Telepon("Polres Lampung Utara Abung Selatan","07213260232"));
        list.add(new Telepon("Polsek Sungkai Selatan","072125665"));
        list.add(new Telepon("Polsek Bukit Kemuning","072191110"));
        list.add(new Telepon("Polsek Sungkai Utara","072125662"));
        list.add(new Telepon("Polsek Kotabumi Kota","072125993"));
        list.add(new Telepon("Polres Metro","072141110"));
        list.add(new Telepon("Polsek Metro Utara","07217020429"));
        list.add(new Telepon("Polres Lampung Timur","0721625110"));
        list.add(new Telepon("Polsek Batanghari","072147997"));
        list.add(new Telepon("Polsek Labuhan Maringgai","0721660480"));
        list.add(new Telepon("Polsek Pekalongan","072141959"));
        list.add(new Telepon("Polsek Sekampung","072148093"));
        list.add(new Telepon("Polsek Way Jepara","0721640070"));
        list.add(new Telepon("Polsek Raman Utara","07217628148"));
        list.add(new Telepon("Polsek Metro Kibang","07217853189"));
        list.add(new Telepon("Polsek Labuhan Ratu","07217645300"));
        list.add(new Telepon("Polsek Sukadana","0721625083"));
        list.add(new Telepon("Polsek Mataram Baru","0721660299"));
        list.add(new Telepon("Polsek Sekampung Udik","0721677000"));
        list.add(new Telepon("Polres Waykanan","0721461046"));
        list.add(new Telepon("Polres Lampung Barat","072121148"));
        list.add(new Telepon("Polsek Balikbukit","072121110"));
        list.add(new Telepon("Polsek Krui","072151110"));
        list.add(new Telepon("Polsek Sumber Jaya","0721465110"));
        list.add(new Telepon("Polsek Tanggamus","072121110"));
        list.add(new Telepon("Polsek Kalirejo","0721370110"));
        list.add(new Telepon("Polsek Kedondong","072122813"));
        list.add(new Telepon("Polsek Kota Agung","072121656"));
        list.add(new Telepon("Polsek Pardasuka","072122740"));
        list.add(new Telepon("Polsek Pringsewu","072121210"));
        list.add(new Telepon("Polsek Talang Padang","072141110"));
        list.add(new Telepon("Polsek Gedong Tataan","072194309"));
        list.add(new Telepon("Polsek Bangunrejo","07217375110"));
        list.add(new Telepon("RSUD Abdoel Moeleok","0721702455"));
        list.add(new Telepon("RSUD Abdoel Moeleok","0721703312"));
        list.add(new Telepon("RS Bumi Waras","0721254589"));
        list.add(new Telepon("RS Urip Sumoharjo","0721771322"));
        list.add(new Telepon("RS Advent","0721703459"));
        list.add(new Telepon("RS Immanuel","0721704900"));
        list.add(new Telepon("RS Graha Husada","0721240000"));
        list.add(new Telepon("RS Bintang Amin Husada","0721273601"));
        list.add(new Telepon("RSUD Jendral Ahmad Yani","072541820"));
        list.add(new Telepon("RSUD Mayjen MH Ryacudu","072421035"));
        list.add(new Telepon("RSUD Sepulau Raya","0721529828"));
        list.add(new Telepon("RS Yukum Medical Center","072125988"));
        list.add(new Telepon("RS Yukum Medical Center","072125989"));
        list.add(new Telepon("RSUD Lampung Timur","0721625326"));
        list.add(new Telepon("RSUD Liwa","072121651"));
        list.add(new Telepon("RSUD Liwa","072121131"));
        list.add(new Telepon("RSUD Menggala","072121146"));
        list.add(new Telepon("RSUD Kalianda","0721322160"));
        list.add(new Telepon("RSU Pringsewu","072123408"));
        list.add(new Telepon("RSU Pringsewu","07217377563"));
        list.add(new Telepon("PLN Pusat","123"));
        list.add(new Telepon("PLN Area Tanjung Karang","0721261625 "));
        list.add(new Telepon("PLN Layanan Gangguan","072543339"));
        list.add(new Telepon("PLN Layanan Gangguan","072423737"));
        list.add(new Telepon("PDAM Layanan Pengaduan di Bandar Lampung","0721483855"));
        list.add(new Telepon("PDAM Layanan Pengaduan di Metro","072543339"));
        list.add(new Telepon("PDAM Layanan Pengaduan di Kotabumi","072426344"));
        list.add(new Telepon("Ambulans","118"));
        list.add(new Telepon("PMI","0721253452"));
        list.add(new Telepon("Pemadam Kebakaran","113"));
        list.add(new Telepon("Pemadam Kebakaran","0721252741"));
        list.add(new Telepon("Telkom Center","147"));
        list.add(new Telepon("Layanan Rekening Telkom","109"));
        list.add(new Telepon("Penerangan Telkom Lokal","108"));
        list.add(new Telepon("Penerangan Telkom Interlokal","100"));
        list.add(new Telepon("Penerangan Telkom International","107"));
        list.add(new Telepon("Bandar Lampung","0721253014"));
        list.add(new Telepon("Metro","072544161"));
        list.add(new Telepon("Kotabumi","072421003"));
        list.add(new Telepon("KOMNAS HAM INDONESIA","0213925230"));
        list.add(new Telepon("Penerangan HIV / AIDS","163"));
        list.add(new Telepon("Dinas Kebersihan Bandar Lampung","0721252341"));
        list.add(new Telepon("Pemerintah Provinsi Lampung","0721481166"));
        list.add(new Telepon("Pemerintah Kota Bandar Lampung","0721252041"));
        list.add(new Telepon("Kejaksaan Negeri Lampung","0721473576"));
        list.add(new Telepon("Kejakasaan Tinggi Lampung","0721482409"));
        list.add(new Telepon("Bandara Raden Intan II","072191114"));
        list.add(new Telepon("Bandara Raden Intan II","07217697321"));
        list.add(new Telepon("Terminal Rajabasa","0721706239"));
        list.add(new Telepon("Sriwijaya Air","0721268218"));
        list.add(new Telepon("Garuda Indonesia","07217697250"));
        list.add(new Telepon("Lion Air","08041778899"));
        list.add(new Telepon("Lion Air","02163798000"));
        list.add(new Telepon("LBH Bandar Lampung","07217478795"));
        list.add(new Telepon("Pelabuhan Bakauheni","0721331032 "));
        list.add(new Telepon("Pelabuhan Kota Agung","072121924"));
        list.add(new Telepon("Pelabuhan Panjang","072131149"));
        list.add(new Telepon("Pelabuhan Panjang","072133221"));
        list.add(new Telepon("Pelabuhan Panjang","0721342799"));
        list.add(new Telepon("Ombudsman ","0721251373"));
        list.add(new Telepon("Dirpolair","072131310"));
        list.add(new Telepon("ULPK BBPOM","0721254888"));

        final RecyclerViewAdapter adapter = new RecyclerViewAdapter(getApplicationContext(), list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.CALL_PHONE}, CALL_PHONE_REQUEST_CODE);
        }

        svCari = findViewById(R.id.svCari);
        svCari.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    private boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

}
