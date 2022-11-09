package io.github.ivan8m8.koinviewmodelbug

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.github.ivan8m8.koinviewmodelbug.databinding.FragmentFlavoredBinding

@AndroidEntryPoint
class FlavoredFragment: Fragment() {

    private var _binding: FragmentFlavoredBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: MyFlavoredViewModel by viewModels(
        ownerProducer = {
            requireParentFragment()
                .childFragmentManager
                .findFragmentByTag(MyFragment.TAG)!!
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFlavoredBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.childTextView.text = requireArguments().getString(KEY)!!
        viewModel.liveData.observe(viewLifecycleOwner) { text ->
            binding.childTextView2.text = text
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val KEY = "key"
        fun newInstance(param: String) = FlavoredFragment().apply {
            arguments = bundleOf(KEY to param)
        }
    }
}