package com.sriyank.breakingbad.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.sriyank.breakingbad.R
import com.sriyank.breakingbad.ui.utils.CharacterListAdapter

@Suppress("DEPRECATION")
class CharacterListFragment : Fragment() {

    private val characterListViewModel: CharacterListViewModel
    by viewModels {
        CharacterListViewModelFactory((requireActivity().application
                as BreakingBadApplication).characterRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_character_list, container, false)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val rvCharacterList = requireActivity().findViewById<RecyclerView>(R.id.rvCharacterList)
        val adapter = CharacterListAdapter { BreakingBadCharacter ->
            //TODO
            if (BreakingBadCharacter.img != null) {
                findNavController().navigate(
                    CharacterListFragmentDirections.actionCharacterListFragmentToCharacterImageFragment(
                        BreakingBadCharacter.img
                    )
                )
            }
        }
        rvCharacterList.adapter = adapter
        rvCharacterList.layoutManager =
            LinearLayoutManager(requireActivity(),RecyclerView.VERTICAL,false)
        characterListViewModel.characterList.observe(viewLifecycleOwner) { breakingbadCharacter ->
            adapter.submitList(breakingbadCharacter)
        }
        val refreshLayout = requireActivity().findViewById<SwipeRefreshLayout>(R.id.refreshLayout)
        refreshLayout.setOnRefreshListener {
            characterListViewModel.refreshDataFromRepository() // Refresh Data
            Toast.makeText(requireContext(), " Data Updated ", Toast.LENGTH_LONG).show()
            refreshLayout.isRefreshing = false
        }
    }
}