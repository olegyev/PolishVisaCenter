package app.security.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class LoginResponse implements Serializable {

    @NonNull
    private String jwt;

    @NonNull
    @JsonIgnore
    private String redirectPath;

}