package com.thanhnvdn34.uthusapp.presentation.extension

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import androidx.fragment.app.DialogFragment

class ProgressDialogFragment : DialogFragment() {
    companion object {
        const val TAG = "TAG_PROGRESS_DIALOG"

        fun newInstance() = ProgressDialogFragment()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return Dialog(requireContext()).apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            window?.apply {
//                setBackgroundDrawable()
                setDimAmount(0.2f)
            }
//            setContentView(R.layout.fragment_dialog_loading)
            setCanceledOnTouchOutside(false)
            isCancelable = false
        }
    }
}