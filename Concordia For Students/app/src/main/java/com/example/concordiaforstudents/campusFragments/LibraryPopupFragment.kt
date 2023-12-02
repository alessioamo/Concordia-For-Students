package com.example.concordiaforstudents.campusFragments

import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class LibraryPopupFragment(private val libraryName: String, private val occupancy: String) : DialogFragment() {

    private var onViewClickListener: (() -> Unit)? = null

    fun setOnViewClickListener(listener: () -> Unit) {
        onViewClickListener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = AlertDialog.Builder(requireContext()).create()

        val title = TextView(requireContext())
        title.text = "Book a Room in $libraryName"
        title.textSize = 25f // Adjust the font size as needed
        title.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
        title.setPadding(0, 50, 0, 0) // Adjust padding as needed

        dialog.setCustomTitle(title)
        // dialog.setMessage("Occupancy: $occupancy")

        dialog.setButton(Dialog.BUTTON_POSITIVE, "Close") { _, _ ->
            dialog.dismiss()
        }

        dialog.setButton(Dialog.BUTTON_NEUTRAL, "View Availabilities") { _, _ ->
            onViewClickListener?.invoke()
        }

        return dialog
    }
}
