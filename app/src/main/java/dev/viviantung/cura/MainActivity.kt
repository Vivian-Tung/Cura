package dev.viviantung.cura

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import java.util.ArrayList
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView


// home discover profile calendar saved

class MainActivity : AppCompatActivity() {
    private lateinit var fragmentHome: FragmentHome
    private lateinit var fragmentDiscover: FragmentDiscover
    private lateinit var fragmentProfile: FragmentProfile
    private lateinit var fragmentCalendar: FragmentCalendar
    private lateinit var fragmentSaved: FragmentSaved
    private lateinit var fragments: ArrayList<Fragment>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        fragmentHome = FragmentHome()
        fragmentDiscover = FragmentDiscover()
        fragmentProfile = FragmentProfile()
        fragmentCalendar = FragmentCalendar()
        fragmentSaved = FragmentSaved()

        fragments = ArrayList()
        fragments.add(fragmentHome)
        fragments.add(fragmentDiscover)
        fragments.add(fragmentProfile)
        fragments.add(fragmentCalendar)
        fragments.add(fragmentSaved)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setCurrentFragment(fragmentHome)
                R.id.discover -> setCurrentFragment(fragmentDiscover)
                R.id.profile -> setCurrentFragment(fragmentProfile)
                R.id.calendar -> setCurrentFragment(fragmentCalendar)
                R.id.saved -> setCurrentFragment(fragmentSaved)
            }
            true
        }
    }
    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}