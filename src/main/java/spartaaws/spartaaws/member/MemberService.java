package spartaaws.spartaaws.member;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import spartaaws.spartaaws.exception.CustomException;
import spartaaws.spartaaws.exception.ErrorCode;
import spartaaws.spartaaws.S3.S3Service;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final S3Service s3Service;

    public MemberService(
            MemberRepository memberRepository,
            S3Service s3Service
    ) {
        this.memberRepository = memberRepository;
        this.s3Service = s3Service;
    }

    @Transactional
    public MemberResponseDto createMember(MemberRequestDto requestDto) {

        MemberEntity member = new MemberEntity(
                requestDto.getName(),
                requestDto.getAge(),
                requestDto.getMbti()
        );

        MemberEntity savedMember = memberRepository.save(member);

        return new MemberResponseDto(savedMember);
    }

    public MemberResponseDto getMember(Long id) {

        MemberEntity member = memberRepository.findById(id)
                .orElseThrow(() ->
                        new CustomException(ErrorCode.MEMBER_NOT_FOUND));

        return new MemberResponseDto(member);
    }

    // 프로필 이미지 업로드
    @Transactional
    public void uploadProfileImage(Long id, MultipartFile file) {

        MemberEntity member = memberRepository.findById(id)
                .orElseThrow(() ->
                        new CustomException(ErrorCode.MEMBER_NOT_FOUND));

        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("업로드할 이미지 파일이 없습니다.");
        }

        String contentType = file.getContentType();

        if (contentType == null || !contentType.startsWith("image/")) {
            throw new IllegalArgumentException("이미지 파일만 업로드할 수 있습니다.");
        }

        String profileImageKey = s3Service.uploadProfileImage(file);

        member.updateProfileImageKey(profileImageKey);
    }

    // 프로필 이미지 Presigned URL 조회
    public String getProfileImageUrl(Long id) {

        MemberEntity member = memberRepository.findById(id)
                .orElseThrow(() ->
                        new CustomException(ErrorCode.MEMBER_NOT_FOUND));

        String profileImageKey = member.getProfileImageKey();

        if (profileImageKey == null || profileImageKey.isBlank()) {
            throw new IllegalStateException("등록된 프로필 이미지가 없습니다.");
        }

        return s3Service.generatePresignedUrl(profileImageKey);
    }
}
