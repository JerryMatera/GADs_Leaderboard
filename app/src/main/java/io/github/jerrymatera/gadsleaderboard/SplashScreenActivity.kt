package io.github.jerrymatera.gadsleaderboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import io.github.jerrymatera.gadsleaderboard.ui.main.MainActivity

class SplashScreenActivity : AppCompatActivity() {

    private  val SPLASH_TIME = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME)
    }

}