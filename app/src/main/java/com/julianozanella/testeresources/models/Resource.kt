package com.julianozanella.testeresources.models

import com.google.gson.annotations.SerializedName

class Resource(
    val module_id: String? = null,
    val updated_at: Any? = null,
    val created_at: Any? = null,
    val resource_id: String? = null,
    val language_id: String? = null,
    @SerializedName("value") val valueString: String? = null,
    val user_modified: Any? = null
){
    override fun toString(): String {
        return "Resource(module_id=$module_id, updated_at=$updated_at, created_at=$created_at, resource_id=$resource_id, language_id=$language_id, valueString=$valueString, user_modified=$user_modified)"
    }
}