package com.example.loveraparcialapps1.ui.pokemon

import androidx.lifecycle.ViewModel
import com.example.loveraparcialapps1.data.model.Pokemon
import com.example.loveraparcialapps1.data.repository.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PokemonViewModel : ViewModel() {

    private val repository = PokemonRepository()

    private val _pokemons = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemons: StateFlow<List<Pokemon>> = _pokemons.asStateFlow()

    init {
        loadPokemons()
    }

    private fun loadPokemons() {
        _pokemons.value = repository.getPokemons()
    }
}