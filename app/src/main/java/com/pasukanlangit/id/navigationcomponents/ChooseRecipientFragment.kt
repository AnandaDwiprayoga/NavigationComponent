package com.pasukanlangit.id.navigationcomponents

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.pasukanlangit.id.navigationcomponents.databinding.FragmentChooseRecipientBinding

class ChooseRecipientFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController
    private lateinit var binding: FragmentChooseRecipientBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChooseRecipientBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.nextBtn.setOnClickListener(this)
        binding.cancelBtn.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            binding.nextBtn.id -> {
                if(!TextUtils.isEmpty(binding.inputRecipient.text)){
                    val bundle = bundleOf("recipient" to binding.inputRecipient.text.toString())
                    navController.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment, bundle)
                }
            }
            binding.cancelBtn.id -> activity?.onBackPressed()
        }
    }

}