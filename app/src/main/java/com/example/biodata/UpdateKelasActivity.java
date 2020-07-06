paket  com.riya9977.biodatasiswa.activities ;

        impor  android.os.Bundle ;
        impor  android.view.MenuItem ;
        impor  android.widget.Button ;
        impor  android.widget.EditText ;
        impor  android.widget.Toast ;

        impor  androidx.appcompat.app.AppCompatActivity ;
        impor  androidx.appcompat.widget.Toolbar ;

import  com.riya9977.biodatasiswa.R ;
import  com.riya9977.biodatasiswa.database.Constant ;
import  com.riya9977.biodatasiswa.database.SiswaDatabase ;
import  com.riya9977.biodatasiswa.model.KelasModel ;

import  butterknife.BindView ;
impor  butterknife.ButterKnife ;
        impor  butterknife.OnClick ;

        UpdateKelasActivity kelas  publik memperluas AppCompatActivity {

@BindView ( R . Id . EdtNamaKelas)
    EditText edtNamaKelas;
@BindView ( R . Id . EdtNamaWali)
    EditText edtNamaWali;
@BindView ( R . Id . BtnSimpan)
    Tombol btnSimpan;

            Bundel bundel;
            SiswaDatabase SiswaDatabase;
            int id_kelas;
            String nama_kelas, nama_wali;

@Mengesampingkan
     void  onCreate yang dilindungi ( Bundle  SavedInstanceState ) {
             super . onCreate (SavedInstanceState);
             setContentView ( R . tata letak . activity_update_kelas);
             ButterKnife . mengikat ( ini );

             Toolbar tbDetailDokter = findViewById ( R . Id . Toolbar);
             tbDetailDokter . setTitle ( " Perbarui Data " );
             setSupportActionBar (tbDetailDokter);
             menegaskan getSupportActionBar () ! =  null ;
             getSupportActionBar () . setDisplayHomeAsUpEnabled ( true );

             // Menangkap data dari aktivitas sebelumnya
             bundle = getIntent () . getExtras ();

             // Buat objek database
             siswaDatabase =  SiswaDatabase . createDatabase ( ini );

             // Menampilkan data sebelumnya ke layar
             showData ();
             }

private  void  showData () {
        // mengambil data di dalam bundel
        id_kelas = bundel . getInt ( Constant . KEY_ID_KELAS );
        nama_kelas = bundel . getString ( Konstan . KEY_NAMA_KELAS );
        nama_wali = bundel . getString ( Konstan . KEY_NAMA_WALI );

        // Menampilkan ke layar
        edtNamaKelas . setText (nama_kelas);
        edtNamaWali . setText (nama_wali);
        }

@OnClick ( R . Id . BtnSimpan)
public  void  onViewClicked () {

        // pertimbangkan data
        getData ();

        // Mengirim data ke sqlite
        saveData ();

        Bersulang . makeText ( ini , " Berhasil di update " , Toast . LENGTH_SHORT ) . menunjukkan();
        selesai();
        }

private  void  getData () {
        // masukkan pengguna inputan dan dimasukkan ke dalam variabel
        nama_kelas = edtNamaKelas . getText () . toString ();
        nama_wali = edtNamaWali . getText () . toString ();
        }

private  void  saveData () {

        // Membuat objek kelasmodel
        KelasModel kelasModel =  baru  KelasModel ();

        // Memasukkan data ke kelasmodel
        kelasModel . setId_kelas (id_kelas);
        kelasModel . setNama_kelas (nama_kelas);
        kelasModel . setNama_wali (nama_wali);

        // melakukan operasi pembaruan untuk mengupdate data ke sqlite
        basis data siswa . kelasDao () . pembaruan (kelasModel);
        }

@Mengesampingkan
public  boolean  onOptionsItemSelected ( item MenuItem  ) {
        jika (item . getItemId () ==  android . R . id . rumah) {
        selesai();
        kembali  benar ;
        }
        kembali  super . onOptionsItemSelected (item);
        }
        }