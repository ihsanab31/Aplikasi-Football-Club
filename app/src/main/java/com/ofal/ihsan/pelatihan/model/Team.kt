package com.ofal.ihsan.pelatihan.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * on       : 04, September, 2018
 * ------------------------------
 * This class for item
 */
@Parcelize
data class Team (val name: String?, val image:Int?, val description: String?) : Parcelable
