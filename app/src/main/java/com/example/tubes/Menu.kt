package com.example.tubes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.ads.mediationtestsuite.activities.HomeActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Menu : AppCompatActivity() {
    private val homeFragment = HomeFragment()
    private val profileFragment = AkunFragment()
    private val sukucadangFragment = SukuCadangFragment()
    private val reservasiFragment = ReservasiFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        replaceFragment(homeFragment)
        val bottom: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottom.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> replaceFragment(homeFragment)
                R.id.ic_user->replaceFragment(profileFragment)
                R.id.ic_build->replaceFragment(sukucadangFragment)
                R.id.ic_assignment->replaceFragment(reservasiFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }

    private fun logout(){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this@Menu)
        builder.setTitle("Log Out")
        builder.setMessage("Are you sure want to exit?")
            .setPositiveButton("Yes"){ dialog, which ->
                finishAndRemoveTask()
            }
            .show()
    }
}