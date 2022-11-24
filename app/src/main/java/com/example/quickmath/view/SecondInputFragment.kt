package com.example.quickmath.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SecondInputFragment : Fragment() {
    val input by lazy { arguments?.getString("numb1") }
    val operator by lazy { arguments?.getString("operator") }
    val viewModel by activityViewModels<MathViewModel>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("INPUT $input")
        println("OPERTOR $operator")

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
                            var inputB: String by remember {
                                mutableStateOf("")
                            }
                            Column() {
                                Text(text = "$input$operator")
                                TextField(value = inputB, onValueChange = { inputB = it })
                                Button(onClick = {
                                    println("input IS $input $operator AND INPUTB: $inputB")
                                     val args3:Bundle = bundleOf(
                                         "numb1" to input,
                                         "operator" to operator,
                                         "numb2" to inputB
                                     )
                                    lifecycleScope.launch { val result = viewModel.evaluateExpression("$input$operator$inputB")
                                    println(result)
                                    }
                                    findNavController().navigate(R.id.resultFragment, args3)
                                }) {
                                    Text(text = "Input second number")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

