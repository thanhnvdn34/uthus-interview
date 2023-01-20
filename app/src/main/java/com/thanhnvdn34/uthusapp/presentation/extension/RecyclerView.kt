package com.thanhnvdn34.uthusapp.presentation.extension

import androidx.recyclerview.widget.LinearLayoutManager

fun LinearLayoutManager.loadMoreListener(onLoadMore: () -> Unit) {
    val lastVisibleItemPosition = this.findLastVisibleItemPosition()
    val totalItem = this.itemCount
    val isThresholdReached =
        (lastVisibleItemPosition + 5) > totalItem
    if (isThresholdReached) {
        onLoadMore.invoke()
    }
}