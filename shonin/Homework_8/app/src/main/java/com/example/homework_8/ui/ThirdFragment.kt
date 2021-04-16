package com.example.homework_8.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.DisplayMetrics
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_8.R
import com.example.homework_8.databinding.FragmentThirdBinding
import com.example.homework_8.ui.list.HumanItemAdapter
import com.example.homework_8.ui.list.SpacingItemDecoration
import com.example.homework_8.ui.model.Human
import com.example.homework_8.ui.viewmodel.ThirdViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThirdFragment : Fragment() {

    private lateinit var binding: FragmentThirdBinding
    private val viewModel by viewModels<ThirdViewModel>()
    private lateinit var adapter: HumanItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.list2.addItemDecoration(SpacingItemDecoration(dpToPx(8)))

        adapter = HumanItemAdapter(::go)
        viewModel.people.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.list2.adapter = adapter
        binding.list2.layoutManager = LinearLayoutManager(requireContext())
        viewModel.getPeople()

        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.searchPeople(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.god_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.del -> {
                viewModel.delDb()
                return true
            }
            R.id.add -> {
                viewModel.getPeople()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun go(item: Human) {
        val bundle = Bundle()
        bundle.putParcelable("arg", item)
        val navController = findNavController()
        navController.navigate(R.id.humanFragment, bundle)
    }

    fun dpToPx(dp: Int): Int {
        val displayMetrics: DisplayMetrics = this.getResources().getDisplayMetrics()
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
    }
}