package spartaaws.spartaaws.member;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberRequestDto {
    @NotBlank(message = "이름은 필수 입력입니다.")
    @Size(max = 30, message = "이름은 30자 이하여야 합니다.")
    private String name;

    @NotNull(message = "나이는 필수 입력입니다.")
    @Min(value = 20, message = "나이는 20세 이상이어야 합니다.")
    private Integer age;

    @NotBlank(message = "MBTI는 필수 입력입니다.")
    @Pattern(
            regexp = "^(ISTJ|ISFJ|INFJ|INTJ|ISTP|ISFP|INFP|INTP|ESTP|ESFP|ENFP|ENTP|ESTJ|ESFJ|ENFJ|ENTJ)$",
            message = "올바른 MBTI 유형을 입력해야 합니다."
    )
    private String mbti;
}

