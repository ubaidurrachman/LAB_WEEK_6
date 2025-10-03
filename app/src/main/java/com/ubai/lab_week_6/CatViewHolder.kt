package com.ubai.lab_week_6
import com.ubai.lab_week_6.model.CatModel
import com.ubai.lab_week_6.model.Gender
import com.ubai.lab_week_6.model.CatBreed
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

private const val FEMALE_SYMBOL = "\u2640"
private const val MALE_SYMBOL = "\u2642"
private const val UNKNOWN_SYMBOL = "?"

class CatViewHolder(
    private val containerView: View,
    private val imageLoader: ImageLoader
) : RecyclerView.ViewHolder(containerView) {

    private val catBiographyView: TextView by lazy { containerView.findViewById(R.id.cat_biography) }
    private val catBreedView: TextView by lazy { containerView.findViewById(R.id.cat_breed) }
    private val catGenderView: TextView by lazy { containerView.findViewById(R.id.cat_gender) }
    private val catNameView: TextView by lazy { containerView.findViewById(R.id.cat_name) }
    private val catPhotoView: ImageView by lazy { containerView.findViewById(R.id.cat_photo) }

    fun bindData(cat: CatModel) {
        imageLoader.loadImage(cat.imageUrl, catPhotoView)
        catNameView.text = cat.name
        catBreedView.text = when (cat.breed) {
            CatBreed.AmericanCurl -> "American Curl"
            CatBreed.BalineseJavanese -> "Balinese-Javanese"
            CatBreed.ExoticShorthair -> "Exotic Shorthair"
            else -> "Unknown"
        }
        catBiographyView.text = cat.biography
        catGenderView.text = when (cat.gender) {
            Gender.Female -> FEMALE_SYMBOL
            Gender.Male -> MALE_SYMBOL
            else -> UNKNOWN_SYMBOL
        }
    }
}