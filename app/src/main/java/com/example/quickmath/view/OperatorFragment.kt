package com.example.quickmath.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.quickmath.R
import com.example.quickmath.ui.theme.QuickMathTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OperatorFragment : Fragment() {
    val input by lazy { arguments?.getString("numb1") }
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
                val contextForToast = LocalContext.current.applicationContext

                QuickMathTheme {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        Box(modifier = Modifier.padding(2.dp)
                            .height(200.dp),
                        contentAlignment = Alignment.Center) {
                            Column() {
                                var operator = ""
                                val listItems = arrayOf("+", "-", "x", "÷")

                                var selectedItem by remember {
                                    mutableStateOf(listItems[0])
                                }

                                var expanded by remember {
                                    mutableStateOf(false)
                                }

                                Text(text = "Choose Operation Below")
                                ExposedDropdownMenuBox(
                                    expanded = expanded,
                                    onExpandedChange = {
                                        expanded = !expanded
                                    }
                                ) {
                                    TextField(
                                        value = selectedItem,
                                        onValueChange = {},
                                        readOnly = true,
                                        label = { Text(text = "Label") },
                                        trailingIcon = {
                                            ExposedDropdownMenuDefaults.TrailingIcon(
                                                expanded = expanded
                                            )
                                        },
                                        colors = ExposedDropdownMenuDefaults.textFieldColors()
                                    )
                                    // menu
                                    ExposedDropdownMenu(
                                        expanded = expanded,
                                        onDismissRequest = { expanded = false }
                                    ) {
                                        listItems.forEach { selectedOption ->
                                            // menu item

                                            DropdownMenuItem(onClick = {
                                                expanded = true
                                                selectedItem = selectedOption
                                                when (selectedOption) {
                                                    "+" -> {
                                                        println(" Addition selected")
                                                        operator = "+"
//                                                        val args: Bundle = bundleOf(
//                                                            "numb1" to input,
//                                                            "operator" to "+",
//                                                        )
//                                                        findNavController().navigate(
//                                                            R.id.operatorFragment,
//                                                            args
//                                                        )

                                                    }
                                                    "-" -> {
                                                        operator = "-"
//                                                        println(" Subtraction selected")
//                                                        val args: Bundle = bundleOf(
//                                                            "numb1" to input,
//                                                            "operator" to "-"
//                                                        )
//                                                        findNavController().navigate(
//                                                            R.id.operatorFragment,
//                                                            args
//                                                        )
                                                    }
                                                    "x" -> {
                                                        operator="*"
                                                    }
                                                    "÷" -> {
                                                        operator="/"
                                                    }
                                                }
                                                Toast.makeText(
                                                    contextForToast,
                                                    selectedOption,
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                                expanded = false
                                            }, text = {Text(text = selectedOption)})
//                                        Text(text = selectedOption)
                                        }
                                    }
                                }
                                Row() {
                                    Button(onClick = {
                                        val args: Bundle = bundleOf("numb1" to input, "operator" to "+")
                                        findNavController().navigate(R.id.secondInputFragment, args)
                                    }) {
                                        Text(text = "+")
                                    }
                                    Button(onClick = {
                                        val args: Bundle = bundleOf("numb1" to input, "operator" to "-")
                                        findNavController().navigate(R.id.secondInputFragment, args)
                                    }) {
                                        Text(text = "-")
                                    }
                                    Button(onClick = {
                                        val args: Bundle = bundleOf("numb1" to input,"operator" to "*")
                                        findNavController().navigate(R.id.secondInputFragment, args)
                                    }) {
                                        Text(text = "x")
                                    }
                                    Button(onClick = {
                                        val args: Bundle = bundleOf("numb1" to input, "operator" to "/")
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


