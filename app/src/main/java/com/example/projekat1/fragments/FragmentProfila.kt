package com.example.projekat1.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.projekat1.R
import com.example.projekat1.activities.IzmenaActivity
import com.example.projekat1.activities.LogInScreenActivity
import com.example.projekat1.model.Konstants
import com.example.projekat1.model.User
import kotlinx.android.synthetic.main.fragment_profila.*

class FragmentProfila : Fragment(R.layout.fragment_profila){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user : User = activity?.intent?.getParcelableExtra(Konstants.USER) as User
        imePacijenta.text = user.ime
        prezimePacijenta.text = user.prezime
        imeBolnice.text = user.bolnica
        val userSame = User(imePacijenta.text.toString(),prezimePacijenta.text.toString(),imeBolnice.text.toString())

        btnOdjavi.setOnClickListener {
            val editor = activity?.getPreferences(Context.MODE_PRIVATE)?.edit()
            editor?.clear()?.commit()
            startActivity(Intent(activity, LogInScreenActivity::class.java))
            activity?.finish()
        }

        btnIzmeni.setOnClickListener {
            val intent = Intent(activity,IzmenaActivity::class.java)
            intent.putExtra(Konstants.USER,userSame)
            startActivity(intent)
            activity?.finish()
        }

    }

}