package com.prod.nets

data class SendRequest(val isUpdate: Boolean, val title: String, val oldTitle: String?, val content: String, val oldContent: String?)
