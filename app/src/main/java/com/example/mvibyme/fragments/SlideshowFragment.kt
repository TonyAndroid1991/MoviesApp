package com.example.mvibyme.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvibyme.App
import com.example.mvibyme.R
import com.example.mvibyme.modelRequest.Result
import com.example.mvibyme.recyclerview.SlideShowAdapter
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers.io
import kotlinx.android.synthetic.main.fragment_slideshow.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 * Use the [SlideshowFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SlideshowFragment : Fragment() {

    @Inject
    lateinit var result: Flowable<ArrayList<Result>>

    var topList: ArrayList<Result> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as App).getComponent().inject(this)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  inflater.inflate(R.layout.fragment_slideshow, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadRecycler()
    }

    fun loadRecycler() {
        result.subscribeOn(io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { results ->

                for ((i, value) in results.withIndex()) {
                    if (i < 10) {
                        topList.add(results[i])
                    }
                }

                slideshow_recycler.apply {
                    layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                    adapter = SlideShowAdapter(topList)

                }
            }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SlideshowFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}

