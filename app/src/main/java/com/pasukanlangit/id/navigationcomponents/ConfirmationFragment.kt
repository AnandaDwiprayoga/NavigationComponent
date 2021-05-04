package com.pasukanlangit.id.navigationcomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pasukanlangit.id.navigationcomponents.databinding.FragmentConfirmationBinding

class ConfirmationFragment : Fragment() {

    private lateinit var binding: FragmentConfirmationBinding
    private var recipient : String ?= null
    private var amount: Money ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments?.getString("recipient")
        amount = arguments?.getParcelable("amount")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConfirmationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.confirmationMessage.text = "You sent ${amount?.amount} to $recipient"
    }

}