package com.dmd.rxjavamvvmkotlin.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import java.io.ByteArrayOutputStream


class ImageUtil {

    fun decodeImage(base64Value: String): Bitmap {
        val imageByteArray = Base64.decode(base64Value, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(imageByteArray, 0, imageByteArray.size)
    }

    fun encodeImage(drawable: Bitmap): String {
        var valueToReturn: String
        drawable.let {
            val byteArrayOutputStream = ByteArrayOutputStream()
            drawable.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)
            valueToReturn = byteArrayOutputStream.toString()
        }
        return valueToReturn
    }
}