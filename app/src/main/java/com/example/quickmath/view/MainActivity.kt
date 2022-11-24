package com.example.quickmath.view

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.quickmath.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main activity entry point.
 *
 * @constructor Create empty Main activity
 */
@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
