package com.dmd.rxjavamvvmkotlin

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.dmd.rxjavamvvmkotlin.adapter.UserAdapter
import com.dmd.rxjavamvvmkotlin.databinding.ActivityMainBinding
import com.dmd.rxjavamvvmkotlin.util.ImageUtil
import com.dmd.rxjavamvvmkotlin.util.IntentUtil
import com.dmd.rxjavamvvmkotlin.util.NetworkUtil
import com.dmd.rxjavamvvmkotlin.util.PreferencesUtil
import com.dmd.rxjavamvvmkotlin.vm.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var networkUtil: NetworkUtil

    @Inject
    lateinit var preferencesUtil: PreferencesUtil

    @Inject
    lateinit var imageUtil: ImageUtil


    @Inject
    lateinit var intentUtil: IntentUtil

    private lateinit var binding: ActivityMainBinding

    private val viewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //If internet available then directly connected to viewModel
        if(networkUtil.isInternetAvailable(context = applicationContext)){
            binding.lifecycleOwner = this
            binding.userViewModel = viewModel
            binding.activitySrlMain.setOnRefreshListener { viewModel.refreshData() }
            setupObservers()
        } else { //otherwise get data from shared prefs
            val offlineData = preferencesUtil.retrieveObject(applicationContext)
            if (binding.rvActivityMain.adapter == null){
                val userAdapter = UserAdapter()
                binding.rvActivityMain.adapter = userAdapter
            }

            offlineData.let {
                (binding.rvActivityMain.adapter as UserAdapter).updateList(it)
            }
        }

        setContentView(binding.root)
    }

    private fun setupObservers(){
        viewModel.dataError.observe(this, { error ->
            error.let {
                if(it) {
                    binding.activityErrorMain.visibility = View.VISIBLE
                } else {
                    binding.activityErrorMain.visibility = View.GONE
                }
            }
        })
        viewModel.dataLoading.observe(this, { loading ->
            loading.let {
                if (it) {
                    binding.activityLoadingMain.visibility = View.VISIBLE
                    binding.rvActivityMain.visibility = View.GONE
                    binding.activityErrorMain.visibility = View.GONE
                } else {
                    binding.activityLoadingMain.visibility = View.GONE
                }
            }
        })

        viewModel.dataSuccess.observe(this, { success ->
            success?.let {
                preferencesUtil.putObject(applicationContext, viewModel.responseUsers.value!!.data)
                binding.rvActivityMain.visibility = View.VISIBLE
                binding.activitySrlMain.isRefreshing = false
            }
        })
    }

}