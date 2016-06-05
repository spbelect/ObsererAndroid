package com.observer.spb.observer.data.api.requests;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

import java.util.Date;

@AutoValue
@JsonDeserialize(builder = AutoValue_AppInfoRequest.Builder.class)
public abstract class AppInfoRequest {

    @JsonProperty("app_id")
    @NonNull
    public abstract String appId();

    @JsonFormat(pattern = "YYYY.MM.dd hh:mm:ss.sss")
    @JsonProperty("timestamp")
    @NonNull
    public abstract Date timestamp();

    @JsonProperty("os_version")
    @NonNull
    public abstract String osVersion();

    @NonNull
    public static Builder builder() {
        return new AutoValue_AppInfoRequest.Builder();
    }

    @AutoValue.Builder
    public static abstract class Builder {

        @NonNull
        public abstract Builder appId(@NonNull String appId);

        @JsonFormat(pattern = "YYYY.MM.dd hh:mm:ss.sss")
        @NonNull
        public abstract Builder timestamp(@NonNull Date timestamp);

        @NonNull
        public abstract Builder osVersion(@NonNull String osVersion);

        @NonNull
        public abstract AppInfoRequest build();
    }
}
