package com.example.quickmath.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.quickmath.R
import com.example.quickmath.ui.theme.QuickMathTheme
import com.example.quickmath.viewmodel.MathViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Result fragment
 *
 * @constructor Create empty Result fragment
 */
@AndroidEntryPoint
class ResultFragment : Fragment() {
    val viewModel by activityViewModels<MathViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        // requireActivity()
        return ComposeView(requireActivity()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {

                QuickMathTheme {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        Box(
                            modifier = Modifier.padding(2.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column() {
                                Text(text = context.getString(R.string.resultText), modifier = Modifier.padding(vertical = 20.dp))
                                val result = viewModel.result.collectAsState().value
                                Text(text = "= $result")
                                Row() {
                                    Button(onClick = {
                                        findNavController().popBackStack(R.id.dashboardFragment, true)
                                    }) {
                                        Text(text = "Home")
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

