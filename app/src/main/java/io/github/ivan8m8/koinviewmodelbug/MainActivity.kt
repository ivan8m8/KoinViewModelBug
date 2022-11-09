package io.github.ivan8m8.koinviewmodelbug

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import io.github.ivan8m8.koinviewmodelbug.databinding.ActivityMainBinding

@AndroidEntryPoint
open class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null)
            displayContainerFragment()
    }

    @CallSuper
    protected open fun displayContainerFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, ContainerFragment.newInstance("Main"))
            .commitNow()
    }
}