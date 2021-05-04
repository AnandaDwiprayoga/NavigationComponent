package com.pasukanlangit.id.navigationcomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.pasukanlangit.id.navigationcomponents.databinding.FragmentMainBinding

class MainFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.viewTransactionsBtn.setOnClickListener(this)
        binding.sendMoneyBtn.setOnClickListener(this)
        binding.viewBalanceBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v?.let { view ->
            when(view.id){
                binding.viewTransactionsBtn.id -> navController.navigate(R.id.action_mainFragment_to_viewTransactionFragment)
                binding.viewBalanceBtn.id -> navController.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
                binding.sendMoneyBtn.id -> navController.navigate(R.id.action_mainFragment_to_chooseRecipientFragment)
            }
        }
    }
}