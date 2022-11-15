package io.github.ivan8m8.koinviewmodelbug

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import io.github.ivan8m8.koinviewmodelbug.databinding.FragmentContainerBinding

open class ContainerFragment : Fragment() {

    private var _binding: FragmentContainerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContainerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null)
            displayFragments()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @CallSuper
    protected open fun displayFragments() {
        childFragmentManager
            .beginTransaction()
            .replace(R.id.container1, MyFragment.newInstance("Flavor1"), MyFragment.TAG)
            .commitNow()
    }

    companion object {
        const val KEY = "key"
        fun newInstance(param: String) = ContainerFragment().apply {
            arguments = bundleOf(KEY to param)
        }
    }
}