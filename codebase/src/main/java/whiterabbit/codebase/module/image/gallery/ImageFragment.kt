package com.whiterabbit.base.module.image.gallery

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import whiterabbit.codebase.ui.fragment.WrgFragment
import whiterabbit.com.codebase.R
import whiterabbit.com.codebase.R.id.imageView
import whiterabbit.com.codebase.R.id.progressBar
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 *
 */
class ImageFragment : WrgFragment(), Callback {

    companion object {
     fun  newInstance(imageUrl:String): ImageFragment {
         val fragment = ImageFragment()
         val arguments = Bundle()
         arguments.putString(EXTRA_IMAGE_URL, imageUrl)
         fragment.arguments = arguments
         return fragment
     }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun initUi() {

    }

    override fun registerUiEvents() {

    }

    override fun setData() {
        imageView.setImageBitmap(null)
        Picasso.get()
                .load(arguments?.getString(EXTRA_IMAGE_URL))
                .into(imageView, this)
    }

    override fun onSuccess() {
        progressBar?.visibility = View.GONE
    }

    override fun onError(e: Exception?) {
        progressBar?.visibility = View.GONE
    }

}
