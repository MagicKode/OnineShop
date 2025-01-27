package ru.myapp.online_shop.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.myapp.online_shop.model.CategoryModel
import ru.myapp.online_shop.repository.MainRepository

class MainViewModel: ViewModel() {
    private val repository = MainRepository()

    val category: LiveData<MutableList<CategoryModel>> = repository.loadCategory()
}