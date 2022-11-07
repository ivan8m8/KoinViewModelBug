package io.github.ivan8m8.koinviewmodelbug

import android.os.Handler
import android.os.Looper
import androidx.core.os.bundleOf
import androidx.core.os.postDelayed

class FlavoredContainerFragment : ContainerFragment() {

    override fun displayFragments() {
        super.displayFragments()
        Handler(Looper.getMainLooper()).postDelayed(2000) {
            childFragmentManager
                .beginTransaction()
                .replace(R.id.container2, FlavoredFragment.newInstance("Flavor2"))
                .commitNow()
        }
    }

    companion object {
        const val KEY = "key"
        fun newInstance(param: String) = FlavoredContainerFragment().apply {
            arguments = bundleOf(KEY to param)
        }
    }
}