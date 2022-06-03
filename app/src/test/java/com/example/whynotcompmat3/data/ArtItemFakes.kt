package com.example.whynotcompmat3.data

import com.example.whynotcompmat3.data.domain.models.ArtItem

class ArtItemFakes {

    fun listOfThreeArtItems() : List<ArtItem> {
        return listOf(
            ArtItem(
                id = 1,
                title = "Mona Lisa",
                placeOfOrigin = "Italy",
                artistName = "da Vinci",
                styleTitle = "Renaissance",
                imageUrl = "https://i.picsum.photos/id/1011/5472/3648.jpg?hmac=Koo9845x2akkVzVFX3xxAc9BCkeGYA9VRVfLE4f0Zzk"
            ),
            ArtItem(
                id = 1,
                title = "Man with dog",
                placeOfOrigin = "UK",
                artistName = "John Smith",
                styleTitle = "Pop art",
                imageUrl = "https://i.picsum.photos/id/1012/3973/2639.jpg?hmac=s2eybz51lnKy2ZHkE2wsgc6S81fVD1W2NKYOSh8bzDc"
            ),
            ArtItem(
                id = 1,
                title = "Some stars",
                placeOfOrigin = "Iceland",
                artistName = "Huleesvonen",
                styleTitle = "Art is dead",
                imageUrl = "https://i.picsum.photos/id/1042/3456/5184.jpg?hmac=5xr8Veg2D_kEQQO6rvGj_Yk8s_N4iq3-eZ9_KclSXNQ"
            ),

        )
    }
}

//    var temporaryListOfArtTitles = listOf("Mona lisa", "Śmierć Ellenai", "Słoneczniki")