package com.example.e_comerceApp.ui.binding_adapters

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import java.lang.Error


@BindingAdapter("error_validate")
fun setErrorToTextInputLayout(textInputLayout: TextInputLayout, error: String?) {
    textInputLayout.error = error
}