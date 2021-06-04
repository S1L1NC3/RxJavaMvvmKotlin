package com.dmd.rxjavamvvmkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.dmd.rxjavamvvmkotlin.constants.Constants
import com.dmd.rxjavamvvmkotlin.databinding.ActivityDetailBinding
import com.dmd.rxjavamvvmkotlin.models.Data

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val myProg = intent.getSerializableExtra(Constants.EXTRA_KEY)
        binding.lifecycleOwner = this
        binding.user = myProg as Data?
        setContentView(binding.root)
    }
}