package com.bsoft.weathercaseapp.ui.details

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bsoft.weathercaseapp.R
import com.bsoft.weathercaseapp.data.network.DetailsApi
import com.bsoft.weathercaseapp.data.network.HomeApi
import com.bsoft.weathercaseapp.data.repository.DetailsRepository
import com.bsoft.weathercaseapp.data.repository.HomeRepository
import com.bsoft.weathercaseapp.ui.home.HomeListAdapter
import kotlinx.android.synthetic.main.details_fragment.*
import kotlinx.android.synthetic.main.home_fragment.*

class DetailsFragment : Fragment(){

    companion object {
        fun newInstance() = DetailsFragment()
    }

    private lateinit var factory: DetailsViewModelFactory
    private lateinit var viewModel: DetailsViewModel
    val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = DetailsApi()
        val repository = DetailsRepository(api)
        factory = DetailsViewModelFactory(repository)

        viewModel = ViewModelProviders.of(requireActivity(), factory).get(DetailsViewModel::class.java)
        viewModel.getList("https://www.metaweather.com/api/location/" + args.woeid )
        viewModel.items.observe(viewLifecycleOwner, Observer { items ->
            list_daysList.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(false)
                it.adapter = DayListAdapter(items)

                details_day_degree.text = viewModel.dayDegree.toString()
                details_night_degree.text = "/"+ viewModel.nightDegree +"°C"
                details_state.text = viewModel.state
            }
        })

        viewModel.showLoadingAnim.observe(viewLifecycleOwner, Observer {
            if(it) {
                details_loading.visibility = View.VISIBLE
                details_day_degree.visibility = View.INVISIBLE
                details_night_degree.visibility = View.INVISIBLE
                details_state.visibility = View.INVISIBLE
                list_daysList.visibility = View.INVISIBLE
            }
            else {
                details_loading.visibility = View.INVISIBLE
                details_day_degree.visibility = View.VISIBLE
                details_night_degree.visibility = View.VISIBLE
                details_state.visibility = View.VISIBLE
                list_daysList.visibility = View.VISIBLE
            }
        })
    }
}