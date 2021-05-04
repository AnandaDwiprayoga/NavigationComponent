package com.pasukanlangit.id.navigationcomponents

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.pasukanlangit.id.navigationcomponents.databinding.FragmentSpecifyAmountBinding
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import java.math.BigDecimal

class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController
    private lateinit var binding: FragmentSpecifyAmountBinding
    private var recipient: String ?= ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments?.getString("recipient")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpecifyAmountBinding.inflate(layoutInflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        binding.recipient.text = "Sending money to $recipient"

        binding.sendBtn.setOnClickListener(this)
        binding.cancelBtn.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            binding.sendBtn.id -> {
                if(!TextUtils.isEmpty(binding.inputAmount.text)){
                    val amount = Money(BigDecimal(input_amount.text.toString()))
                    val bundle = bundleOf(
                        "recipient" to recipient,
                        "amount" to amount
                    )
                    navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment, bundle)
                }
            }
            binding.cancelBtn.id -> activity?.onBackPressed()
        }
    }

}