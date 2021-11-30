package com.android.shaadicard.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.domain.utils.Resource
import com.android.shaadicard.R
import com.android.shaadicard.adapter.UserAdapter
import com.android.shaadicard.databinding.ActivityMainBinding
import com.android.shaadicard.utils.hide
import com.android.shaadicard.utils.show
import com.android.shaadicard.vm.MainViewModel
import com.android.shaadicard.vm.ViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelFactory
    @Inject
    lateinit var userAdapter: UserAdapter

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
        lifecycle.addObserver(viewModel)

        userAdapter.setOnItemClickListener { i, s ->
            viewModel.updateUser(i, s)
        }

        initRecyclerView()
        viewUser()
    }

    private fun viewUser() {
        viewModel.getSavedUsers().observe(this@MainActivity, {
            Timber.d(it.size.toString())
            if (it.isNotEmpty()) {
                Timber.d(it.toString())
                userAdapter.differ.submitList(it)
                binding.recyclerView.show()
                binding.textViewNoData.hide()
            } else {
                binding.recyclerView.hide()
                binding.textViewNoData.show()
            }
        })
    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

    }
}