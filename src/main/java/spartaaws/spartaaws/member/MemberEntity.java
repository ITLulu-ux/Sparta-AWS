package spartaaws.spartaaws.member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String mbti;

    // S3 프로필 이미지 객체 키
    private String profileImageKey;

    public MemberEntity(String name, int age, String mbti) {
        this.name = name;
        this.age = age;
        this.mbti = mbti;
    }

    public void updateProfileImageKey(String profileImageKey) {
        this.profileImageKey = profileImageKey;
    }
}