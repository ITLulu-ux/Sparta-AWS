package spartaaws.spartaaws.member;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MemberResponseDto createMember(
            @Valid @RequestBody MemberRequestDto requestDto) {

        return memberService.createMember(requestDto);
    }

    @GetMapping("/{id}")
    public MemberResponseDto getMember(@PathVariable Long id) {

        return memberService.getMember(id);
    }

    // 프로필 이미지 업로드
    @PostMapping(
            value = "/{id}/profile-image",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> uploadProfileImage(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file
    ) {
        memberService.uploadProfileImage(id, file);

        return Map.of("message", "프로필 이미지 업로드 성공");
    }

    // 프로필 이미지 Presigned URL 조회
    @GetMapping("/{id}/profile-image")
    public Map<String, String> getProfileImageUrl(
            @PathVariable Long id
    ) {
        String presignedUrl = memberService.getProfileImageUrl(id);

        return Map.of("presignedUrl", presignedUrl);
    }
}

