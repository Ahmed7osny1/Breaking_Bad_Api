package com.sriyank.breakingbad.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.sriyank.breakingbad.R

@Suppress("DEPRECATION")
class CharacterImageFragment : Fragment() {
    private val args: CharacterImageFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_character_image,container,false)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val ivCharacterImageSingle = requireActivity().findViewById<ImageView>(R.id.ivCharacterImageSingle)
        Glide.with(requireContext()).load(args.image).centerCrop().into(ivCharacterImageSingle)

    }
}