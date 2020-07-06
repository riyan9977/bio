paket  com.riyan9977.biodatasiswa.activities ;

        impor  android.os.Bundle ;
        impor  android.view.MenuItem ;
        impor  android.widget.Button ;
        impor  android.widget.EditText ;
        impor  android.widget.Toast ;

        impor  androidx.appcompat.app.AppCompatActivity ;
        impor  androidx.appcompat.widget.Toolbar ;

import  com.riyan9977.biodatasiswa.R ;
import  com.riyan9977.biodatasiswa.database.SiswaDatabase ;
import  com.riyan9977.biodatasiswa.model.KelasModel ;

import  butterknife.BindView ;
impor  butterknife.ButterKnife ;
        impor  butterknife.OnClick ;

        kelas  publik TambahKelasActivity  memperluas  AppCompatActivity {

@BindView ( R . Id . EdtNamaKelas)
    EditText edtNamaKelas;
@BindView ( R . Id . EdtNamaWali)
    EditText edtNamaWali;
@BindView ( R . Id . BtnSimpan)
    Tombol btnSimpan;

            SiswaDatabase SiswaDatabase;
            String namaKelas, namaWali;

@Mengesampingkan
     void  onCreate yang dilindungi ( Bundle  SavedInstanceState ) {
             super . onCreate (SavedInstanceState);
             setContentView ( R . tata letak . activity_tambah_kelas);
             ButterKnife . mengikat ( ini );

             Toolbar tbDetailDokter = findViewById ( R . Id . Toolbar);
             tbDetailDokter . setTitle ( " Tambah Kelas " );
             setSupportActionBar (tbDetailDokter);
             menegaskan getSupportActionBar () ! =  null ;
             getSupportActionBar () . setDisplayHomeAsUpEnabled ( true );

             siswaDatabase =  SiswaDatabase . createDatabase ( ini );
             }

@OnClick ( R . Id . BtnSimpan)
public  void  onViewClicked () {

        getData ();

        saveData ();

        Hapus data();

        Bersulang . makeText ( ini , " Berhasil disimpan " , Toast . LENGTH_SHORT ) . menunjukkan();

        selesai();
        }

private  void  clearData () {
        edtNamaKelas . setText ( " " );
        edtNamaWali . setText ( " " );
        }

private  void  saveData () {

        // Membuat objek KelasModel untuk menyimpan data
        KelasModel kelasModel =  baru  KelasModel ();

        // Memasukkan data ke dalam KelasModel
        kelasModel . setNama_kelas (namaKelas);
        kelasModel . setNama_wali (namaWali);

        // Perintah untuk melakukan operasi Masukkan menggunakan siswaDatabase
        basis data siswa . kelasDao () . masukkan (kelasModel);
        }

private  void  getData () {
        namaKelas = edtNamaKelas . getText () . toString ();
        namaWali = edtNamaWali . getText () . toString ();
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
