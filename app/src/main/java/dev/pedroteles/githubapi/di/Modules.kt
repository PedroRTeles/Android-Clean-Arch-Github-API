package dev.pedroteles.githubapi.di

import dev.pedroteles.githubapi.app.search.viewmodel.SearchViewModel
import org.koin.dsl.module.module

val applicationModules = module(override = true) {
    factory { SearchViewModel() }
}