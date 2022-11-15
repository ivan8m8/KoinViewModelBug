package io.github.ivan8m8.koinviewmodelbug

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import io.github.ivan8m8.koinviewmodelbug.dagger.ViewModelFactory
import io.github.ivan8m8.koinviewmodelbug.databinding.FragmentMyBinding
import javax.inject.Inject

class MyFragment : Fragment() {

    private var _binding: FragmentMyBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @Inject lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by viewModels<MyViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as MyApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textView.text = requireArguments().getString(KEY)!!
        viewModel.liveData.observe(viewLifecycleOwner) { text ->
            binding.textView2.text = text
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "tag"
        const val KEY = "key"
        fun newInstance(param: String) = MyFragment().apply {
            arguments = bundleOf(KEY to param)
        }
    }
}