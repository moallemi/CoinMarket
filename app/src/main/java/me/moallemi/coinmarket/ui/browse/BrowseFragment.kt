package me.moallemi.coinmarket.ui.browse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_browse.*
import me.moallemi.coinmarket.R
import me.moallemi.coinmarket.domain.interactor.GetLatestUseCase
import javax.inject.Inject

class BrowseFragment : DaggerFragment() {

    lateinit var browseViewModel: BrowseViewModel
    private val adapter by lazy { BrowseAdapter() }

    @Inject
    lateinit var getLatestUseCase: GetLatestUseCase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_browse, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = adapter

        val browseViewModelFactory = BrowseViewModelFactory(getLatestUseCase)
        browseViewModel = ViewModelProviders.of(this, browseViewModelFactory).get(BrowseViewModel::class.java)
        browseViewModel.items.observe(this, Observer { items ->
            adapter.items = items
        })
        browseViewModel.error.observe(this, Observer { throwable ->
            Toast.makeText(requireContext(), throwable.toString(), Toast.LENGTH_LONG).show()
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        browseViewModel.load()
    }

}