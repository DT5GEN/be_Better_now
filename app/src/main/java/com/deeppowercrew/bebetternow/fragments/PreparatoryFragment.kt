package com.deeppowercrew.bebetternow.fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.deeppowercrew.bebetternow.databinding.PreparatoryFragmentBinding


/**
 * description fragment
 */
const val COUNT_DOWN_TIME = 16000L

class PreparatoryFragment : Fragment() {

    private lateinit var binding: PreparatoryFragmentBinding
    private lateinit var timer: CountDownTimer


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PreparatoryFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.preparatoryFragmentProgressBar.max = COUNT_DOWN_TIME.toInt()

    }

    private fun startTimer() = with(binding) {
        timer = object : CountDownTimer(COUNT_DOWN_TIME, 50) {
            override fun onTick(restTime: Long) {
                preparatoryFragmentProgressBar.progress = restTime.toInt()
            }

            override fun onFinish() {

            }

        }.start()
    }

    override fun onDetach() {
        super.onDetach()
        timer.cancel()
    }

    companion object {
        /**
        fdgd
         */

        @JvmStatic
        fun newInstance() = PreparatoryFragment()
    }
}