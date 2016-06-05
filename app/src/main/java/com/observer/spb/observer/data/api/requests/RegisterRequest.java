package com.observer.spb.observer.data.api.requests;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

import java.util.Date;

@AutoValue
@JsonDeserialize(builder = AutoValue_RegisterRequest.Builder.class)
public abstract class RegisterRequest {

    @JsonProperty("app_id")
    @NonNull
    public abstract String appId();

    @JsonFormat(pattern = "YYYY.MM.dd hh:mm:ss.sss")
    @JsonProperty("timestamp")
    @NonNull
    public abstract Date timestamp();

    @JsonProperty("name")
    @NonNull
    public abstract String name();

    @JsonProperty("family_name")
    @NonNull
    public abstract String familyName();

    @JsonProperty("father_name")
    @Nullable
    public abstract String fatherName();

    @JsonProperty("email")
    @Nullable
    public abstract String email();

    @JsonProperty("vk_profile")
    @Nullable
    public abstract String vk();

    @JsonProperty("telegram_profile")
    @Nullable
    public abstract String telegram();

    @JsonProperty("facebook_profile")
    @Nullable
    public abstract String fb();

    @JsonProperty("skype_profile")
    @Nullable
    public abstract String skype();

    @JsonProperty("twitter_profile")
    @Nullable
    public abstract String twitter();

    @NonNull
    public static Builder builder() {
        return new AutoValue_RegisterRequest.Builder();
    }

    @AutoValue.Builder
    public static abstract class Builder {

        @NonNull
        public abstract Builder appId(@NonNull String appId);

        @JsonFormat(pattern = "YYYY.MM.dd hh:mm:ss.sss")
        @NonNull
        public abstract Builder timestamp(@NonNull Date timestamp);

        @JsonProperty("name")
        @NonNull
        public abstract Builder name(@NonNull String name);

        @JsonProperty("family_name")
        @NonNull
        public abstract Builder familyName(@NonNull String familyName);

        @JsonProperty("father_name")
        @NonNull
        public abstract Builder fatherName(@Nullable String fatherName);

        @JsonProperty("email")
        @NonNull
        public abstract Builder email(@Nullable String email);

        @JsonProperty("vk_profile")
        @NonNull
        public abstract Builder vk(@Nullable String vk);

        @JsonProperty("telegram_profile")
        @NonNull
        public abstract Builder telegram(@Nullable String telegram);

        @JsonProperty("facebook_profile")
        @NonNull
        public abstract Builder fb(@Nullable String fb);

        @JsonProperty("skype_profile")
        @NonNull
        public abstract Builder skype(@Nullable String skype);

        @JsonProperty("twitter_profile")
        @NonNull
        public abstract Builder twitter(@Nullable String twitter);

        @NonNull
        public abstract RegisterRequest build();
    }
}
