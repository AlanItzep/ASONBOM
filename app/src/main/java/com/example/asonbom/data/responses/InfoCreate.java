package com.example.asonbom.data.responses;

import com.google.gson.annotations.SerializedName;

public class InfoCreate {
    @SerializedName("status")
    public int status;
    @SerializedName("code")
    public int code;
    @SerializedName("message")
    public int message;
    @SerializedName("emergencia")
    public int emergencia;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public int getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(int emergencia) {
        this.emergencia = emergencia;
    }
}
