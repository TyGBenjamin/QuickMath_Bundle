package com.example.quickmath.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.quickmath.R
import com.example.quickmath.ui.theme.QuickMathTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Operator fragment is where the user selects the operation they would like to proceed with.
 *
 * @constructor Create empty Operator fragment
 */
@AndroidEntryPoint
class OperatorFragment : Fragment() {
    val input by lazy { arguments?.getString("numb1") }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return ComposeView(requireActivity()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                QuickMathTheme {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .height(200.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column() {
                                Row() {
                                    Button(onClick = {
                                        val args: Bundle = bundleOf(
                                            context.getString(R.string.numb1) to input,
                                            context.getString(R.string.operator) to "+"
                                        )
                                        findNavController().navigate(R.id.secondInputFragment, args)
                                    }) {
                                        Text(text = "+")
                                    }
                                    Button(onClick = {
                                        val args: Bundle = bundleOf(
                                            context.getString(R.string.numb1) to input,
                                            context.getString(R.string.operator) to "-"
                                        )
                                        findNavController().navigate(R.id.secondInputFragment, args)
                                    }) {
                                        Text(text = "-")
                                    }
                                    Button(onClick = {
                                        val args: Bundle = bundleOf(
                                            context.getString(R.string.numb1) to input,
                                            context.getString(R.string.operator) to "*"
                                        )
                                        findNavController().navigate(R.id.secondInputFragment, args)
                                    }) {
                                        Text(text = "x")
                                    }
                                    Button(onClick = {
                                        val args: Bundle = bundleOf(
                                            context.getString(R.string.numb1) to input,
                                            context.getString(R.string.operator) to "/"
                                        )
                                        findNavController().navigate(R.id.secondInputFragment, args)
                                    }) {
                                        Text(text = "÷")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
