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
    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout

    private lateinit var myMyFragmentStateAdapter: MyFragmentStateAdapter
    private lateinit var fragments: ArrayList<Fragment>
    private val tabTitles = arrayOf("Home", "Discover", "Profile") // Tab titles
    private lateinit var tabConfigurationStrategy: TabConfigurationStrategy
    private lateinit var tabLayoutMediator: TabLayoutMediator


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val toolbar = findViewById<Toolbar>(R.id.tool_bar)
//        setSupportActionBar(toolbar)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

//        viewPager2 = findViewById(R.id.viewpager)
//        tabLayout = findViewById(R.id.tab)

        fragmentHome = FragmentHome()
        fragmentDiscover = FragmentDiscover()
        fragmentProfile = FragmentProfile()

        fragments = ArrayList()
        fragments.add(fragmentHome)
        fragments.add(fragmentDiscover)
        fragments.add(fragmentProfile)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setCurrentFragment(fragmentHome)
                R.id.discover -> setCurrentFragment(fragmentDiscover)
                R.id.profile -> setCurrentFragment(fragmentProfile)
            }
            true
        }

//        myMyFragmentStateAdapter = MyFragmentStateAdapter(this, fragments)
//        viewPager2.adapter = myMyFragmentStateAdapter
//
//        tabConfigurationStrategy = TabConfigurationStrategy { tab: TabLayout.Tab, position: Int ->
//            tab.text = tabTitles[position]
//        }
//        tabLayoutMediator = TabLayoutMediator(tabLayout, viewPager2, tabConfigurationStrategy)
//        tabLayoutMediator.attach()
//    }
    }
    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}