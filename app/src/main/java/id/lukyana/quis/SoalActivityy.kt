package id.lukyana.quis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup

class SoalActivityy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soal_activityy)

        val rg_kamu: RadioGroup = findViewById(R.id.rg_soal1)
        val rg_utdi: RadioGroup = findViewById(R.id.rg_soal2)
        val btn: Button = findViewById(R.id.selesai)

        btn.setOnClickListener {
            if (rg_kamu.checkedRadioButtonId > 0 && rg_utdi.checkedRadioButtonId > 0){
                var nilai = ""
                when (rg_kamu.checkedRadioButtonId){
                    R.id.rb_they -> nilai = "0"
                    R.id.rb_we -> nilai = "0"
                    R.id.rb_you -> nilai = "1"
                }

                var kampus =""
                when (rg_utdi.checkedRadioButtonId){
                    R.id.rb_uksw -> kampus = "0"
                    R.id.rb_utdi -> kampus = "1"
                    R.id.rb_akakom -> kampus ="0"
                }

                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_KAMU, nilai)
                resultIntent.putExtra(EXTRA_KAMPUS, kampus)
                setResult(CODE, resultIntent)
                finish()
            }
        }
    }

    companion object{
        const val EXTRA_KAMU = "kamu"
        const val EXTRA_KAMPUS = "kampus"
        const val CODE = 100
    }
}