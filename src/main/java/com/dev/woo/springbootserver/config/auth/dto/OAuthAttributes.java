package com.dev.woo.springbootserver.config.auth.dto;

import com.dev.woo.springbootserver.domain.user.Role;
import com.dev.woo.springbootserver.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String id;
    private String password;
    private String token;
    private String socialType;
    private LocalDate birth;
    private String gender;
    private Role role;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey,
                           String name, String id, String password, String token,
                           String socialType, LocalDate birth, String gender, Role role) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.id = id;
        this.password = password;
        this.token = token;
        this.socialType = socialType;
        this.birth = birth;
        this.gender = gender;
        this.role = role;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        if ("naver".equals(registrationId)) {
            return ofNaver(userNameAttributeName, attributes);
        } else if("kakao".equals(registrationId)) {
            return ofKakao(userNameAttributeName, attributes);
        }
        else {
            return ofGoogle(userNameAttributeName, attributes);
        }
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>)attributes.get("response");

        return OAuthAttributes.builder()
                .name((String) response.get("name"))
                .id((String) response.get("email"))
                .gender((String) response.get("gender"))
                .password("1234")
                .token("")
                .socialType("naver")
                .birth((LocalDate) response.get("birth"))
                .role(Role.USER)
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>)attributes.get("response");

        return OAuthAttributes.builder()
                .name((String) response.get("name"))
                .id((String) response.get("email"))
                .gender((String) response.get("gender"))
                .password("1234")
                .token("")
                .socialType("kakao")
                .birth((LocalDate) response.get("birth"))
                .role(Role.USER)
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .id((String) attributes.get("email"))
                .gender((String) attributes.get("gender"))
                .password("1234")
                .token("")
                .socialType("google")
                .birth((LocalDate) attributes.get("birth"))
                .role(Role.USER)
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }


    public User toEntity() {
        return User.builder()
                .name(name)
                .id(id)
                .gender(gender)
                .password(password)
                .token(token)
                .socialType(socialType)
                .birth(birth)
                .role(role)
                .build();
    }
}
