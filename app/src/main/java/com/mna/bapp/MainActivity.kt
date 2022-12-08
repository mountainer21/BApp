package com.mna.bapp

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.mna.bapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var timer: CountDownTimer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            button.setOnClickListener {
startCountDownTimer(4000)
                binding.button.text = "STOP"
            }

        }
    }

    private fun startCountDownTimer(timeMills: Long) {
        timer?.cancel()
        timer = object : CountDownTimer(timeMills, 1) {
            override fun onTick(timeM: Long) {
                binding.textView.text = "ВДОХ"
          binding.viewTimer.text = timeM.toString()
                binding.apply {
                    button.setOnClickListener {
                        binding.viewTimer.text = "0"
                        binding.textView.text = "ВДОХ"
                        timer?.cancel()
                        binding.button.text = "START"
                             binding.apply {
                                 button.setOnClickListener {
                                     startCountDownTimer(4000)
                                     binding.button.text = "STOP"
                            }
                        }
                    }
                }
            }

            override fun onFinish() {
                binding.viewTimer.text = "0"
                startCountDownTimer2(7000)
            }

        }.start()
    }


private fun startCountDownTimer2(timeMills: Long) {
    timer?.cancel()
    timer = object : CountDownTimer(timeMills, 1) {
        override fun onTick(timeM: Long) {
            binding.textView.text = "СТОП"
            binding.viewTimer.text = timeM.toString()
        }

        override fun onFinish() {
            binding.viewTimer.text = "0"
            startCountDownTimer3(8000)
        }

    }.start()
}
    private fun startCountDownTimer3(timeMills: Long) {
        timer?.cancel()
        timer = object : CountDownTimer(timeMills, 1) {
            override fun onTick(timeM: Long) {
                binding.textView.text = "ВЫДОХ"
                binding.viewTimer.text = timeM.toString()
            }
            override fun onFinish() {
                binding.viewTimer.text = "0"
                startCountDownTimer(4000)
            }
        }.start()
    }
}
