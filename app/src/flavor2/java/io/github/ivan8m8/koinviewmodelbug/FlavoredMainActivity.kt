package io.github.ivan8m8.koinviewmodelbug

class FlavoredMainActivity : MainActivity() {

    override fun displayContainerFragment() {
        super.displayContainerFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, FlavoredContainerFragment.newInstance("Flavor2"))
            .commitNow()
    }
}