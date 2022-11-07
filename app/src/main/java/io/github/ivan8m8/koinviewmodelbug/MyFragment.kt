package io.github.ivan8m8.koinviewmodelbug

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import io.github.ivan8m8.koinviewmodelbug.databinding.FragmentMyBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MyFragment : Fragment() {

    private var _binding: FragmentMyBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: MyViewModel by viewModel(named(Constants.MY_VIEW_MODEL)) {
        parametersOf(requireArguments().getString(KEY)!!)
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