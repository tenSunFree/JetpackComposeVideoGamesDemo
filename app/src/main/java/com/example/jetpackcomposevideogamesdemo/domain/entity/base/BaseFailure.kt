package com.example.jetpackcomposevideogamesdemo.domain.entity.base

sealed class BaseFailure {
    object ClientError: BaseFailure() {
        override fun toString(): String {
            return "Error from client"
        }
    }
    object ServerError: BaseFailure() {
        override fun toString(): String {
            return "Error from server"
        }
    }
    object NetworkError: BaseFailure() {
        override fun toString(): String {
            return "Network Error"
        }
    }
    object GenericError: BaseFailure() {
        override fun toString(): String {
            return "There was some error"
        }
    }
}
