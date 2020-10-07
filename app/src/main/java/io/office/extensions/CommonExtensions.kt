package io.office.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> Fragment.subscribe(liveData: LiveData<T>, block: (T) -> Unit) {
    liveData.observe(this.viewLifecycleOwner, Observer(block))
}