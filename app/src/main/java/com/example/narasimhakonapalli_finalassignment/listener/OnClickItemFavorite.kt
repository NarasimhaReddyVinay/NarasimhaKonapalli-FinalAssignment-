package com.example.narasimhakonapalli_finalassignment.listener

import com.example.narasimhakonapalli_finalassignment.model.favorite.FavoriteEntity

interface OnClickItemFavorite {
    fun onClick(favoriteEntity: FavoriteEntity)
    fun onClickFav(favoriteEntity: FavoriteEntity)
}