package id.lukyana.quis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var hasilNilai: TextView

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == SoalActivityy.CODE && it.data != null){
                val data = it.data?.getStringExtra(SoalActivityy.EXTRA_KAMU)
                val hasilNilai1 = data
                val data2 = it.data?.getStringExtra(SoalActivityy.EXTRA_KAMPUS)
                val hasilNilai2 = data2
                val hasilAkhir = hasilNilai1.toString().toInt() + hasilNilai2.toString().toInt()
                val nilai =
                    if (hasilAkhir == 0){
                        "0"
                    }else if (hasilAkhir == 1){
                        "50"
                    }else{
                        "100"
                    }
                hasilNilai.text = nilai
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tbl: Button = findViewById(R.id.tombol)
        hasilNilai = findViewById(R.id.hasil)

        tbl.setOnClickListener {
            val i = Intent (this@MainActivity, SoalActivityy::class.java)
            resultLauncher.launch(i)
        }
    }
}