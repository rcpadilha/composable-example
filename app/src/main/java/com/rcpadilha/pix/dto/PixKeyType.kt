package com.rcpadilha.pix.dto

enum class PixKeyType {
    CPF,
    CNPJ,
    PHONE,
    EMAIL,
    EVP;

    override fun toString(): String {
        return when (this) {
            CPF -> "CPF"
            CNPJ -> "CNPJ"
            PHONE -> "Telefone"
            EMAIL -> "E-mail"
            EVP -> "Chave Aleatória"
            else -> ""
        }
    }
}